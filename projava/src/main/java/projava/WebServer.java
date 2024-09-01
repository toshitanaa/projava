package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class WebServer {
    public static void main(String[] args) throws IOException {
        var server = new ServerSocket(8880);
        for (;;) {
            try (var soc = server.accept();
                 var isr = new InputStreamReader(soc.getInputStream());
                 var bur = new BufferedReader(isr);
                 var w = new PrintWriter(soc.getOutputStream())) {
                System.out.println("Connected from " + soc.getInetAddress());
                bur.lines()
                    .takeWhile(line -> !line.isEmpty())
                    .forEach(System.out::println);
                w.println("""
                    HTTP/1.1 200 OK
                    content-type: text/html

                    <html><head><title>Hello</title></head>
                    <body><h1>Hello</h1>It works!</body></html>
                    """);
            }
        }
    }
}

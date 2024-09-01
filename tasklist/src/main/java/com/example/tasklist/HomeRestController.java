package com.example.tasklist;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeRestController {
    @RequestMapping("/resthello")
    String hello() {
        return """
                Hello.
                It works!
                現在時刻は%sです。
                """.formatted(LocalDateTime.now());
    }
}

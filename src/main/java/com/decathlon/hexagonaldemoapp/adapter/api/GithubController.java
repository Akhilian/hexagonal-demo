package com.decathlon.hexagonaldemoapp.adapter.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {
    @PostMapping("/webhook/github")
    void nouvelEventGithub() {

    }
}

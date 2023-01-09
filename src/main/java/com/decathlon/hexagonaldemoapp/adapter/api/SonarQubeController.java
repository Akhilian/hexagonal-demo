package com.decathlon.hexagonaldemoapp.adapter.api;

import com.decathlon.hexagonaldemoapp.core.commands.CollectSonarCommand;
import com.decathlon.hexagonaldemoapp.core.commands.SonarCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SonarQubeController {

    final SonarCommandHandler sonarCommandHandler;

    public SonarQubeController(SonarCommandHandler sonarCommandHandler) {
        this.sonarCommandHandler = sonarCommandHandler;
    }

    @PostMapping("/webhook/sonar")
    void newSonarCollect(@RequestBody CollectSonarCommand collectSonarCommand) {
        sonarCommandHandler.handle(collectSonarCommand);
    }
}

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

        System.out.println("serverUrl : " + collectSonarCommand.serverUrl);
        System.out.println("taskId : " + collectSonarCommand.taskId);
        System.out.println("status : " + collectSonarCommand.status);
        System.out.println("analysedAt : " + collectSonarCommand.analysedAt);
        System.out.println("revision : " + collectSonarCommand.revision);
        System.out.println("project.key : " + collectSonarCommand.project.key);
        System.out.println("project.url : " + collectSonarCommand.project.url);
        System.out.println("project.name : " + collectSonarCommand.project.name);

        sonarCommandHandler.handle(collectSonarCommand);
    }
}

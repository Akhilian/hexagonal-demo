package com.decathlon.hexagonaldemoapp.core.commands;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CollectSonarCommand implements Command {

    public String serverUrl;
    public String taskId;
    public String status;

    // FIXME: Il y a surement une façon plus simple de formatter les dates
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public Date analysedAt;
    public String revision;

    public SonarProject project;
    public String name;
}

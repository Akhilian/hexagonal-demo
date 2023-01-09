package com.decathlon.hexagonaldemoapp.core.commands;

public class CollectSonarCommand implements Command {

    public String serverUrl;
    public String taskId;
    public String status;

    // FIXME: Il y a surement une façon plus simple de formatter les dates
    public String analysedAt;

    public String revision;

    public SonarProject project;
    public String name;
}

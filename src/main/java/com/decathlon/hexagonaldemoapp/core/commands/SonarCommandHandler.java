package com.decathlon.hexagonaldemoapp.core.commands;

import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Measure;
import com.decathlon.hexagonaldemoapp.adapter.persistence.PostgresMeasureRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SonarCommandHandler implements CommandHandler<CollectSonarCommand, Void> {
    final SonarRepository sonarRepository;

    final PostgresMeasureRepository measureRepository;

    public SonarCommandHandler(SonarRepository sonarRepository, PostgresMeasureRepository measureRepository) {
        this.sonarRepository = sonarRepository;
        this.measureRepository = measureRepository;
    }

    @Override
    public Void handle(CollectSonarCommand collectSonarCommand) {
        ArrayList<Measure> measures = sonarRepository.getMeasures(collectSonarCommand.project.key);

        measureRepository.saveForProject("nom-project", measures);

        return null;
    }
}

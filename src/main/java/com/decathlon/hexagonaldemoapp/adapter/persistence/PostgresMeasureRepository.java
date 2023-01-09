package com.decathlon.hexagonaldemoapp.adapter.persistence;

import com.decathlon.hexagonaldemoapp.core.commands.domain.infrastructure.MeasureRepository;
import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Measure;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PostgresMeasureRepository implements MeasureRepository {
    public void saveForProject(String project, ArrayList<Measure> measures) {
        // TODO Implem avec la BDD
        System.out.println(project);

        for (Measure measure : measures) {
            System.out.println("🗒 - " + measure);
        }
    }
}

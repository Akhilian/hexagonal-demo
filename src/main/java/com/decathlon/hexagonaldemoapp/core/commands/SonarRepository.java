package com.decathlon.hexagonaldemoapp.core.commands;

import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Coverage;
import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Measure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SonarRepository {
    ArrayList<Measure> getMeasures(String key) {
        // TODO Appels à l'API Sonar pour récupérer les mesures qui nous intéresse
        // ...

        ArrayList<Measure> measures = new ArrayList<>();

        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree("""
                        {
                            "coverage": {
                                "value": 80
                            }
                        }
                    """);

            int value = jsonNode.get("coverage").get("value").asInt();
            Coverage coverage = new Coverage(value);
            measures.add(coverage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return measures;
    }
}

package com.decathlon.hexagonaldemoapp.core.commands;

import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Measure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Component
public class SonarRepository {
    ArrayList<Measure> getMeasures(String projectKey, String analysedAt) throws URISyntaxException {

        String metricsToCollect = String.join(",", "coverage", "complexity", "violations", "code_smells",
                "bugs", "vulnerabilities", "security_rating");

        URIBuilder url = new URIBuilder("https://sonarcloud.io/api/measures/search_history");
        url.addParameter("component", projectKey);
        url.addParameter("metrics", metricsToCollect);
        url.addParameter("ps", "1");
        url.addParameter("from", analysedAt);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url.build())
                .build();

        HttpResponse<String> response = null;
        ArrayList<Measure> measures = new ArrayList<>();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode sonarMeasures = new ObjectMapper().readValue(response.body().toString(), JsonNode.class);
            JsonNode jsonMeasures = sonarMeasures.get("measures");

            for (JsonNode measure : jsonMeasures) {
                Measure coverage = Measure.fromSonar(measure);

                measures.add(coverage);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return measures;
    }
}

package com.decathlon.hexagonaldemoapp.core.commands.domain.measures;

import com.fasterxml.jackson.databind.JsonNode;

public record Measure(String analysedAt, String name, String value) {
    public static Measure fromSonar(JsonNode measure) {
        String metricName = measure.get("metric").toString();
        JsonNode lastMeasure = measure.get("history").get(0);
        String datetime = lastMeasure.get("date").toString();
        String value = lastMeasure.get("value").toString();
        return new Measure(datetime, metricName, value);
    }
}

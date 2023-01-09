package com.decathlon.hexagonaldemoapp.core.commands.domain.measures;

import com.fasterxml.jackson.databind.JsonNode;

public class Coverage {
    private final double value;

    public Coverage(String date, double value) {
        this.value = value;
    }

    public static Coverage fromSonar(JsonNode lastMeasure) {
        String datetime = lastMeasure.get("date").toString();
        double value = lastMeasure.get("value").asDouble();
        return new Coverage(datetime, value);
    }
}

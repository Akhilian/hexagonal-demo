package com.decathlon.hexagonaldemoapp.core.commands.domain.infrastructure;

import com.decathlon.hexagonaldemoapp.core.commands.domain.measures.Measure;

import java.util.ArrayList;

public interface MeasureRepository {
    void saveForProject(String s, ArrayList<Measure> measures);
}

package com.logiclytics.productservice.util;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public class Mappers {

    public static ModelMapper createNotNullModelMapper() {
        ModelMapper mapper = new ModelMapper();
        configureModelMapper(mapper);
        return mapper;
    }

    private static void configureModelMapper(ModelMapper mapper) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setPropertyCondition(Conditions.isNotNull());
    }

}


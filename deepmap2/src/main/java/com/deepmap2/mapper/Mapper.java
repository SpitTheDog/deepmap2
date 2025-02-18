package com.deepmap2.mapper;

import java.lang.reflect.Field;
import java.util.Map;

public class Mapper {
    private final Map<Class<?>, Class<?>> classMap;
    private final Map<String, String> fieldMap;
    private final Map<String, String> valueMap;

    public Mapper(Map<Class<?>, Class<?>> classMap, Map<String, String> fieldMap, Map<String, String> valueMap) {
        this.classMap = classMap;
        this.fieldMap = fieldMap;
        this.valueMap = valueMap;
    }

    public <S, T> T map(S source) throws Exception {
        // Get the target class from the class map
        Class<?> targetClass = classMap.get(source.getClass());
        if (targetClass == null) {
            throw new IllegalArgumentException("No mapping found for source class: " + source.getClass());
        }

        // Create an instance of the target class
        T target = (T) targetClass.getDeclaredConstructor().newInstance();

        // Map fields
        for (Field sourceField : source.getClass().getDeclaredFields()) {
            sourceField.setAccessible(true);
            String sourceFieldName = sourceField.getName();
            String targetFieldName = fieldMap.get(sourceFieldName);

            if (targetFieldName != null) {
                Field targetField = targetClass.getDeclaredField(targetFieldName);
                targetField.setAccessible(true);

                // Get the source value
                Object sourceValue = sourceField.get(source);

                // Map the value if a mapping exists
                if (sourceValue instanceof String) {
                    String mappedValue = valueMap.getOrDefault((String) sourceValue, (String) sourceValue);
                    targetField.set(target, mappedValue);
                } else {
                    targetField.set(target, sourceValue);
                }
            }
        }

        return target;
    }

}

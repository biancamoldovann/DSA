package org.datasource.neo4j.convertors;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.time.LocalDate;

public class LocalDateConverter implements AttributeConverter<LocalDate, Object> {

    @Override
    public Object toGraphProperty(LocalDate value) {
        return value != null ? value.toString() : null;
    }

    @Override
    public LocalDate toEntityAttribute(Object value) {
        if (value instanceof String) {
            return LocalDate.parse((String) value);
        } else if (value instanceof LocalDate) {
            return (LocalDate) value;
        } else {
            return null;
        }
    }
}


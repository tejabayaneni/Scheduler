package com.assignment.util;


import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

public class Figureonverter {
	@ReadingConverter
    public static class StatusConverter implements Converter<String, Status> {

        @Override
        public Status convert(final String source) {
            return Status.valueOf(source.toUpperCase());
        }
    }
}

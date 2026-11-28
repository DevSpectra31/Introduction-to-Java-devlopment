package com.example.Hibernate_in_springboot.model;

import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;
import tools.jackson.databind.DeserializationFeature;

@Component
public class BooleanToStringConverter implements AttributeConverter<Boolean,String> {


    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute ==  null) return  null;
        if (attribute == true){
            return "Yes";
        }
        return "No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
       if (dbData.equals("Yes")) return true;
       else if (dbData.equals("No")) return false;

       return null;
    }
}

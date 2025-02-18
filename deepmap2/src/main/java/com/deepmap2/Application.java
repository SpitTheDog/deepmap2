package com.deepmap2;

import com.deepmap2.mapper.Mapper;
import com.deepmap2.source.Person;
import com.deepmap2.source.Role;
import com.deepmap2.target.Employee;
import com.deepmap2.target.Rank;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws Exception {

        // Define class mappings
        Map<Class<?>, Class<?>> classMap = DataFactory.getClassMap();
        // Define field mappings
        Map<String, String> fieldMap = DataFactory.getFieldMap();
        // Define value mappings
        Map<String, String> valueMap = DataFactory.getValueMap();

        // Create mapper
        Mapper mapper = new Mapper(classMap, fieldMap, valueMap);

        // Mapping
        Person person = DataFactory.getPerson();
        System.out.println("Source Person: " + person);
        Employee employee = mapper.map(person);
        System.out.println("Mapped Employee: " + employee);

        Role role = DataFactory.getRole();
        System.out.println("Source Role: " + role);
        Rank rank = mapper.map(role);
        System.out.println("Mapped Rank: " + rank);

    }
}
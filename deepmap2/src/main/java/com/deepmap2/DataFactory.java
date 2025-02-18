package com.deepmap2;

import com.deepmap2.source.Person;
import com.deepmap2.source.Role;
import com.deepmap2.target.Employee;
import com.deepmap2.target.Rank;

import java.util.HashMap;
import java.util.Map;

public class DataFactory {

    public static Map<Class<?>, Class<?>> getClassMap() {
        Map<Class<?>, Class<?>> classMap = new HashMap<>();
        classMap.put(Person.class, Employee.class);
        classMap.put(Role.class, Rank.class);
        return classMap;
    }

    public static Map<String, String> getFieldMap() {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("firstName", "foreName");
        fieldMap.put("admin", "supervisor");
        return fieldMap;
    }

    public static Map<String, String> getValueMap() {
        Map<String, String> valueMap = new HashMap<>();
        // Persons
        valueMap.put("Fred", "Frederick");
        valueMap.put("Madge", "Margaret");
        valueMap.put("Uri", "Uri");
        // Roles
        valueMap.put("Boss", "Supervisor");
        valueMap.put("user", "User");
        valueMap.put("visitor", "Guest");
        return valueMap;
    }

    public static Person getPerson() {
        return new Person("Fred");
    }

    public static Role getRole() {
        return new Role("Boss");
    }

}

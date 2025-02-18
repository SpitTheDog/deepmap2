package com.deepmap2.target;

public class Employee {
    private String foreName;

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    @Override
    public String toString() {
        return "Employee{foreName='" + foreName + "'}";
    }
}
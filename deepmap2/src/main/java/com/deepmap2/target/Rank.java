package com.deepmap2.target;

public class Rank {
    private String supervisor;

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Rank{supervisor='" + supervisor + "'}";
    }
}
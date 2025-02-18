package com.deepmap2.source;

public class Role {
    private String admin;

    public Role(String admin) {
        this.admin = admin;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Role{admin='" + admin + "'}";
    }
}
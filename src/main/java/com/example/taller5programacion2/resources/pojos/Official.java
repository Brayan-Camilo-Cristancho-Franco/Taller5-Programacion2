package com.example.taller5programacion2.resources.pojos;

public class Official {
    private String username;
    private String name;
    private String status;


    public Official(){}

    public Official(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.sapient.model;

public class Trainer {
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String skills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Trainer(String name, String email, String mobile, String skills) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.skills = skills;
    }

    public Trainer(int id, String name, String email, String mobile, String skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.skills = skills;
    }

    public Trainer() {

    }

    @Override
    public String toString() {
        return "Trainer{ id=" + id + ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}

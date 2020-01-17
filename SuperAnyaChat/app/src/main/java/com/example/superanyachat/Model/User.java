package com.example.superanyachat.Model;

import java.util.ArrayList;

public class User {

    private String id;
    private String course;
    private boolean isTeacher;
    private String speciality;
    private String username;
    private String imageURL;
    private String status;
    private String search;
    private String uid;
    private ArrayList<Subject> subjects;

    public User(String id, String username, String imageURL, String status, String search) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.search = search;
    }

    public User(String id, String username, String imageURL, String status, String search, String course, String speciality, boolean isTeacher) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.search = search;
        this.course = course;
        this.speciality = speciality;
        this.isTeacher = isTeacher;
    }




    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getCourse() {
        return course;
    }

    public String getSpec() {
        return speciality;
    }

    public void setSpec(String spec) {
        this.speciality = spec;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}

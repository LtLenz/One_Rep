package com.example.superanyachat.Model;

public class Subject {

    private String id;
    private String title;
    private String course;
    private String spec;
    private String teacher;

    public Subject(String id, String title, String course, String spec, String teacher){
        this.id = id;
        this.title = title;
        this.course = course;
        this.spec = spec;
        this.teacher = teacher;
    }

    public Subject(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSpec() {
        return spec;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }
}

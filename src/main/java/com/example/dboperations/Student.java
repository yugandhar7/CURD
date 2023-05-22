package com.example.dboperations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String stName;
    private String stRollno;
    private String stEmail;

    @Override
    public String toString() {
        return "Student [id=" + id + ", stName=" + stName + ", stRollno=" + stRollno + ", stEmail=" + stEmail + "]";
    }

    public long getId() {
        return id;
    }

    public Student(long id, String stName, String stRollno, String stEmail) {
        this.id = id;
        this.stName = stName;
        this.stRollno = stRollno;
        this.stEmail = stEmail;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStRollno() {
        return stRollno;
    }

    public void setStRollno(String stRollno) {
        this.stRollno = stRollno;
    }

    public String getStEmail() {
        return stEmail;
    }

    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }

    public Student() {

    }

}
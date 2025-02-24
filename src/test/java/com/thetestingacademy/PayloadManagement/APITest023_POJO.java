package com.thetestingacademy.PayloadManagement;

public class APITest023_POJO {
    //POJO Plain Old Java Object class
    //Encapsulated
    //Default constructor
    //Getter Setter
    //Cannot extend any other class
    // used for payload management
    //Benefits - Simplicity , Reusability, Flexibility, Framework Independent
    private String name;
    private Integer age;

    public APITest023_POJO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

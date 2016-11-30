package com.example.armint.testtutor;

/**
 * Created by Armin T on 2016-11-26.
 */

public class Person {

    private static final int NAME_LEN   = 8;
    private static final int COURSE_LEN = 4;

    private String name;
    private String email;
    private String goodCourse;
    private String badCourse;
    private Account account;
    private String description;

    public Person(final String name,
                  final String email,
                  final String goodCourse,
                  final String badCourse,
                  final String userName,
                  final String password) {
        this.setName(name);
        this.setEmail(email);
        this.setBadCourse(badCourse);
        this.setGoodCourse(goodCourse);
        account = new Account(userName, password);

    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBadCourse() {
        return badCourse;
    }

    public String getGoodCourse() {
        return goodCourse;
    }

    public void setBadCourse(String badCourse) {
        if(badCourse != null && badCourse.length() > COURSE_LEN) {
            this.badCourse = badCourse;
        } else {
            //throw up a toast brah
        }
    }

    public void setName(String name) {
        if(name != null && name.length() > NAME_LEN) {
            this.name = name;
        } else {
            //throw a toast
        }
    }

    public void setEmail(String email) {
        this.email = email;
        //add regex to this later
    }

    public void setGoodCourse(String goodCourse) {
        if(goodCourse != null && goodCourse.length() > COURSE_LEN) {
            this.goodCourse = goodCourse;
        } else {
            //throw up a toast brah
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

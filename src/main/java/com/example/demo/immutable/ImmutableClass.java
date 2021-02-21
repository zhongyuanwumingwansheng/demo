package com.example.demo.immutable;

import java.util.Date;

public class ImmutableClass {
    private Date date;

    public ImmutableClass(Date date){
        this.date = (Date)date.clone();
    }

    public void printDate(){
        System.out.println(date);
    }

    public Date getDate(){
        return (Date)date.clone();
    }
}

package com.train;

public class Berth {
    int PNRnumber;
    int berthNumber;
    String berthType;
    String status;
    String name;
    int age;
    public Berth(int PNRnumber,int berthNumber, String berthType, String status,String name,int age)
    {
        this.PNRnumber=PNRnumber;
        this.berthNumber=berthNumber;
        this.berthType=berthType;
        this.status=status;
        this.name=name;
        this.age=age;
    }
}

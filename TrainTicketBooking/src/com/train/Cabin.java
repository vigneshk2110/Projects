package com.train;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Cabin {
    int cabinNumber;
    HashMap<String,Berth> berths= new LinkedHashMap<>();

    public Cabin(int i) {
        this.cabinNumber=i;
        int n=(i*8)-7;

        Berth b= new Berth(0,n+0,"LB","AVL","--",0);
        berths.put(b.berthType+"_"+n,b);

        b= new Berth(0,n+1,"MB","AVL","--",0);
        berths.put(b.berthType+"_"+(n+1),b);

        b= new Berth(0,n+2,"UB","AVL","--",0);
        berths.put(b.berthType+"_"+(n+2),b);

        b= new Berth(0,n+3,"LB","AVL","--",0);
        berths.put(b.berthType+"_"+(n+3),b);

        b= new Berth(0,n+4,"MB","AVL","--",0);
        berths.put(b.berthType+"_"+(n+4),b);

        b= new Berth(0,n+5,"UB","AVL","--",0);
        berths.put(b.berthType+"_"+(n+5),b);
        b= new Berth(0,n+6,"RAC1","--","--",0);
        berths.put(b.berthType+"_"+(n+6),b);
        b= new Berth(0,n+6,"RAC2","--","--",0);
        berths.put(b.berthType+"_"+(n+6),b);
        b= new Berth(0,n+7,"SU","AVL","--",0);
        berths.put(b.berthType+"_"+(n+7),b);
        b= new Berth(0,0,"WL","--","--",0);
        berths.put(b.berthType+"_"+0,b);


    }
}

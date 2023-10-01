package com.train;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Coach {
    int coachNumber;
    HashMap<Integer,Cabin> cabins= new LinkedHashMap<>();

    public Coach(int i) {

        this.coachNumber=i;
    }

    public void addCabin(Cabin c)
    {
        this.cabins.put(c.cabinNumber,c);
    }
}


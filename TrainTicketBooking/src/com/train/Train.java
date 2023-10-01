package com.train;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Train {
    HashMap<Integer,Coach> coaches= new LinkedHashMap<Integer, Coach>();


    public void addCoach(Coach coach) {
        this.coaches.put(coach.coachNumber,coach);
    }
}

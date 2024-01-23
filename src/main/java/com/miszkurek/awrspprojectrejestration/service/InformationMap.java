package com.miszkurek.awrspprojectrejestration.service;

import com.miszkurek.awrspprojectrejestration.data.Contacts;
import com.miszkurek.awrspprojectrejestration.data.User;
import com.miszkurek.awrspprojectrejestration.data.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class InformationMap implements InformationMapInterface{

    private User user;
    private Visit visit;

    @Autowired
    public InformationMap(User user, Visit visit, Contacts contacts) {
        this.user = user;
        this.visit = visit;
    }

    public InformationMap() {
    }

    @Override
    public LinkedHashMap<Visit, User> createVisitMap(List<User> allUserData, List<Visit> allVisitData) {
        LinkedHashMap<Visit, User> allInformationMap = new LinkedHashMap<>();
        for(Visit vd : allVisitData){
            for(User ud : allUserData){
                allInformationMap.put(vd, ud);
            }
        }
        return allInformationMap;
    }
}

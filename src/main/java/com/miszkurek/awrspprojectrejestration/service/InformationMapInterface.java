package com.miszkurek.awrspprojectrejestration.service;

import com.miszkurek.awrspprojectrejestration.data.User;
import com.miszkurek.awrspprojectrejestration.data.Visit;

import java.util.LinkedHashMap;
import java.util.List;

public interface InformationMapInterface {
    LinkedHashMap<Visit, User> createVisitMap(List<User> allUserData, List<Visit> allVisitData);

}

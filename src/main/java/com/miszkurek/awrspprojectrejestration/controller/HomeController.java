package com.miszkurek.awrspprojectrejestration.controller;

import com.miszkurek.awrspprojectrejestration.data.Contacts;
import com.miszkurek.awrspprojectrejestration.data.User;
import com.miszkurek.awrspprojectrejestration.data.Visit;
import com.miszkurek.awrspprojectrejestration.service.InformationMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
    private User userData;
    private Visit visitData;
    private Contacts contacts;
    private User lastAddedUserData;
    private Visit lastAddedVisitData;
    private List<Visit> allVisitData;
    private List<User> allUserData;
    private InformationMap allInformationMap;

    @Autowired
    public HomeController(User userData, Visit visitData, List<Visit> allVisitData,
                          List<User> allUserData,Contacts contacts, InformationMap allInformationMap) {
        this.userData = userData;
        this.visitData = visitData;
        this.allVisitData = allVisitData;
        this.allUserData = allUserData;
        this.contacts = contacts;
        this.allInformationMap = allInformationMap;
    }

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String indexPost(){
        return "index";
    }

    @GetMapping("/visitPage")
    public String visitPage(){
        return "visitPage";
    }

    @PostMapping("/visitPage")
    public String visitPagePost(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("pesel") String pesel,
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                @RequestParam(value = "dateOfBirth")
                                LocalDate dateOfBirth,
                                @RequestParam("street") String street,
                                @RequestParam("city") String city,
                                @RequestParam("zipCode") String zipCode,
                                @RequestParam("phoneNumber") String phoneNumber,
                                @RequestParam("email") String email,
                                @RequestParam("selected-doctor") String selectedDoctor,
                                @RequestParam("dateTime") LocalDateTime dateTime){
        try {
            List<User> allUserData = userData.allUserData();
            Contacts newContacts = new Contacts(street,city,zipCode,phoneNumber,email);
            User newUser = new User(firstName, lastName, pesel, dateOfBirth, newContacts);

            List<Visit> allVisitData = visitData.allVisitData();
            List<Visit> allVisitDataClone = visitData.allVisitData();
            Visit newVisitData = new Visit(selectedDoctor, dateTime);

            InformationMap allInformationMap = new InformationMap();
            Map<Visit, User> allinfoMap = allInformationMap.createVisitMap(allUserData, allVisitData);

            for(Visit vd : allVisitDataClone) {
                if (!newVisitData.equals(vd)) {
                    allUserData.add(newUser);
                    allVisitData.add(newVisitData);
                    allinfoMap.put(newVisitData, newUser);
                    lastAddedUserData = newUser;
                    lastAddedVisitData = newVisitData;
                }
                else {
                    logger.error("Error adding record into map");
                }
            }

            for (Map.Entry<Visit, User> entry: allinfoMap.entrySet()){
                logger.info("Key: {}", entry.getKey());
                logger.info("Value: {}", entry.getValue());
            }
        } catch(Exception e){
            logger.error("Error creating Visit", e);
        }

        return "redirect:/finalPage";
    }

    @GetMapping("/finalPage")
    public String finalPage(Model model){
        model.addAttribute("firstName", lastAddedUserData.getFirstName());
        model.addAttribute("lastName", lastAddedUserData.getLastName());
        model.addAttribute("visitDate", lastAddedVisitData.getDateAndTime());
        model.addAttribute("physician", lastAddedVisitData.getPhysician());

        return "finalPage";
    }

    @PostMapping("/finalPage")
    public String finalPagePost(){
        return "redirect:/index";
    }
}
package com.miszkurek.awrspprojectrejestration.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Visit {
    private String physician;
    private LocalDateTime dateAndTime;

    public Visit(String physician, LocalDateTime dateAndTime) {
        this.physician = physician;
        this.dateAndTime = dateAndTime;
    }

    public Visit() {
    }

    public List<Visit> allVisitData(){
        List<Visit> allVisitData = new ArrayList<>();
        allVisitData.add(new Visit("Mariusz Kowalski - kardiolog",  LocalDateTime.of(2024, 1, 20, 10, 30)));
        allVisitData.add(new Visit("Mariusz Kowalski - kardiolog",  LocalDateTime.of(2024, 1, 13, 10, 30)));
        allVisitData.add(new Visit("Maria Kowalczyk - ginekolog",  LocalDateTime.of(2024, 2, 10, 12, 15)));
        allVisitData.add(new Visit("Kamil Koźlicki - okulista",  LocalDateTime.of(2024, 2, 20, 14, 30)));
        allVisitData.add(new Visit("Kamil Koźlicki - okulista",  LocalDateTime.of(2024, 2, 20, 15, 30)));
        allVisitData.add(new Visit("Kamil Koźlicki - okulista",  LocalDateTime.of(2024, 2, 20, 14, 0)));
        allVisitData.add(new Visit("Kinga Sofa - dentysta",  LocalDateTime.of(2024, 1, 30, 9, 30)));
        allVisitData.add(new Visit("Kinga Sofa - dentysta",  LocalDateTime.of(2024, 1, 21, 9, 30)));
        allVisitData.add(new Visit("Ewa Kalinowska - pediatra",  LocalDateTime.of(2024, 1, 20, 13, 45)));
        allVisitData.add(new Visit("Aleksandra Łukaszek - psychiatra ",  LocalDateTime.of(2024, 1, 13, 17, 0)));

        return allVisitData;
    }
}
package com.miszkurek.awrspprojectrejestration;

import com.miszkurek.awrspprojectrejestration.data.Contacts;
import com.miszkurek.awrspprojectrejestration.data.User;
import com.miszkurek.awrspprojectrejestration.data.Visit;
import com.miszkurek.awrspprojectrejestration.service.InformationMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AwrspProjectRejestrationApplicationTests {

    private InformationMap informationMap = new InformationMap();

    @Test
    public void testCreateVisitMap() {

        List<User> allUserData = createSampleUserData();
        List<Visit> allVisitData = createSampleVisitData();

        LinkedHashMap<Visit, User> result = informationMap.createVisitMap(allUserData, allVisitData);

        assertEquals(allVisitData.size(), result.size(), "Size of the result map should match the number of visits");

        for (Visit visit : allVisitData) {
            User associatedUser = result.get(visit);

            assertEquals(true, allUserData.contains(associatedUser), "Unexpected user associated with visit");
        }
    }

    private List<User> createSampleUserData() {
        List<User> sampleUserData = new ArrayList<>();
        sampleUserData.add(new User("test1", "test1Nazw", "1234567890", LocalDate.of(1990, 1, 1), new Contacts("Address1", "City1", "12345", "123456789", "test1@mail.com")));
        sampleUserData.add(new User("test2", "test2Nazw", "9876543210", LocalDate.of(1985, 5, 15), new Contacts("Address2", "City2", "54321", "987654321", "test2@mail.com")));

        return sampleUserData;
    }


    private List<Visit> createSampleVisitData() {
        List<Visit> sampleVisitData = new ArrayList<>();
        sampleVisitData.add(new Visit("Adam Kowalski - kardiolog", LocalDateTime.of(2022, 1, 10,1,10)));
        sampleVisitData.add(new Visit("Kinga Sowa - dentysta",LocalDateTime.of(2022, 2, 20,10,0)));

        return sampleVisitData;
    }

}

package com.miszkurek.awrspprojectrejestration.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class User {
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate dateOfBirth;
    private Contacts contacts;

    public User(String firstName, String lastName, String pesel, LocalDate dateOfBirth, Contacts contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.dateOfBirth=dateOfBirth;
        this.contacts = contacts;
    }

    public User(){

    }

    public List<User> allUserData(){
        List<User> allUserData = new ArrayList<>();
        allUserData.add(new User("Anna", "Kowalska", "95010212345", LocalDate.of(1995,1,2), new Contacts("Kwiatowa 10", "Warszawa", "01-234", "123456789", "anna.kowalska@mail.com")));
        allUserData.add(new User("Piotr", "Nowak", "88050456789", LocalDate.of(1988,5,4), new Contacts("Słoneczna 25", "Kraków", "15-624", "951741236", "piotr.nowak@mail.com")));
        allUserData.add(new User("Marta", "Wiśniewska", "76121398765", LocalDate.of(1976,12,13), new Contacts("Wolności 8", "Lublin", "18-003", "825475989", "martwa.wisniewska@mail.com")));
        allUserData.add(new User("Jan", "Kowalczyk", "90070123456", LocalDate.of(1990,7,1), new Contacts("Miodowa", "Gdańsk", "02-784", "369874521", "jan.kowalczyk@mail.com")));
        allUserData.add(new User("Ewa", "Nowicka", "83030587654", LocalDate.of(1983,3,5), new Contacts("Spacerowa 30", "Szczecin", "14-369", "321456987", "ewa.nowicka@mail.com")));
        allUserData.add(new User("Michał", "Kaczamarek", "91062034567", LocalDate.of(1991,6,20), new Contacts("Ogrodowa 23", "Rzeszów", "18-789", "147852369", "michal.kaczmarek@mail.com")));
        allUserData.add(new User("Joanna", "Jankowska", "88101065432", LocalDate.of(1988,10,10), new Contacts("Księżycowa 12", "Lubartów", "32-753", "159025841", "joanna.jankowska@mail.com")));
        allUserData.add(new User("Paweł", "Malinowski", "80081578901", LocalDate.of(1980,8,15), new Contacts("Jana Pawła 21", "Lublin", "25-159", "963852014", "pawel.malinowski@mail.com")));
        allUserData.add(new User("Katarzyna", "Nowakowska", "94021543210", LocalDate.of(1994,2,15), new Contacts("Polna 12", "Świdnik", "36-687", "753951852", "katarzyna.nowakowska@mail.com")));
        allUserData.add(new User("Łukasz", "Wojciechowski", "87073123456", LocalDate.of(1987,7,31), new Contacts("Parkowa 10", "Bydgoszcz", "12-357", "357159852", "lukasz.wojciechowski@mail.com")));

        return allUserData;
    }
}

package com.miszkurek.awrspprojectrejestration.data;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Contacts {
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String email;

    public Contacts(String street, String city, String zipCode, String phoneNumber, String email) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contacts() {
    }
}

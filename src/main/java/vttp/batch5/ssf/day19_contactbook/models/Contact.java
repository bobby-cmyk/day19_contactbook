package vttp.batch5.ssf.day19_contactbook.models;

import java.time.LocalDate;

public class Contact {
    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

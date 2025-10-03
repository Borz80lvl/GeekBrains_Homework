package model;

import java.io.Serializable;

public class Member implements Serializable {
    protected String firstName;
    protected int birthYear;
    protected String otherInformation;

    @Override
    public String toString() {
        return "Member = {\n" +
                "firstName: " + firstName + "\n," +
                "birthYear: " + birthYear + "\n," +
                "otherInformation: " + otherInformation + "\n" +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}

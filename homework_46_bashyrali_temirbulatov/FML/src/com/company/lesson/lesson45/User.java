package com.company.lesson.lesson45;

public class User {
    private String firstName;
    private String lastName;
    private String middleName = null;
    private boolean emailConfirmed = false;
    private String email;

    public User(String firstName) {
        this(firstName, null, null);
    }

    public User(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public User(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = firstName + "@test.mail";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", emailConfirmed=" + emailConfirmed +
                ", email='" + email + '\'' +
                '}';
    }
}

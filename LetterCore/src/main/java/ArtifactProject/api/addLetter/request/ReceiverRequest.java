package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ReceiverRequest {

    @NotBlank
    private String surname;

    private String name;
    @NotBlank
    private String phoneNumber;
    @Email
    private String email;

    public String getSurname() {
        return surname;
    }

    public ReceiverRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReceiverRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ReceiverRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ReceiverRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}

package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SenderRequest {

    @NotBlank
    private String surname2;
    @NotBlank
    private String phoneNumber2;
    @Email
    private String email2;

    public String getSurname2() {
        return surname2;
    }

    public SenderRequest setSurname2(String surname2) {
        this.surname2 = surname2;
        return this;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public SenderRequest setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public SenderRequest setEmail2(String email2) {
        this.email2 = email2;
        return this;
    }
}

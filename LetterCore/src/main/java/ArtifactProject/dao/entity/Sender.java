package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
public class Sender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;
    private String phoneNumber;
    private String email;

    @OneToOne(mappedBy = "sender")
    private Letter letter;

    public Sender() {
    }

    public Long getId() {
        return id;
    }

    public Sender setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Sender setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Sender setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Sender setEmail(String email) {
        this.email = email;
        return this;
    }

    public Letter getLetter() {
        return letter;
    }

    public Sender setLetter(Letter letter) {
        this.letter = letter;
        return this;
    }
}

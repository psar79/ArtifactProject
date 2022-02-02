package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    @OneToOne(mappedBy = "receiver")
    private Letter letter;

    public Receiver() {
    }

    public Long getId() {
        return id;
    }

    public Receiver setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Receiver setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Receiver setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Receiver setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Receiver setEmail(String email) {
        this.email = email;
        return this;
    }

    public Letter getLetter() {
        return letter;
    }

    public Receiver setLetter(Letter letter) {
        this.letter = letter;
        return this;
    }
}

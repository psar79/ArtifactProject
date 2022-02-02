package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
public class ReceiverAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String postCode;
    private String city;
    private String street;
    private String buildingNumber;
    private String flatNumber;

    @OneToOne(mappedBy = "receiverAddress")
    private Letter letter;

    public ReceiverAddress() {
    }

    public Long getId() {
        return id;
    }

    public ReceiverAddress setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public ReceiverAddress setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ReceiverAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ReceiverAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public ReceiverAddress setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public ReceiverAddress setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }

    public Letter getLetter() {
        return letter;
    }

    public ReceiverAddress setLetter(Letter letter) {
        this.letter = letter;
        return this;
    }
}

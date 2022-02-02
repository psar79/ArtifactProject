package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
public class SenderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String postcode;
    private String city;
    private String buildingNumber;
    private String flatNumber;

    @OneToOne(mappedBy = "senedrAddress")
    private Letter letter;

    public SenderAddress() {
    }

    public Long getId() {
        return id;
    }

    public SenderAddress setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public SenderAddress setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public SenderAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public SenderAddress setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public SenderAddress setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }

    public Letter getLetter() {
        return letter;
    }

    public SenderAddress setLetter(Letter letter) {
        this.letter = letter;
        return this;
    }
}

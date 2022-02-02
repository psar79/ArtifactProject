package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.NotBlank;

public class ReceiverAddressRequest {

    @NotBlank
    private String postCode;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String buildingNumber;
    @NotBlank
    private String flatNumber;

    public String getPostCode() {
        return postCode;
    }

    public ReceiverAddressRequest setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ReceiverAddressRequest setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ReceiverAddressRequest setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public ReceiverAddressRequest setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public ReceiverAddressRequest setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }
}

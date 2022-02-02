package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.NotBlank;

public class SenderAddressRequest {

    @NotBlank
    private String postcode;
    private String city;
    private String buildingNumber;
    private String flatNumber;

    public String getPostcode() {
        return postcode;
    }

    public SenderAddressRequest setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public SenderAddressRequest setCity(String city) {
        this.city = city;
        return this;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public SenderAddressRequest setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public SenderAddressRequest setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
        return this;
    }
}

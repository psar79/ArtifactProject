package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.NotBlank;

public class InformationRequest {

    @NotBlank
    private int size;
    @NotBlank
    private TypeRequest typeRequest;
    private String additionalInfo;

    public int getSize() {
        return size;
    }

    public InformationRequest setSize(int size) {
        this.size = size;
        return this;
    }

    public TypeRequest getTypeRequest() {
        return typeRequest;
    }

    public InformationRequest setTypeRequest(TypeRequest typeRequest) {
        this.typeRequest = typeRequest;
        return this;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public InformationRequest setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }
}

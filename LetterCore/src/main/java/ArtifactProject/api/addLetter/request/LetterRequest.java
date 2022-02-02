package ArtifactProject.api.addLetter.request;

import javax.validation.constraints.NotNull;

public class LetterRequest {

    private Long id;
    @NotNull
    private SenderRequest senderRequest;
    @NotNull
    private SenderAddressRequest senderAddressRequest;
    private ReceiverRequest receiverRequest;
    private ReceiverAddressRequest receiverAddressRequest;
    private InformationRequest informationRequest;

    public Long getId() {
        return id;
    }

    public LetterRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public SenderRequest getSenderRequest() {
        return senderRequest;
    }

    public LetterRequest setSenderRequest(SenderRequest senderRequest) {
        this.senderRequest = senderRequest;
        return this;
    }

    public SenderAddressRequest getSenderAddressRequest() {
        return senderAddressRequest;
    }

    public LetterRequest setSenderAddressRequest(SenderAddressRequest senderAddressRequest) {
        this.senderAddressRequest = senderAddressRequest;
        return this;
    }

    public ReceiverRequest getReceiverRequest() {
        return receiverRequest;
    }

    public LetterRequest setReceiverRequest(ReceiverRequest receiverRequest) {
        this.receiverRequest = receiverRequest;
        return this;
    }

    public ReceiverAddressRequest getReceiverAddressRequest() {
        return receiverAddressRequest;
    }

    public LetterRequest setReceiverAddressRequest(ReceiverAddressRequest receiverAddressRequest) {
        this.receiverAddressRequest = receiverAddressRequest;
        return this;
    }

    public InformationRequest getInformationRequest() {
        return informationRequest;
    }

    public LetterRequest setInformationRequest(InformationRequest informationRequest) {
        this.informationRequest = informationRequest;
        return this;
    }
}

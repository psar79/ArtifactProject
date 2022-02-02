package ArtifactProject.api.getByPhoneNumber;

public class LetterByPhoneNumberResponse {

    private Long id;
    private SenderByPhoneResponse senderByPhoneResponse;
    private SenderAddressByPhoneResponse senderAddressByPhoneResponse;
    private ReceiverByPhoneResponse receiverByPhoneResponse;
    private ReceiverAddressByPhoneResponse receiverAddressByPhoneResponse;
    private InformationByPhoneResponse informationByPhoneResponse;

    public Long getId() {
        return id;
    }

    public LetterByPhoneNumberResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public SenderByPhoneResponse getSenderByPhoneResponse() {
        return senderByPhoneResponse;
    }

    public LetterByPhoneNumberResponse setSenderByPhoneResponse(SenderByPhoneResponse senderByPhoneResponse) {
        this.senderByPhoneResponse = senderByPhoneResponse;
        return this;
    }

    public SenderAddressByPhoneResponse getSenderAddressByPhoneResponse() {
        return senderAddressByPhoneResponse;
    }

    public LetterByPhoneNumberResponse setSenderAddressByPhoneResponse(SenderAddressByPhoneResponse senderAddressByPhoneResponse) {
        this.senderAddressByPhoneResponse = senderAddressByPhoneResponse;
        return this;
    }

    public ReceiverByPhoneResponse getReceiverByPhoneResponse() {
        return receiverByPhoneResponse;
    }

    public LetterByPhoneNumberResponse setReceiverByPhoneResponse(ReceiverByPhoneResponse receiverByPhoneResponse) {
        this.receiverByPhoneResponse = receiverByPhoneResponse;
        return this;
    }

    public ReceiverAddressByPhoneResponse getReceiverAddressByPhoneResponse() {
        return receiverAddressByPhoneResponse;
    }

    public LetterByPhoneNumberResponse setReceiverAddressByPhoneResponse(ReceiverAddressByPhoneResponse receiverAddressByPhoneResponse) {
        this.receiverAddressByPhoneResponse = receiverAddressByPhoneResponse;
        return this;
    }

    public InformationByPhoneResponse getInformationByPhoneResponse() {
        return informationByPhoneResponse;
    }

    public LetterByPhoneNumberResponse setInformationByPhoneResponse(InformationByPhoneResponse informationByPhoneResponse) {
        this.informationByPhoneResponse = informationByPhoneResponse;
        return this;
    }
}

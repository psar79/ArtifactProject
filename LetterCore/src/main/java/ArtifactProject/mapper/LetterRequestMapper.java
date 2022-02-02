package ArtifactProject.mapper;

import ArtifactProject.api.addLetter.request.*;
import ArtifactProject.dao.entity.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LetterRequestMapper {

    public Letter mapToLetter(LetterRequest letterRequest){
        if(Objects.isNull(letterRequest)
                || Objects.isNull(letterRequest.getSenderRequest())
                || Objects.isNull(letterRequest.getSenderAddressRequest())
                || Objects.isNull(letterRequest.getReceiverRequest())
                || Objects.isNull(letterRequest.getReceiverAddressRequest())
                || Objects.isNull(letterRequest.getInformationRequest())) {
            return null;
        }
        SenderRequest senderRequest = letterRequest.getSenderRequest();

        Sender sender = new Sender();
        sender.setSurname(senderRequest.getSurname2());
        sender.setPhoneNumber(senderRequest.getPhoneNumber2());
        sender.setEmail(senderRequest.getEmail2());

        SenderAddressRequest senderAddressRequest = letterRequest.getSenderAddressRequest();

        SenderAddress senderAddress = new SenderAddress();
        senderAddress.setBuildingNumber(senderAddressRequest.getBuildingNumber());
        senderAddress.setCity(senderAddressRequest.getCity());
        senderAddress.setFlatNumber(senderAddressRequest.getFlatNumber());
        senderAddress.setPostcode(senderAddressRequest.getPostcode());

        ReceiverRequest receiverRequest = letterRequest.getReceiverRequest();

        Receiver receiver = new Receiver();
        receiver.setName(receiverRequest.getName());
        receiver.setSurname(receiverRequest.getSurname());
        receiver.setPhoneNumber(receiverRequest.getPhoneNumber());
        receiver.setEmail(receiverRequest.getEmail());

        ReceiverAddressRequest receiverAddressRequest = letterRequest.getReceiverAddressRequest();

        ReceiverAddress receiverAddress = new ReceiverAddress();
        receiverAddress.setPostCode(receiverAddressRequest.getPostCode());
        receiverAddress.setCity(receiverAddressRequest.getCity());
        receiverAddress.setStreet(receiverAddressRequest.getStreet());
        receiverAddress.setBuildingNumber(receiverAddressRequest.getBuildingNumber());
        receiverAddress.setFlatNumber(receiverAddressRequest.getFlatNumber());

        InformationRequest informationRequest = letterRequest.getInformationRequest();

        Information information = new Information();
        information.setSize(informationRequest.getSize());

        Letter letter = new Letter();
        letter.setSender(sender);
        letter.setSenderAddress(senderAddress);
        letter.setReceiver(receiver);
        letter.setReceiverAddress(receiverAddress);
        letter.setInformation(information);

        return letter;
    }




}

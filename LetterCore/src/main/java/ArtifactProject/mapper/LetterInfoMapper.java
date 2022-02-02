package ArtifactProject.mapper;

import ArtifactProject.api.findAll.response.*;
import ArtifactProject.dao.entity.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LetterInfoMapper {

    public LetterInfo mapToResponse(List<Letter> letters){

        List<LetterResponse> letterResponse = Optional.ofNullable(letters).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(letter -> toLetterResponse(letter))
                .collect(Collectors.toList());

        LetterInfo letterInfo = new LetterInfo();
        letterInfo.setLetterResponses(letterResponse);
        letterInfo.setQuantity(letterResponse.size());

        return letterInfo;
    }

    public LetterResponse toLetterResponse(Letter letter) {

        if(Objects.isNull(letter) || Objects.isNull(letter.getSender()) || Objects.isNull(letter.getSenderAddress())
                || Objects.isNull(letter.getReceiver()) || Objects.isNull(letter.getReceiverAddress())){
            return null;
        }
        Sender sender = letter.getSender();
        SenderResponse senderResponse = new SenderResponse();
        senderResponse.setSurnameResponse(sender.getSurname());
        senderResponse.setPhoneNumberResponse(sender.getPhoneNumber());
        senderResponse.setEmailResponse(sender.getEmail());

        SenderAddress senderAddress = letter.getSenderAddress();
        SenderAddressResponse senderAddressResponse = new SenderAddressResponse();
        senderAddressResponse.setBuildingNumberResponse(senderAddress.getBuildingNumber());
        senderAddressResponse.setCityResponse(senderAddress.getCity());
        senderAddressResponse.setFlatNumberResponse(senderAddress.getFlatNumber());
        senderAddressResponse.setPostcodeResponse(senderAddress.getPostcode());


        Receiver receiver = letter.getReceiver();
        ReceiverResponse receiverResponse = new ReceiverResponse();
        receiverResponse.setNameResponse(receiver.getName());
        receiverResponse.setSurnameResponse(receiver.getSurname());
        receiverResponse.setEmailResponse(receiver.getEmail());
        receiverResponse.setPhoneNumberResponse(receiver.getPhoneNumber());


        ReceiverAddress receiverAddress = letter.getReceiverAddress();
        ReceiverAddressResponse receiverAddressResponse = new ReceiverAddressResponse();
        receiverAddressResponse.setBuildingNumberResponse(receiverAddress.getBuildingNumber());
        receiverAddressResponse.setCityResponse(receiverAddress.getCity());
        receiverAddressResponse.setFlatNumberResponse(receiverAddress.getFlatNumber());
        receiverAddressResponse.setPostCodeResponse(receiverAddress.getPostCode());

        Information information = letter.getInformation();
        InformationResponse informationResponse = new InformationResponse();
        informationResponse.setSizeResponse(information.getSize());
//        informationResponse.setTypeResponse(information.getType());

        LetterResponse letterResponse = new LetterResponse();
        letterResponse.setId(letter.getId());
        letterResponse.setSenderResponse(senderResponse);
        letterResponse.setSenderAddressResponse(senderAddressResponse);
        letterResponse.setReceiverResponse(receiverResponse);
        letterResponse.setReceiverAddressResponse(receiverAddressResponse);
        letterResponse.setInformationResponse(informationResponse);

        return letterResponse;


    }

}

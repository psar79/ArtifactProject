package ArtifactProject.mapper;

import ArtifactProject.api.getByPhoneNumber.*;
import ArtifactProject.dao.entity.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LetterByPhoneNumberMapper {

    public LettersByPhoneNumberResponse mapToLetterByPhoneNumberResponse (List<Letter> letters){


        List<LetterByPhoneNumberResponse> letterByPhoneNumberResponses = Optional.ofNullable(letters).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(letter -> toLetterByPhoneNumberResponse(letter))
                .collect(Collectors.toList());
        LettersByPhoneNumberResponse lettersByPhoneNumberResponse = new LettersByPhoneNumberResponse();
        return lettersByPhoneNumberResponse.setLetterByPhoneNumberResponseReceiverList(letterByPhoneNumberResponses);
    }

    private LetterByPhoneNumberResponse toLetterByPhoneNumberResponse(Letter letter) {

        Sender sender = letter.getSender();
        SenderAddress senderAddress = letter.getSenderAddress();
        Receiver receiver = letter.getReceiver();
        ReceiverAddress receiverAddress = letter.getReceiverAddress();
        Information information = letter.getInformation();

        SenderByPhoneResponse senderByPhoneResponse = new SenderByPhoneResponse();
        SenderAddressByPhoneResponse senderAddressByPhoneResponse = new SenderAddressByPhoneResponse();
        ReceiverByPhoneResponse receiverByPhoneResponse = new ReceiverByPhoneResponse();
        ReceiverAddressByPhoneResponse receiverAddressByPhoneResponse = new ReceiverAddressByPhoneResponse();
        InformationByPhoneResponse informationByPhoneResponse = new InformationByPhoneResponse();

        senderByPhoneResponse.setPhoneNumberByPhoneResponse(sender.getPhoneNumber());
        senderByPhoneResponse.setEmailByPhoneResponse(sender.getEmail());
        senderByPhoneResponse.setSurnameByPhoneResponse(sender.getSurname());

        senderAddressByPhoneResponse.setBuildingNumberByPhoneResponse(senderAddress.getBuildingNumber());
        senderAddressByPhoneResponse.setCityByPhoneResponse(senderAddress.getCity());
        senderAddressByPhoneResponse.setFlatNumberByPhoneResponse(senderAddress.getFlatNumber());
        senderAddressByPhoneResponse.setPostcodeByPhoneResponse(senderAddress.getPostcode());

        receiverByPhoneResponse.setEmailByPhoneResponse(receiver.getEmail());
        receiverByPhoneResponse.setNameByPhoneResponse(receiver.getName());
        receiverByPhoneResponse.setPhoneNumberByPhoneResponse(receiver.getPhoneNumber());
        receiverByPhoneResponse.setSurnameByPhoneResponse(receiver.getSurname());

        receiverAddressByPhoneResponse.setBuildingNumberByPhoneResponse(receiverAddress.getBuildingNumber());
        receiverAddressByPhoneResponse.setCityByPhoneResponse(receiverAddress.getCity());
        receiverAddressByPhoneResponse.setFlatNumberByPhoneResponse(receiverAddress.getFlatNumber());
        receiverAddressByPhoneResponse.setPostCodeByPhoneResponse(receiverAddress.getPostCode());
        receiverAddressByPhoneResponse.setStreetByPhoneResponse(receiverAddress.getStreet());
        informationByPhoneResponse.setSize(information.getSize());

        LetterByPhoneNumberResponse letterByPhoneNumberResponse = new LetterByPhoneNumberResponse();
        letterByPhoneNumberResponse.setSenderByPhoneResponse(senderByPhoneResponse);
        letterByPhoneNumberResponse.setSenderAddressByPhoneResponse(senderAddressByPhoneResponse);
        letterByPhoneNumberResponse.setReceiverByPhoneResponse(receiverByPhoneResponse);
        letterByPhoneNumberResponse.setReceiverAddressByPhoneResponse(receiverAddressByPhoneResponse);
        letterByPhoneNumberResponse.setInformationByPhoneResponse(informationByPhoneResponse);

        return letterByPhoneNumberResponse;
    }
}

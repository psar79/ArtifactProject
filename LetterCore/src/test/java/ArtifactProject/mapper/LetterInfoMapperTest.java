package ArtifactProject.mapper;

import ArtifactProject.api.findAll.response.LetterInfo;
import ArtifactProject.dao.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterInfoMapperTest {

    private LetterInfoMapper letterInfoMapper;

    @BeforeEach
    void setUp() {
        this.letterInfoMapper = new LetterInfoMapper();
    }

    @Test
    @DisplayName("Sprawdza czy rezultat jest ok jeżeli wyszttkie pola są dane")
    void checkIfResultIsOkWhenSurnameIsGiven() {

        //given
        Sender sender = new Sender();
        sender.setSurname("Piotr S");
        Letter letter = new Letter();
        letter.setSender(sender);
        letter.setSenderAddress(new SenderAddress());
        letter.setReceiver(new Receiver());
        letter.setReceiverAddress(new ReceiverAddress());
        letter.setInformation(new Information());
        List<Letter> letters = Arrays.asList(letter);

        //when
        LetterInfo letterInfo = letterInfoMapper.mapToResponse(letters);

        //then
        assertEquals("Piotr S", letterInfo.getLetterResponses().get(0).getSenderResponse().getSurnameResponse());

    }

    @Test
    @DisplayName("All fields are null")
    void checkIfResultIsOkWhenAllFieldsAreNull() {

        //given
        Letter letter = new Letter();
        letter.setSender(null);
        letter.setSenderAddress(null);
        letter.setReceiver(null);
        letter.setReceiverAddress(null);
        letter.setInformation(null);
        List<Letter> letters = Arrays.asList(letter);

        //when
        LetterInfo letterInfo = letterInfoMapper.mapToResponse(letters);

        //then
        assertNull(letterInfo.getLetterResponses().get(0));
    }

    @Test
    @DisplayName("List is null")
    void checkIfResultIsOkWhenListIsNull() {

        //given

        List<Letter> letters = null;

        //when
        LetterInfo letterInfo = letterInfoMapper.mapToResponse(letters);

        //then
        assertEquals(Collections.emptyList(), letterInfo.getLetterResponses());
    }
    @Test
    @DisplayName("All fields are empty")
    void checkIfResultIsOkWhenSomeFieldsAreEmpty() {

        //given
        Sender sender = new Sender();
        sender.setSurname("");
        SenderAddress senderAddress = new SenderAddress();
        senderAddress.setCity("");
        Receiver receiver = new Receiver();
        receiver.setEmail("");
        ReceiverAddress receiverAddress = new ReceiverAddress();
        receiverAddress.setFlatNumber("");
        Information information = new Information();
        information.setType(Type.A);
        information.setSize(0);
        information.setId(null);

        Letter letter = new Letter();
        letter.setSender(sender);
        letter.setSenderAddress(senderAddress);
        letter.setReceiver(receiver);
        letter.setReceiverAddress(receiverAddress);
        letter.setInformation(information);
        List<Letter> letters = Arrays.asList(letter);

        //when
        LetterInfo letterInfo = letterInfoMapper.mapToResponse(letters);

        //then
        assertEquals(null,letterInfo.getLetterResponses().get(0).getInformationResponse().getTypeResponse());
    }

}
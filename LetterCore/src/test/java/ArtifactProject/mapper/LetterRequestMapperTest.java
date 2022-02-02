package ArtifactProject.mapper;

import ArtifactProject.api.addLetter.request.*;
import ArtifactProject.dao.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LetterRequestMapperTest {

    private LetterRequestMapper letterRequestMapper;

    @BeforeEach
    void seUp(){
        this.letterRequestMapper =  new LetterRequestMapper();
    }

    @Test
    @DisplayName("Sprawdzenie happy path")
    void checkIfResultIsOkWhenSurnameIsGiven(){

        //given
        LetterRequest letterRequest = new LetterRequest();
        letterRequest.setSenderRequest(new SenderRequest()
                .setSurname2("Woj"));
        letterRequest.setSenderAddressRequest(new SenderAddressRequest()
                .setCity("Kraków"));
        letterRequest.setReceiverRequest(new ReceiverRequest()
                .setName("Piotr"));
        letterRequest.setReceiverAddressRequest(new ReceiverAddressRequest()
                .setCity("Warsaw"));
        letterRequest.setInformationRequest(new InformationRequest()
                .setSize(2));

        //when
        Letter letter = letterRequestMapper.mapToLetter(letterRequest);

        //then
        assertEquals("Woj", letterRequest.getSenderRequest().getSurname2());

    }

    @Test
    @DisplayName("Zwraca null kiedy LetterRequest jest null")
    void returnNullWhenLetterRequestIsNUll(){

        assertNull(letterRequestMapper.mapToLetter(null));
    }

    @Test
    void returnNullWhenLetterRequestSender2INull(){

        //given
        LetterRequest letterRequest = new LetterRequest();
        letterRequest.setSenderRequest(null);
        letterRequest.setSenderAddressRequest(null);
        letterRequest.setReceiverRequest(null);
        letterRequest.setReceiverAddressRequest(null);
        letterRequest.setInformationRequest(null);

        //when
        Letter letter = letterRequestMapper.mapToLetter(letterRequest);

        //then
        assertNull(letter);
    }
    @Test
    void returnNotEmptyListWhenAllObjectsHasFieldsEqualsNull(){

        //given
        LetterRequest letterRequest = new LetterRequest();
        letterRequest.setSenderRequest(new SenderRequest().setSurname2(null));
        letterRequest.setSenderAddressRequest(new SenderAddressRequest().setCity(null));
        letterRequest.setReceiverRequest(new ReceiverRequest().setName(null));
        letterRequest.setReceiverAddressRequest(new ReceiverAddressRequest().setCity(null));
        letterRequest.setInformationRequest(new InformationRequest().setAdditionalInfo(null));

        //when
        Letter letter = letterRequestMapper.mapToLetter(letterRequest);

        //then
        assertNotNull(letter);
    }


}
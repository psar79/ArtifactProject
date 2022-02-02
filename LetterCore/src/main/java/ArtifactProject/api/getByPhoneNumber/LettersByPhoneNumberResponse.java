package ArtifactProject.api.getByPhoneNumber;

import java.util.List;

public class LettersByPhoneNumberResponse {

    private List<LetterByPhoneNumberResponse> letterByPhoneNumberResponseReceiverList;

    public List<LetterByPhoneNumberResponse> getLetterByPhoneNumberResponseReceiverList() {
        return letterByPhoneNumberResponseReceiverList;
    }

    public LettersByPhoneNumberResponse setLetterByPhoneNumberResponseReceiverList(List<LetterByPhoneNumberResponse> letterByPhoneNumberResponseReceiverList) {
        this.letterByPhoneNumberResponseReceiverList = letterByPhoneNumberResponseReceiverList;
        return this;
    }
}


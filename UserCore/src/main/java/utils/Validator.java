package utils;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Validator {

    public boolean validatePhoneNumber(String number){
        return Objects.nonNull(number) && number.length() == 9 && number.matches("\\d{9}");
    }

    public boolean validatePhoneNumberAndCode(String number, String code){
        return (Objects.nonNull(number) && Objects.nonNull(code)
                && number.matches("\\d{9}") && code.matches("\\d{6}"));
    }

}

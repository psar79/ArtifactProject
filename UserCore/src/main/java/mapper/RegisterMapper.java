package mapper;

import dao.entity.Register;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RegisterMapper {

    public Register setRegister(String number, String code){
        if(Objects.isNull(number) || Objects.isNull(code)){
            return null;
        }
        Register register = new Register();
        register.setCode(code);
        register.setPhoneNumber(number);
        return register;
    }
}

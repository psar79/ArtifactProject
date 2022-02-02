package mapper;

import dao.entity.User;
import org.springframework.stereotype.Component;


import java.util.Objects;

@Component
public class UserMapper {

    public User getUser(String phoneNumber, String refreshToken) {
        if (Objects.isNull(phoneNumber) || Objects.isNull(refreshToken)) {
            return null;
        }
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setRefreshedToken(refreshToken);
        return user;
    }
}


package manager;

import dao.entity.Register;
import dao.entity.RegisterRepository;
import dao.entity.User;
import dao.entity.UserRepository;

public class RegisterManager {

    private RegisterRepository registerRepository;
    private UserRepository userRepository;

    public RegisterManager(RegisterRepository registerRepository, UserRepository userRepository) {
        this.registerRepository = registerRepository;
        this.userRepository = userRepository;
    }

    public Register registerNewUser(Register register){
        return registerRepository.save(register);
    }

    public User addNewUser(User user){
        return userRepository.save(user);
    }

    public Register findByPhoneNumber(String phoneNumber) {
        return registerRepository.findByPhoneNumber(phoneNumber);
    }

    public User findUserByPhoneNumber(String phoneNumber){
        return  userRepository.findByPhoneNumber(phoneNumber);
    }
}

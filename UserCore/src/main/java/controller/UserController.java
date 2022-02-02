package controller;

import dao.entity.Register;
import dao.entity.User;
import manager.RegisterManager;
import mapper.RegisterMapper;
import mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.CodeGenerator;
import utils.RefreshToken;
import utils.Validator;

import java.util.Objects;

@RestController
public class UserController {

    private final Validator validator;
    private final RegisterManager registerManager;
    private final RegisterMapper registerMapper;
    private final RefreshToken refreshToken;
    private final UserMapper userMapper;
//    @Autowired


    public UserController(Validator validator, RegisterManager registerManager, RegisterMapper registerMapper, RefreshToken refreshToken, UserMapper userMapper) {
        this.validator = validator;
        this.registerManager = registerManager;
        this.registerMapper = registerMapper;
        this.refreshToken = refreshToken;
        this.userMapper = userMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<String> userRegister(@RequestParam String number){
        if(!validator.validatePhoneNumber(number) || Objects.isNull(registerManager.findByPhoneNumber(number))){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please, give proper number");
        }
        CodeGenerator codeGenerator = new CodeGenerator();
        String code = codeGenerator.code();
        Register register = registerMapper.setRegister(number, code);

        registerManager.registerNewUser(register);
        return ResponseEntity.ok().body(code);
    }

    @PostMapping("/add2")
    public ResponseEntity<String> registerUser(@RequestParam String number, @RequestParam String  code){
        if(!validator.validatePhoneNumberAndCode(number, code)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please, give the proper number");
        }
        Register register = registerManager.findByPhoneNumber(number);

        if (Objects.nonNull(register) && register.getCode().equals(code)) {
            String token = refreshToken.tokenCreator();

            User user = userMapper.getUser(number, token);

            registerManager.addNewUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }


}





















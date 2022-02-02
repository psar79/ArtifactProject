package dao.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Register {

    private Long id;
    private String phoneNumber;
    private String code;

    @OneToOne(mappedBy = "register")
    private User user;

    public Register() {
    }

    public Long getId() {
        return id;
    }

    public Register setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Register setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Register setCode(String code) {
        this.code = code;
        return this;
    }
}

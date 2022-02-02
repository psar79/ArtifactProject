package dao.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private  String  refreshedToken;

    @OneToOne
    @JoinColumn(name = "register_id", referencedColumnName = "id")
    private Register register;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getRefreshedToken() {
        return refreshedToken;
    }

    public User setRefreshedToken(String refreshedToken) {
        this.refreshedToken = refreshedToken;
        return this;
    }
}

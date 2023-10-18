package com.practical.details.model.entity;


import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@ToString
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String city;
        


    @Override
    public void preInsert() {
        super.preInsert();
    }

    @Override
    public void preUpdate() {
        super.preUpdate();
    }
}

package com.practical.details.model.dto;


import com.practical.details.config.exception.NotNullConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserRequestDto {
    
    private String id;


    @Pattern(regexp = "^[\\w-.#!$%^&*()_|~=':?><,:{}%`\\+]+(\\.[\\w]+-.#!$%^&()*_+|~=':?><,:%`)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "Please enter valid email.")
    @NotNullConstraint(message = "Email can't be empty")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Please enter valid password.")
    @NotNullConstraint(message = "password can't ne empty")
    private String password;

    @Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Please enter valid phone number.")
    @NotNullConstraint(message = "Phone number cant be empty")
    private String phoneNumber;
    
    private String firstName;
    
    private String city;
     
    private String lastName; 

    public UserRequestDto(String id, String email, String password, String phoneNumber, String firstName, String city, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.city = city;
        this.lastName = lastName;
    }

}

package com.practical.details.admin.controller;

import com.practical.details.common.BaseResponse;
import com.practical.details.model.dto.LogInDto;
import com.practical.details.model.dto.UserRequestDto;
import com.practical.details.user.businesslogic.iface.UserBusinessService;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UserBusinessService userBusinessService;

    @Autowired
    private Validator validator;
    
    
    @PostMapping("/add")
    public ResponseEntity addUsers(
            @RequestBody(required = false) UserRequestDto user
    ) {

        BaseResponse baseResponse;
        System.out.println("Inside Add User Api");

        baseResponse = userBusinessService.registerUser(user);
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    
    
    
       @GetMapping("/getone/{id}")
    public ResponseEntity getOneUsers(@PathVariable("id") String id) {
        System.out.println("Inside GetOneDeteils Users Api");
        BaseResponse baseResponse = userBusinessService.getUserById(id);

        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteUsers( @PathVariable("id") String id ) {

        System.out.println("Inside Delete Users Api");

        BaseResponse baseResponse = userBusinessService.deleteUsersById(id);

        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    


    @PostMapping("/edit/{id}")
    public ResponseEntity editUsers(
            @RequestBody(required = false) UserRequestDto user,
            @PathVariable("id") String id
    ) {
        System.out.println("Inside Edit Users Api");
        BaseResponse baseResponse = userBusinessService.editProfile(id, user);
        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    
    
    
    @GetMapping("/list")
    public ResponseEntity listAllUser(
    ) {
        System.out.println("Inside List Users Api");
        BaseResponse baseResponse = userBusinessService.getAllUserList();

        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
    }
    
//    @PostMapping("/login")
//    public ResponseEntity register(
//            @RequestBody(required = true) LogInDto request
//    ) {
//
//        System.out.println("Inside login api");
//        BaseResponse baseResponse;
//        baseResponse = userBusinessService.authenticateLogin(request);
//        return new ResponseEntity(baseResponse, baseResponse.getHttpStatus());
//    }

}

package com.practical.details.user.businesslogic.impl;

import com.practical.details.common.BaseResponse;
import com.practical.details.common.constants.Constants;
import com.practical.details.model.dto.LogInDto;
import com.practical.details.model.dto.UserRequestDto;
import com.practical.details.model.entity.User;
import com.practical.details.service.iface.UserService;
import com.practical.details.user.businesslogic.iface.UserBusinessService;
import com.practical.details.util.iface.ServiceUtil;
import com.practical.details.utils.CommonsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceUtil serviceUtil;

    @Override
    public BaseResponse registerUser(UserRequestDto user) {
        User user1 = new User();
        
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setCity(user.getCity());
        
        user1.setPassword(user.getPassword());
  
        boolean val = userService.saveUser(user1);

        String message = serviceUtil.getTemplateProperties("register.success", "Registration successful.");
        BaseResponse baseResponse = new BaseResponse(val, HttpStatus.OK.value(), HttpStatus.OK, message);
        return baseResponse;
    }


    @Override
    public BaseResponse getAllUserList() {
        List<User> userList = userService.getAllUserList(CommonsUtil.userStatus());
        List<UserRequestDto> userModal = serviceUtil.convertUserModal(userList);
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, userModal);
    }

    @Override
    public BaseResponse getUserById(String id) {
        User userList = userService.findById(id);
        UserRequestDto userListModal = new UserRequestDto();
        if (userList != null) {
            userListModal = serviceUtil.convertUserModal(userList);
        }
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, userListModal);
    }

    @Override
    public BaseResponse deleteUsersById(String id) {
        User user = userService.findById(id);
        if (user != null) {
            user.setStatus(Constants.DELETED);
            userService.saveUser(user);
        }
        return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "Deleted Successfully");
    }

    @Override
    public BaseResponse editProfile(String id, UserRequestDto userDTORequest) {
        User user = userService.findById(id);

        if (user != null) {

            User updatedUser = user;
            updatedUser.setFirstName(userDTORequest.getFirstName());
            updatedUser.setLastName(userDTORequest.getLastName());
            updatedUser.setEmail(userDTORequest.getEmail());
            updatedUser.setPhoneNumber(userDTORequest.getPhoneNumber());
            updatedUser.setPassword(userDTORequest.getPassword());
            updatedUser.setCity(userDTORequest.getCity());
            

            userService.saveUser(updatedUser);
            return new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "Profile updated successfully.");

        } else {
            return new BaseResponse(false, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);

        }
    }
    
//        @Override
//    public BaseResponse authenticateLogin(LogInDto request) {
//        String token = serviceUtil.createToken(request.getEmail(), request.getPassword());
//
//        Optional<User> user = userService.findByEmail(request.getEmail());
//        if (user.isPresent()) {
//            UserRequestDto userDto = serviceUtil.convertUserModal(user.get());
//            userDto.setToken(token);
//            return  new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, userDto);
//        } else {
//            return  new BaseResponse(true, HttpStatus.OK.value(), HttpStatus.OK, "User not found");
//        }
//    }


}

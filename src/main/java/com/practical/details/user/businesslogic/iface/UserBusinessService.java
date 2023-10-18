package com.practical.details.user.businesslogic.iface;

import com.practical.details.common.BaseResponse;
import com.practical.details.model.dto.LogInDto;
import com.practical.details.model.dto.UserRequestDto;




public interface UserBusinessService {

    public BaseResponse registerUser(UserRequestDto user);

    public BaseResponse editProfile(String id, UserRequestDto user);

    public BaseResponse deleteUsersById(String id);

    public BaseResponse getAllUserList();

    public BaseResponse getUserById(String id);

//    public BaseResponse authenticateLogin(LogInDto request);
    
}

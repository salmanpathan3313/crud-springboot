package com.practical.details.util.iface;

import com.practical.details.model.dto.UserRequestDto;
import com.practical.details.model.entity.User;
import java.util.List;


public interface ServiceUtil {

    String getTemplateProperties(String code, String defaultMessage);

    List<UserRequestDto> convertUserModal(List<User> userList);
    
    UserRequestDto convertUserModal(User user);
    
}

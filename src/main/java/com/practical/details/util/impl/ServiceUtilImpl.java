package com.practical.details.util.impl;

import com.practical.details.model.dto.UserRequestDto;
import com.practical.details.model.entity.User;
import com.practical.details.util.iface.ServiceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


@Service
public class ServiceUtilImpl implements ServiceUtil {


    @Autowired
    private MessageSource templateMessageSource;

    public Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }

    @Override
    public String getTemplateProperties(String code, String defaultMessage) {
        return templateMessageSource.getMessage(code, null, ((defaultMessage == null) ? code : defaultMessage), getCurrentLocale());
    }

    @Override
    public List<UserRequestDto> convertUserModal(List<User> users) {
        List<UserRequestDto> userRequestDtoList = new ArrayList<>();
        for (User user : users) {

            UserRequestDto userRequestDto = convertUserModal(user);
            userRequestDtoList.add(userRequestDto);
        }
        return userRequestDtoList;
    }

    @Override
    public UserRequestDto convertUserModal(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(user.getId());
        userRequestDto.setFirstName(user.getFirstName());
        userRequestDto.setLastName(user.getLastName());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setPhoneNumber(user.getPhoneNumber());
        userRequestDto.setPassword(user.getPassword());
        userRequestDto.setCity(user.getCity());
      
        return userRequestDto;
    }

   
}

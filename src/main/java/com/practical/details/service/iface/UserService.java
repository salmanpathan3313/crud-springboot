package com.practical.details.service.iface;

import com.practical.details.model.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean saveUser(User user);

    Optional<User> findByEmail(String email);
//
//    Optional<User> findByEmailOrUserName(String email, String username);

    User findById(String id);

//    List<User> findAllByIds(List<String> id);
  
    public List<User> getAllUserList(List<String> userStatus);
    
}

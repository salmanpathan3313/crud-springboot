package com.practical.details.srvice.impl;

import com.practical.details.config.exception.CustomException;
import com.practical.details.model.entity.User;
import com.practical.details.repository.UserRepository;
import com.practical.details.service.iface.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<User> getAllUserList(List<String> userStatus) {
        try {
            List<User> members = userRepository.getAllUserList(userStatus);
            return members;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Error Fetching Members", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new CustomException("Error creating user", HttpStatus.OK);
        }

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    @Override
//    public Optional<User> findByEmailOrUserName(String email, String username) {
//        return userRepository.findByEmailOrUser_name(email, username);
//    }

    @Override
    public User findById(String id) {
        return userRepository.findByUserId(id);
    }

//    @Override
//    public List<User> findAllByIds(List<String> id) {
//        return userRepository.findAllByIds(id);
//    }

}

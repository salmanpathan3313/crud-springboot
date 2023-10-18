package com.practical.details.repository;


import com.practical.details.model.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    @Transactional
    @Query(" SELECT g from User g where g.email = ?1 ")
    Optional<User> findByEmail(String email);
//    
//    @Transactional
//    @Query(" SELECT g from User g where g.id = ?1 ")
//    Optional<User> findById(String id, String email);

//    @Query(" select c from User c"
//            + " where c.email like %:email%"
//            + " or c.userName like %:username% ")
//    Optional<User> findByEmailOrUser_name(@Param("email") String email, @Param("username") String username);

    
    @Transactional
    @Query(" SELECT g from User g where status in ?1")
    public List<User> getAllUserList(List<String> userStatus);
    
//    @Query(" SELECT g from User g where id in ?1")
//    public List<User> findAllByIds(List<String> id);


    @Transactional
    @Query(nativeQuery = true, value = "select * from users u where id = ?1")
    public User findByUserId(String id);
    
    
}



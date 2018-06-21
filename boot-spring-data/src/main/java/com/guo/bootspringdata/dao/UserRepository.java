package com.guo.bootspringdata.dao;

import com.guo.bootspringdata.pojo.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long>,
        JpaSpecificationExecutor<User> {

    @Query("select u from User u where u.id = ?1")
    User getUserById(Integer id);



}

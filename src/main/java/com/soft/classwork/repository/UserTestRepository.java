package com.soft.classwork.repository;

import com.soft.classwork.model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/12 10:33
 */


public interface UserTestRepository extends JpaRepository<UserTest,Integer>{

    public void deleteByUseridAndTestid(Integer userid,Integer testid);

    public UserTest findByUseridAndTestid(Integer userid,Integer testid);


}

package com.manage.cafe.cafe.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manage.cafe.cafe.POJO.User;
import com.manage.cafe.cafe.constants.CafeConstants;
import com.manage.cafe.cafe.dao.UserDao;
import com.manage.cafe.cafe.service.UserService;
import com.manage.cafe.cafe.utils.CafeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup ", requestMap);
        try{
            if(validateSignUpMap(requestMap)){
                User user = userDao.findByEmail(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userDao.save(getUserFromMap(requestMap));
                    return CafeUtils.getResponseEntity("Signup Successful", HttpStatus.OK);
                }
                else{
                    return CafeUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
                }
            }
            else{
                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.BAD_REQUEST);
        
    }
    

    private boolean validateSignUpMap(Map<String,String> requestMap){
        return (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
            && requestMap.containsKey("email") && requestMap.containsKey("password"));
    }

    private User getUserFromMap(Map<String,String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus(requestMap.get("status"));
        user.setRole(requestMap.get("role"));

        return user;
    }
}

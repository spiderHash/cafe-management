package com.manage.cafe.cafe.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.manage.cafe.cafe.constants.CafeConstants;
import com.manage.cafe.cafe.rest.UserRest;
import com.manage.cafe.cafe.service.UserService;
import com.manage.cafe.cafe.utils.CafeUtils;

@RestController
public class UserRestImpl implements UserRest{

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    
}

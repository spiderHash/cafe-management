package com.manage.cafe.cafe.rest;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/user")
public interface UserRest{
    
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);

}

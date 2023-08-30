package com.manage.cafe.cafe.service;

import java.util.*;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}

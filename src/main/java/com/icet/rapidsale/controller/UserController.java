package com.icet.rapidsale.controller;

import com.icet.rapidsale.dto.UserDto;
import com.icet.rapidsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto){
      UserDto userDto= userService.saveUser(dto);
       return userDto==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(userDto);
    }

}

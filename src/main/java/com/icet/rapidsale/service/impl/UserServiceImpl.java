package com.icet.rapidsale.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icet.rapidsale.dto.UserDto;
import com.icet.rapidsale.entity.User;
import com.icet.rapidsale.repository.UserRepository;
import com.icet.rapidsale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto saveUser(UserDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User userEntity=repository.save(mapper.convertValue(dto, User.class));

        return mapper.convertValue(userEntity, UserDto.class);
    }
}

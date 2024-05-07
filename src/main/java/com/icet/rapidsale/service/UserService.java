package com.icet.rapidsale.service;

import com.icet.rapidsale.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto saveUser(UserDto dto);
}

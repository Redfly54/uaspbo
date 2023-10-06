/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.UserDto;
import com.samuelmaruba.ProjectPbo2.entity.User;
import java.util.List;

/**
 *
 * @author samue
 */
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

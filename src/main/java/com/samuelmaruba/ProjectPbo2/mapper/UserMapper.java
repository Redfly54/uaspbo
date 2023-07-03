/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.mapper;

import com.samuelmaruba.ProjectPbo2.dto.UserDto;
import com.samuelmaruba.ProjectPbo2.entity.User;

/**
 *
 * @author samue
 */
public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        // Membuat dto dengan builder pattern (inject dari lombok)
        String[] str = user.getName().split(" ");
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(str[0])
                .lastName(str[1])
                .email(user.getEmail())
                .build();        
        return userDto;
    }    
    // map User Dto ke User Entity
    public static User mapToUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getFirstName() + " " + userDto.getLastName())
                .email(userDto.getEmail())
                .build();        
        return user;
    }
}

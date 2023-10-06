/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.repository;

import com.samuelmaruba.ProjectPbo2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author samue
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}

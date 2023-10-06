/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.dto;

import com.samuelmaruba.ProjectPbo2.entity.Daerah;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author samue
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnggotaDto {
    private Long id;
    @NotEmpty(message = "First Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;
    @NotEmpty(message = "Kelas should not be empty")
    private String kelas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Daerah daerah;
    
    @Override
    public String toString() {
        return firstName+lastName; 
    }
}

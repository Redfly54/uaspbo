    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author samue
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anggota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=45, nullable = false, unique = false)
    private String firstName;
    @Column(length=45, nullable = false, unique = false)
    private String lastName;
    @Column(length=45, nullable = false, unique = false)
    private String kelas;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Daerah daerah;
    
    @Override
    public String toString() {
        return firstName+ " "+lastName; 
    }
    
}

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
public class KegiatanDto {
    private Long id;
    @NotEmpty(message = "Nama Kegiatan should not be empty")
    private String namaKegiatan;
    @NotEmpty(message = "deskripsi should not be empty")
    private String deskripsiKegiatan;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Daerah daerah;
    
    @Override
    public String toString() {
        return namaKegiatan; 
    }
}

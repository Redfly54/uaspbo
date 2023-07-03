/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.dto;

import com.samuelmaruba.ProjectPbo2.entity.Anggota;
import com.samuelmaruba.ProjectPbo2.entity.Kegiatan;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
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
public class DaerahDto {
    private Long id;
    @NotEmpty(message = "Nama Daerah should not be empty")
    private String namaDaerah;
    @NotEmpty(message = "Deskripsi should not be empty")
    private String deskripsi;
    
    private String gambar;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name= "daerah_id")
    private List<Anggota> anggota = new ArrayList<>();
    
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name= "daerah_id")
    private List<Kegiatan> kegiatan = new ArrayList<>();
    
    @Override
    public String toString() {
        return namaDaerah; 
    }
}

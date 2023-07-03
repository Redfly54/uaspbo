/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.mapper;

import com.samuelmaruba.ProjectPbo2.dto.DaerahDto;
import com.samuelmaruba.ProjectPbo2.entity.Daerah;

/**
 *
 * @author samue
 */
public class DaerahMapper {
    public static DaerahDto mapToDaerahDTO(Daerah daerah){
        DaerahDto daerahDto = DaerahDto.builder()
                .id(daerah.getId())
                .namaDaerah(daerah.getNamaDaerah())
                .deskripsi(daerah.getDeskripsi())
                .gambar(daerah.getGambar())
                .anggota(daerah.getAnggota())
                .kegiatan(daerah.getKegiatan())
                .build();
        return daerahDto;
    }
    public static Daerah mapToDaerah(DaerahDto daerahDto){
        Daerah daerah = Daerah.builder()
                .id(daerahDto.getId())
                .namaDaerah(daerahDto.getNamaDaerah())
                .deskripsi(daerahDto.getDeskripsi())
                .gambar(daerahDto.getGambar())
                .anggota(daerahDto.getAnggota())
                .kegiatan(daerahDto.getKegiatan())
                .build();
        return daerah;
    }
}

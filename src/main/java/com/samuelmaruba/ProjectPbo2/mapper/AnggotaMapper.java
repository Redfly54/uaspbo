/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.mapper;

import com.samuelmaruba.ProjectPbo2.dto.AnggotaDto;
import com.samuelmaruba.ProjectPbo2.entity.Anggota;

/**
 *
 * @author samue
 */
public class AnggotaMapper {
    public static AnggotaDto mapToAnggotaDto(Anggota anggota){
        AnggotaDto anggotaDto = AnggotaDto.builder()
                .id(anggota.getId())
                .firstName(anggota.getFirstName())
                .lastName(anggota.getLastName())
                .kelas(anggota.getKelas())
                .daerah(anggota.getDaerah())
                .build();
        return anggotaDto;
    }
    public static Anggota mapToAnggota(AnggotaDto anggotaDto){
        Anggota anggota = Anggota.builder()
                .id(anggotaDto.getId())
                .firstName(anggotaDto.getFirstName())
                .lastName(anggotaDto.getLastName())
                .kelas(anggotaDto.getKelas())
                .daerah(anggotaDto.getDaerah())
                .build();
        return anggota;
    }
}

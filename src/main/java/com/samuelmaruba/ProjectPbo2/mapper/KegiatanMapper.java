/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.mapper;

import com.samuelmaruba.ProjectPbo2.dto.KegiatanDto;
import com.samuelmaruba.ProjectPbo2.entity.Kegiatan;

/**
 *
 * @author samue
 */
public class KegiatanMapper {
    public static KegiatanDto mapToKegiatanDto(Kegiatan kegiatan){
        KegiatanDto kegiatanDto = KegiatanDto.builder()
                .id(kegiatan.getId())
                .namaKegiatan(kegiatan.getNamaKegiatan())
                .deskripsiKegiatan(kegiatan.getDeskripsiKegiatan())
                .daerah(kegiatan.getDaerah())
                .build();
        return kegiatanDto;
    }
    public static Kegiatan mapToKegiatan(KegiatanDto kegiatanDto){
        Kegiatan kegiatan = Kegiatan.builder()
                .id(kegiatanDto.getId())
                .namaKegiatan(kegiatanDto.getNamaKegiatan())
                .deskripsiKegiatan(kegiatanDto.getDeskripsiKegiatan())
                .daerah(kegiatanDto.getDaerah())
                .build();
        return kegiatan;
    }
}

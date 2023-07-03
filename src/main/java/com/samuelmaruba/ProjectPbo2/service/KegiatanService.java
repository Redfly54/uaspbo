/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.KegiatanDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service
public interface KegiatanService {
    public List<KegiatanDto> ambilDaftarKegiatan();
    public void perbaruiDataKegiatan (KegiatanDto kegiatanDto);
    public void hapusDataKegiatan(Long kegiatanId);
    public void simpanDataKegiatan (KegiatanDto anggotaDto);
    public KegiatanDto cariById(Long id);
}

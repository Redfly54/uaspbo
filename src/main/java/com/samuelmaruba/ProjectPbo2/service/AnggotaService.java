/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.AnggotaDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service
public interface AnggotaService {
    public List<AnggotaDto> ambilDaftarAnggota();
    public void perbaruiDataAnggota (AnggotaDto anggotaDto);
    public void hapusDataAnggota (Long anggotaId);
    public void simpanDataAnggota (AnggotaDto anggotaDto);
    public AnggotaDto cariById(Long id);
//    public Page<AnggotaDto> getANggotaPage(int page, int pageSize);
}

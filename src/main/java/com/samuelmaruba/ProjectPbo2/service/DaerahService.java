/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.DaerahDto;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author samue
 */
@Service
public interface DaerahService {
    public List<DaerahDto> ambilDaftarDaerah();
    public void perbaruiDataDaerah (DaerahDto daerahDto,MultipartFile file);
    public void hapusDataDaerah (Long daerahId);
    public void simpanDataDaerah (DaerahDto daerahDto,MultipartFile file);
    public DaerahDto cariById(Long id);
    
    public List<DaerahDto> searchDaerah(String keyword);
}

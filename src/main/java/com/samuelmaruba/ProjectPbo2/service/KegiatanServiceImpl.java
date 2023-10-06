/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.KegiatanDto;
import com.samuelmaruba.ProjectPbo2.entity.Kegiatan;
import com.samuelmaruba.ProjectPbo2.mapper.KegiatanMapper;
import com.samuelmaruba.ProjectPbo2.repository.KegiatanRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service
public class KegiatanServiceImpl implements KegiatanService {
    private KegiatanRepository kegiatanRepository;
    
    public KegiatanServiceImpl(KegiatanRepository kegiatanRepository){
        this.kegiatanRepository= kegiatanRepository;
    }
    
    @Override
    public List<KegiatanDto> ambilDaftarKegiatan(){
        List<Kegiatan> kegiatans = this.kegiatanRepository.findAll();
        List<KegiatanDto> kegiatanDtos = kegiatans.stream().map((kegiatan) -> KegiatanMapper.mapToKegiatanDto(kegiatan))
                .collect(Collectors.toList());
        return kegiatanDtos;
    }
    @Override
    public void hapusDataKegiatan(Long kegiatanId){
        this.kegiatanRepository.deleteById(kegiatanId);
    }
    @Override
    public void perbaruiDataKegiatan( KegiatanDto kegiatanDto){
        Kegiatan kegiatan = KegiatanMapper.mapToKegiatan(kegiatanDto);
        this.kegiatanRepository.save(kegiatan);
    }
    @Override
    public void simpanDataKegiatan(KegiatanDto kegiatanDto){
        Kegiatan kegiatan = KegiatanMapper.mapToKegiatan(kegiatanDto);
        kegiatanRepository.save(kegiatan);
    }
    @Override
    public KegiatanDto cariById(Long id){
        Kegiatan kegiatan= kegiatanRepository.findById(id).orElse(null);
        KegiatanDto kegiatanDto= KegiatanMapper.mapToKegiatanDto(kegiatan);
        return kegiatanDto;
    }
}

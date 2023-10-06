/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.AnggotaDto;
import com.samuelmaruba.ProjectPbo2.entity.Anggota;
import com.samuelmaruba.ProjectPbo2.mapper.AnggotaMapper;
import com.samuelmaruba.ProjectPbo2.repository.AnggotaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author samue
 */
@Service
public class AnggotaServiceImpl implements AnggotaService{
    private AnggotaRepository anggotaRepository;
    
    public AnggotaServiceImpl(AnggotaRepository anggotaRepository){
        this.anggotaRepository= anggotaRepository;
    }
    
    @Override
    public List<AnggotaDto> ambilDaftarAnggota(){
        List<Anggota> anggotas = this.anggotaRepository.findAll();
        List<AnggotaDto> anggotaDtos = anggotas.stream().map((daerah) -> AnggotaMapper.mapToAnggotaDto(daerah))
                .collect(Collectors.toList());
        return anggotaDtos;
    }
//    @Override
//    public Page<AnggotaDto> getAnggotaPage(int page, int pageSize) {
//        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("id").descending());
//        Page<Anggota> anggotaPage = anggotaRepository.findAll(pageable);
//        return anggotaPage.map(AnggotaMapper::toAnggotaDto);
//    }
    @Override
    public void hapusDataAnggota(Long anggotaId){
        this.anggotaRepository.deleteById(anggotaId);
    }
    @Override
    public void perbaruiDataAnggota( AnggotaDto anggotaDto ){
        Anggota anggota = AnggotaMapper.mapToAnggota(anggotaDto);
        this.anggotaRepository.save(anggota);
    }
    @Override
    public void simpanDataAnggota(AnggotaDto anggotaDto){
        Anggota anggota = AnggotaMapper.mapToAnggota(anggotaDto);
        anggotaRepository.save(anggota);
    }
    @Override
    public AnggotaDto cariById(Long id){
        Anggota anggota= anggotaRepository.findById(id).orElse(null);
        AnggotaDto anggotaDto= AnggotaMapper.mapToAnggotaDto(anggota);
        return anggotaDto;
    }
}

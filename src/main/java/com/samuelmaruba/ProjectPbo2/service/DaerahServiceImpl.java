/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.service;

import com.samuelmaruba.ProjectPbo2.dto.DaerahDto;
import com.samuelmaruba.ProjectPbo2.entity.Daerah;
import com.samuelmaruba.ProjectPbo2.mapper.DaerahMapper;
import com.samuelmaruba.ProjectPbo2.repository.DaerahRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author samue
 */
@Service
public class DaerahServiceImpl implements DaerahService{
    private DaerahRepository daerahRepository;
    
    public DaerahServiceImpl(DaerahRepository daerahRepository){
        this.daerahRepository= daerahRepository;
    }
    
    @Override
    public List<DaerahDto> ambilDaftarDaerah(){
        List<Daerah> daerahs = this.daerahRepository.findAll();
        List<DaerahDto> daerahDtos = daerahs.stream().map((daerah) -> DaerahMapper.mapToDaerahDTO(daerah))
                .collect(Collectors.toList());
        return daerahDtos;
    }
    @Override
    public void hapusDataDaerah(Long daerahId){
        this.daerahRepository.deleteById(daerahId);
    }
    @Override
    public void perbaruiDataDaerah( DaerahDto daerahDto,MultipartFile file ){
        Daerah daerah = DaerahMapper.mapToDaerah(daerahDto);
        
        if (file != null && !file.isEmpty()) {
            try {
                // Mendapatkan nama file gambar
                String namaFile = file.getOriginalFilename();

                // Menyimpan file gambar
                byte[] gambarBytes = file.getBytes();

                // Mendapatkan path absolut dari folder static/gambar
                File folder = ResourceUtils.getFile("classpath:static/gambar/");
                String folderPath = folder.getAbsolutePath();

                // Menggabungkan path folder dengan nama file
                String filePath = folderPath + File.separator + namaFile;
                Path lokasiSimpan = Paths.get(filePath);
                Files.write(lokasiSimpan, gambarBytes);

                // Mengatur nama file gambar pada entitas Produk
                daerah.setGambar(namaFile);
            } catch (IOException e) {
                // Penanganan kesalahan saat menyimpan gambar
                e.printStackTrace();
                // Atau Anda bisa melempar exception khusus atau memberikan feedback ke pengguna
            }
        }
        this.daerahRepository.save(daerah);
    }
    
    public void simpanDataDaerah(DaerahDto daerahDto,MultipartFile gambarFile) {
        Daerah daerah = DaerahMapper.mapToDaerah(daerahDto);
        
        String namaFile = gambarFile.getOriginalFilename();
        
        try {
            // Menyimpan file gambar
            byte[] gambarBytes = gambarFile.getBytes();

            // Mendapatkan path absolut dari folder static/gambar
            File file = ResourceUtils.getFile("classpath:static/gambar/");
            String folderPath = file.getAbsolutePath();

            // Menggabungkan path folder dengan nama file
            String filePath = folderPath + File.separator + namaFile;
            Path lokasiSimpan = Paths.get(filePath);
            Files.write(lokasiSimpan, gambarBytes);

            // Mengatur nama file gambar pada entitas Produk
            daerah.setGambar(namaFile);
        } catch (IOException e) {
            // Penanganan kesalahan saat menyimpan gambar
            e.printStackTrace();
            // Atau Anda bisa melempar exception khusus atau memberikan feedback ke pengguna
        }
        
        daerahRepository.save(daerah);
    }
    
    @Override
    public List<DaerahDto> searchDaerah(String keyword) {
        //dilakukan dengan mengirim 2 parameter dari firstName dan lastName
        List<Daerah> daerahs = this.daerahRepository
        .findByNamaDaerahContaining(keyword);
        List<DaerahDto> daerahDto = daerahs.stream()
            .map((daerah) -> (DaerahMapper.mapToDaerahDTO(daerah)))
            .collect(Collectors.toList());
        return daerahDto;
    }
    
    @Override
    public DaerahDto cariById(Long id){
        Daerah daerah= daerahRepository.findById(id).orElse(null);
        DaerahDto daerahDto= DaerahMapper.mapToDaerahDTO(daerah);
        return daerahDto;
    }
}

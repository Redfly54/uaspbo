/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.controller;

import com.samuelmaruba.ProjectPbo2.dto.DaerahDto;
import com.samuelmaruba.ProjectPbo2.entity.Anggota;
import com.samuelmaruba.ProjectPbo2.repository.AnggotaRepository;
import com.samuelmaruba.ProjectPbo2.repository.KegiatanRepository;
import com.samuelmaruba.ProjectPbo2.service.DaerahService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author samue
 */
@Controller
public class DaerahController {
    private DaerahService daerahService;
    
    
    
    public DaerahController(DaerahService daerahService){
        this.daerahService = daerahService;
    }
    @Autowired
    private AnggotaRepository anggotaRepo;
    
    @Autowired
    private KegiatanRepository kegiatanRepo;
    
    //handler method, GET Request return model (dto) dan View (templates/*.html)
    @GetMapping("/admin/daerahs")
    public String daerahs(Model model,@RequestParam(defaultValue="") String keyword){
        List<DaerahDto> daerahDtos;
        if (keyword.isEmpty()){
            daerahDtos = this.daerahService.ambilDaftarDaerah();
        } else{
            daerahDtos = this.daerahService.searchDaerah(keyword);
        }
        //tambah atribut "students" yang bisa/akan digunakan di view
        model.addAttribute("daerahDtos", daerahDtos);
        if(daerahDtos.isEmpty()) {
            model.addAttribute("notFound", true);
        }
        model.addAttribute("keyword", keyword);
        // thymeleaf view: "/templates/admin/student.html"
        return "/admin/daerahs";
    }
    
    @GetMapping("/admin/daerahs/identitas/{id}")
    public String identitasDaerahForm(@PathVariable("id") Long id, Model model){
        DaerahDto daerahDtos = daerahService.cariById(id); 
//        List<Anggota> listAnggotas = anggotaRepo.findAll();
//        model.addAttribute("listAnggotas", listAnggotas);
        model.addAttribute("daerahDtos", daerahDtos);
        return "/admin/daerahsiden";
    }
    
    @GetMapping("/admin/daerahs/kegiatan/{id}")
    public String identitasKegiatanForm(@PathVariable("id") Long id, Model model){
        DaerahDto daerahDtos = daerahService.cariById(id); 
//        List<Anggota> listAnggotas = anggotaRepo.findAll();
//        model.addAttribute("listAnggotas", listAnggotas);
        model.addAttribute("daerahDtos", daerahDtos);
        return "/admin/daerahskeg";
    }
    
    @GetMapping("/admin/daerahs/add")
    public String addDaerahForm(Model model){
        DaerahDto daerahDto = new DaerahDto();
//        List<Anggota> listAnggotas = anggotaRepo.findAll();
//        model.addAttribute("listAnggotas", listAnggotas);
        // tambah atribut "studentDto" yang bisa/akan digunakan di form th:object
        model.addAttribute("daerahDto",daerahDto );
        // thymeleaf view: "/templates/admin/students.html"
        return "/admin/daerah_add_form";
    }
    
    
    //handler method untuk request view index
    @GetMapping("/")
    public String index (){
        return "index";
    }

    @PostMapping("/admin/daerahs/add")
    public String addDaerah(@Valid DaerahDto daerahDto, BindingResult result,Model model,@RequestParam("gambarFile") MultipartFile gambarFile) {

        if (result.hasErrors()){
            List<Anggota> listAnggotas = anggotaRepo.findAll();
            model.addAttribute("listAnggotas", listAnggotas);
            // model.addAttribute("studentDto", studentDto);
            return "/admin/daerah_add_form";
        }
        daerahService.simpanDataDaerah(daerahDto, gambarFile);
        return "redirect:/admin/daerahs";
    }
    @GetMapping("/admin/daerahs/delete/{id}")
    public String deleteDaerah(@PathVariable("id") Long id){
        daerahService.hapusDataDaerah(id); 
        return "redirect:/admin/daerahs";
    }
    @GetMapping("/admin/daerahs/update/{id}")
    public String updateDaerahForm(@PathVariable("id") Long id, Model model){
        DaerahDto daerahDto = daerahService.cariById(id); 
        List<Anggota> listAnggotas = anggotaRepo.findAll();
        model.addAttribute("listAnggotas", listAnggotas);
        model.addAttribute("daerahDto", daerahDto);
        return "/admin/daerah_update_form";
    }


    @PostMapping("/admin/daerahs/update")
    public String updateDaerah(@Valid @ModelAttribute("daerahs") DaerahDto daerahDto, BindingResult result,@RequestParam("gambarFile") MultipartFile gambarFile){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/daerah_update_form";
        }
        daerahService.perbaruiDataDaerah(daerahDto,gambarFile);
        return "redirect:/admin/daerahs";
    }
}

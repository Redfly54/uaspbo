/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.controller;

import com.samuelmaruba.ProjectPbo2.dto.KegiatanDto;
import com.samuelmaruba.ProjectPbo2.entity.Daerah;
import com.samuelmaruba.ProjectPbo2.repository.DaerahRepository;
import com.samuelmaruba.ProjectPbo2.service.KegiatanService;
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

/**
 *
 * @author samue
 */
@Controller
public class KegiatanController {
    private KegiatanService kegiatanService;
    
    
    
    public KegiatanController(KegiatanService kegiatanService){
        this.kegiatanService = kegiatanService;
    }
    @Autowired
    private DaerahRepository daerahRepo;
    
    //handler method, GET Request return model (dto) dan View (templates/*.html)
    @GetMapping("/admin/kegiatans")
    public String kegiatans(Model model){
        List<KegiatanDto> kegiatanDtos = this.kegiatanService.ambilDaftarKegiatan();
        //tambah atribut "students" yang bisa/akan digunakan di view
        model.addAttribute("kegiatanDtos", kegiatanDtos);
        // thymeleaf view: "/templates/admin/student.html"
        return "/admin/kegiatans";
    }
    
    @GetMapping("/admin/kegiatans/add")
    public String addKegiatanForm(Model model){
        KegiatanDto kegiatanDto = new KegiatanDto();
        List<Daerah> listDaerahs= daerahRepo.findAll();
        model.addAttribute("listDaerahs", listDaerahs);
        // tambah atribut "studentDto" yang bisa/akan digunakan di form th:object
        model.addAttribute("kegiatanDto",kegiatanDto);
        // thymeleaf view: "/templates/admin/students.html"
        return "/admin/kegiatan_add_form";
    }
    
    
    //handler method untuk request view index
//    @GetMapping("/")
//    public String index () {
//        return "index";
//    }

    @PostMapping("/admin/kegiatans/add")
    public String addKegiatan(@Valid KegiatanDto kegiatanDto, BindingResult result,Model model){
        if (result.hasErrors()){
//            List<Course> listCourses = courseRepo.findAll();
//            model.addAttribute("listCourses", listCourses);
            // model.addAttribute("studentDto", studentDto);
            return "/admin/kegiatan_add_form";
        }
        kegiatanService.simpanDataKegiatan(kegiatanDto);
        return "redirect:/admin/kegiatans";
    }
    @GetMapping("/admin/kegiatans/delete/{id}")
    public String deleteKegiatan(@PathVariable("id") Long id){
        kegiatanService.hapusDataKegiatan(id);
        return "redirect:/admin/kegiatans";
    }
    @GetMapping("/admin/kegiatans/update/{id}")
    public String updateKegiatanForm(@PathVariable("id") Long id, Model model){
        KegiatanDto kegiatanDto = kegiatanService.cariById(id);
//        List<Course> listCourses = courseRepo.findAll();
//        model.addAttribute("listCourses", listCourses);
        model.addAttribute("kegiatanDto", kegiatanDto);
        List<Daerah> listDaerahs= daerahRepo.findAll();
        model.addAttribute("listDaerahs", listDaerahs);
        return "/admin/kegiatan_update_form";
    }


    @PostMapping("/admin/kegiatans/update")
    public String updateKegiatan(@Valid @ModelAttribute("kegiatanDto") KegiatanDto kegiatanDto, BindingResult result){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/kegiatan_update_form";
        }
        kegiatanService.perbaruiDataKegiatan(kegiatanDto);
        return "redirect:/admin/kegiatans";
    }
}

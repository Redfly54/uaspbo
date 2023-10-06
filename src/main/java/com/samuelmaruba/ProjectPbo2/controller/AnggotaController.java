/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.controller;

import com.samuelmaruba.ProjectPbo2.dto.AnggotaDto;
import com.samuelmaruba.ProjectPbo2.entity.Daerah;
import com.samuelmaruba.ProjectPbo2.repository.DaerahRepository;
import com.samuelmaruba.ProjectPbo2.service.AnggotaService;
import com.samuelmaruba.ProjectPbo2.service.DaerahService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author samue
 */
@Controller
public class AnggotaController {
    private AnggotaService anggotaService;
   
    
    public AnggotaController(AnggotaService anggotaService){
        this.anggotaService= anggotaService;
    }
    @Autowired
    private DaerahRepository daerahRepo;
    
    //handler method, GET Request return model (dto) dan View (templates/*.html)
    @GetMapping("/admin/anggotas")
    public String anggotas(Model model){
        List<AnggotaDto> anggotaDtos = this.anggotaService.ambilDaftarAnggota();
        //tambah atribut "students" yang bisa/akan digunakan di view
        model.addAttribute("anggotaDtos", anggotaDtos);
        // thymeleaf view: "/templates/admin/student.html"
        return "/admin/anggotas";
    }
    
    @GetMapping("/admin/anggotas/add")
    public String addAnggotaForm(Model model){
        AnggotaDto anggotaDto = new AnggotaDto(); 
        List<Daerah> listDaerahs = daerahRepo.findAll();
        model.addAttribute("listDaerahs", listDaerahs);
        // tambah atribut "studentDto" yang bisa/akan digunakan di form th:object
        model.addAttribute("anggotaDto",anggotaDto);
        // thymeleaf view: "/templates/admin/students.html"
        return "/admin/anggota_add_form";
    }
    
    @GetMapping("/admin/anggotas/add/satu/{id}")
    public String addAnggotaFormSatu(@PathVariable("id") Long id,Model model){
        AnggotaDto anggotaDto = new AnggotaDto(); 
        List<Daerah> listDaerahs = daerahRepo.findAll();
//        Optional<Daerah> daerahDto = daerahRepo.findById(id);
//        if (daerahDto == null) {
//            String errorMessage = "Daerah tidak ditemukan dengan ID: " + id;
//             model.addAttribute("error", errorMessage);
//             return "error_page"; // Ganti dengan halaman error yang sesuai
//        }
        model.addAttribute("daerahDto", listDaerahs);
        // tambah atribut "studentDto" yang bisa/akan digunakan di form th:object
        model.addAttribute("anggotaDto",anggotaDto);
        // thymeleaf view: "/templates/admin/students.html"
        return "/admin/anggota_add_form_da";
    }
    
    
//    handler method untuk request view index
//    @GetMapping("/")
//    public String index () {
//        return "index";
//    }

    @PostMapping("/admin/anggotas/add")
    public String addAnggota(@Valid AnggotaDto anggotaDto, BindingResult result){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/anggota_add_form_da";
        }
        anggotaService.simpanDataAnggota(anggotaDto);
        return "redirect:/admin/anggotas";
    }
    
    @PostMapping("/admin/anggotas/add/satu")
    public String addAnggotaSatu(@Valid AnggotaDto anggotaDto, BindingResult result,@RequestParam("daerahId") Long daerahId){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/anggota_add_form";
        }
//        Optional<Daerah> daerah = daerahRepo.findById(daerahId);
//        if (daerah.isPresent()) {
//            anggotaDto.setDaerah(daerah.get());
        anggotaService.simpanDataAnggota(anggotaDto);
//        } else {
//            // Handle error: Daerah not found
//        }
//        anggotaDto.setDaerah(daerahRepo.findById(daerahId));
//        anggotaService.simpanDataAnggota(anggotaDto);
        return "redirect:/admin/daerahsinden";
    }
    
    @GetMapping("/admin/anggotas/delete/{id}")
    public String deleteAnggota(@PathVariable("id") Long id){
        anggotaService.hapusDataAnggota(id); 
        return "redirect:/admin/anggotas";
    }
    @GetMapping("/admin/anggotas/update/{id}")
    public String updateAnggotaForm(@PathVariable("id") Long id, Model model){
        AnggotaDto anggotaDto = anggotaService.cariById(id);
        List<Daerah> listDaerahs = daerahRepo.findAll();
        model.addAttribute("listDaerahs", listDaerahs);
        model.addAttribute("anggotaDto", anggotaDto );
        return "/admin/anggota_update_form";
    }


    @PostMapping("/admin/anggotas/update")
    public String updateAnggota(@Valid @ModelAttribute("anggotaDto") AnggotaDto anggotaDto, BindingResult result){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/anggota_update_form";
        }
        anggotaService.perbaruiDataAnggota(anggotaDto); 
        return "redirect:/admin/anggotas";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.repository;

import com.samuelmaruba.ProjectPbo2.entity.Kegiatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author samue
 */
@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan, Long>{
    
}

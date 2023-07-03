/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.repository;

import com.samuelmaruba.ProjectPbo2.entity.Daerah;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author samue
 */
@Repository
public interface DaerahRepository extends JpaRepository<Daerah, Long>{
    
//    Optional<Daerah> findByNamaDaerah(String namaDaerah);
    
     List<Daerah> findByNamaDaerahContaining(String keyword);
}

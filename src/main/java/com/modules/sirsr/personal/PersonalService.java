/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.personal;

import com.modules.sirsr.persistence.entity.Personal;
import com.modules.sirsr.persistence.repository.PersonalRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author Edward Reyes
 */
@Service
public class PersonalService {

    private final PersonalRepository personalRepository;
    private final PersonalMapper personalMapper;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public PersonalService(PersonalRepository personalRepository, PersonalMapper personalMapper) {
        this.personalRepository = personalRepository;
        this.personalMapper = personalMapper;
    }

    public List<PersonalDTO> findAll() {
        return personalMapper.toUnidadResponsableDTOs(personalRepository.findAll());
    }
    
    public List<PersonalDTO> findByNoPersonal(int noPersonal) {
        return personalMapper.toUnidadResponsableDTOs(personalRepository.findByNoPersonal(noPersonal));
    }

    public PersonalDTO findById(int id) {
        Personal personal = personalRepository.findById(id).get();
        return personalMapper.toPersonalDTO(personal);
    }

}

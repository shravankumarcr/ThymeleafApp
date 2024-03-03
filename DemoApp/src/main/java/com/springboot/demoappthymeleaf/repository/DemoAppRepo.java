package com.springboot.demoappthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springboot.demoappthymeleaf.dto.DemoAppDto;

@Repository
public interface DemoAppRepo extends JpaRepository<DemoAppDto, Integer> {

}

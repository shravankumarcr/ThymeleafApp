package com.springboot.demoappthymeleaf.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.demoappthymeleaf.dto.DemoAppDto;
import com.springboot.demoappthymeleaf.repository.DemoAppRepo;

@Component
public class DemoAppDao {

	@Autowired
	DemoAppRepo dar;

	public String insert(DemoAppDto dto) {
		dar.save(dto);
		return "<h1>Inserted Successfully</h1>";
	}

	public List<DemoAppDto> fetchAll() {
		List<DemoAppDto> list = dar.findAll();
		if (list.isEmpty())
			return null;
		else
			return list;
	}

	public DemoAppDto fetchById(int id) {
		Optional<DemoAppDto> o = dar.findById(id);
		if (o.isPresent()) {
			DemoAppDto dto = o.get();
			return dto;
		} else
			return null;
	}
}
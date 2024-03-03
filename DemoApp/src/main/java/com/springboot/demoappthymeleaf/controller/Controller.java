package com.springboot.demoappthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demoappthymeleaf.dao.DemoAppDao;
import com.springboot.demoappthymeleaf.dto.DemoAppDto;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	DemoAppDao dao;

	@RequestMapping("/create")
	public String insertHtml() {
		return "insert";
	}

	@PostMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute DemoAppDto dto) {
		return dao.insert(dto);
	}

	@GetMapping("/fetchall")
	public ModelAndView fetchAll(ModelAndView view) {
		List<DemoAppDto> dto = dao.fetchAll();
		view.addObject("obj", dto);
		view.setViewName("fetchall.html");
		return view;
	}

	@GetMapping("/fetchbyid")
	public String fetchById(@RequestParam int id, ModelMap map) {
		DemoAppDto dto = dao.fetchById(id);
		map.put("obj", dto);
		return "fetchbyid.html";
	}
}
package com.wcs.speedapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.speedapi.model.Wilder;
import com.wcs.speedapi.repository.WilderRepository;

@RestController
public class WilderController {

	@Autowired
	WilderRepository wilderRepository;
	
	@RequestMapping("/create")
	public Wilder createWilder(String name, String mail, String category) {
		Wilder wilder = new Wilder(name, mail, category);
		// wilder ne contient pas encore d'ID, il en contient un dans le retour de repo.save()
		return wilderRepository.save(wilder);
	}
	
	@RequestMapping("/update")
	public Wilder updateWilder(Long id, String name, String mail, String category) {
		Wilder wilder = wilderRepository.getById(id);
		wilder.setFirstname(name);
		wilder.setEmail(mail);
		wilder.setCategory(category);
		return wilderRepository.save(wilder);
	}
	
	@RequestMapping("/find")
	public Wilder getWilder(Long id) {
		return wilderRepository.getById(id);
	}
	
	@RequestMapping("/findall")
	public List<Wilder> getAllWilder(){
		return wilderRepository.findAll();
	}
	
	@RequestMapping("/delete")
	public void deleteWilder(Long id) {
		wilderRepository.deleteById(id);
		
		wilderRepository.findByFirstname("toto");
	}
	
}

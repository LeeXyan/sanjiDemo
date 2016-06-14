package com.sanji.diansh.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanji.diansh.entity.MilletOrders;
import com.sanji.diansh.repository.MilletOrdersRepository;

@Controller
@RequestMapping("/miui")
public class MIUIController {
	@Autowired
	private MilletOrdersRepository  miuiRepository;
	
	/**
	 * 得到列表并且分页
	 * @param pageable
	 * @param assembler
	 * @param model
	 * @param imei
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list1(Pageable pageable, PagedResourcesAssembler<MilletOrders> assembler,Model model){
		 Pattern pattern = Pattern.compile("[0-9]*");
		 
		 Page<MilletOrders> miui = miuiRepository.findAll(pageable);
		 model.addAttribute("data", assembler.toResource(miui));
		 model.addAttribute("meta",assembler.toResource(miui).getMetadata());
		return "admin/miui/list";
		
	}
}

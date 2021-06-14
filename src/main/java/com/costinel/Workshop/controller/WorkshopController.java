package com.costinel.Workshop.controller;

import java.util.List;

import com.costinel.Workshop.jdbc.dao.ClaimDao;
import com.costinel.Workshop.jdbc.domain.Claim;
import com.costinel.Workshop.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WorkshopController {

	@Autowired
	private ClaimService claimService;

	@RequestMapping("/home")
	public String home(Model model){
		List<Claim> claims = claimService.getClaimList();
		model.addAttribute("claimList", claims);
		return "home";
	}

	@RequestMapping("/newJob")
	public String newJob(Model model){
		return "newJob";
	}

	@RequestMapping("/invoice")
	public String invoice(Model model){
		return "invoice";
	}

	@RequestMapping("/tools")
	public String tools(Model model){
		return "tools";
	}

	@RequestMapping(value = "/search")
	public String registrationSearch(@RequestParam("registration") String registration, Model model){
		List<Claim> claims = claimService.getclaim(registration);
		model.addAttribute("claims", claims);
		return "searchResult";
	}
}

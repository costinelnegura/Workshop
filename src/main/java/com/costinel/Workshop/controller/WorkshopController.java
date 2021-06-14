package com.costinel.Workshop.controller;

import java.util.List;

import com.costinel.Workshop.jdbc.domain.Claim;
import com.costinel.Workshop.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "Create", method = RequestMethod.GET,
			params = {"salutation", "fname", "lname", "address", "postcode",
					"mobile", "email", "vehicle_make", "vehicle_model",
					"vehicle_registration", "notes"})
	public String addNewClaim (@RequestParam String salutation, @RequestParam String fname,
							   @RequestParam String lname, @RequestParam String address,
							   @RequestParam String postcode, @RequestParam Integer mobile,
							   @RequestParam String email, @RequestParam String vehicle_make,
							   @RequestParam String vehicle_model, @RequestParam String vehicle_registration,
							   @RequestParam String notes){
		claimService.createClaim(new Claim(salutation, fname, lname, address, postcode, mobile, email,
				vehicle_make, vehicle_model, vehicle_registration, notes));
		return "home";
	}

	@RequestMapping(value = "select", method = RequestMethod.GET, params = "id")
	public String selectClaim(@RequestParam int id, Model model){
		model.addAttribute(claimService.getClaim(id));
		return "claimDetailed";
	}
}

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

	@RequestMapping(value = "details_customer", method = RequestMethod.GET, params = "id")
	public String detailsCustomer(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_customer";
	}

	@RequestMapping(value = "details_vehicle", method = RequestMethod.GET, params = "id")
	public String detailsVehicle(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_vehicle";
	}

	@RequestMapping(value = "details_delivery_collection", method = RequestMethod.GET, params = "id")
	public String detailsDeliveryCollection(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_delivery_collection";
	}

	@RequestMapping(value = "details_claim", method = RequestMethod.GET, params = "id")
	public String detailsClaim(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_claim";
	}

	@RequestMapping(value = "details_notes", method = RequestMethod.GET, params = "id")
	public String detailsNotes(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_notes";
	}

	@RequestMapping(value = "details_images", method = RequestMethod.GET, params = "id")
	public String detailsImages(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_images";
	}

	@RequestMapping(value = "details_history", method = RequestMethod.GET, params = "id")
	public String detailsHistory(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_history";
	}

	@RequestMapping(value = "details_labour", method = RequestMethod.GET, params = "id")
	public String detailsLabour(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_labour";
	}

	@RequestMapping(value = "details_parts", method = RequestMethod.GET, params = "id")
	public String detailsParts(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_parts";
	}

	@RequestMapping(value = "details_extra_charges", method = RequestMethod.GET, params = "id")
	public String detailsExtraCharges(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_extra_charges";
	}

	@RequestMapping(value = "details_estimate", method = RequestMethod.GET, params = "id")
	public String detailsEstimate(@RequestParam int id, Model model){
		model.addAttribute("customer", claimService.getClaim(id));
		return "details/details_estimate";
	}

}

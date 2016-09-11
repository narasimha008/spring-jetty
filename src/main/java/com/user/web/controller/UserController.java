package com.user.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.web.model.Person;
import com.user.web.service.PersonService;

@Controller
public class UserController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<Person> users = personService.getAllPersons();
		model.addAttribute("users", users);
		return "users";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user");
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("userId") Integer userId) {


		ModelAndView model = new ModelAndView();
		model.setViewName("user");
		if(userId != null){
			model.addObject("user", personService.getPerson(new Integer(userId)));
		}	

		return model;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Person person,ModelMap model) {
		try{
			if(person.getId()==null){
				personService.insertPerson(person);	
			}else{
				personService.updatePerson(person);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		List<Person> users = personService.getAllPersons();
		model.addAttribute("users", users);
		return "users";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("userId") Integer userId,ModelMap model) {
		try{
			if(userId!=null){
				personService.deletePerson(userId);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		List<Person> users = personService.getAllPersons();
		model.addAttribute("users", users);
		return "users";
	}

}
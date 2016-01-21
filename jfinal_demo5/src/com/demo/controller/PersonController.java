package com.demo.controller;

import java.util.List;

import com.demo.person.LoginValidator;
import com.demo.person.Person;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class PersonController extends Controller{

	public void index(){
		//setAttr("personlist", Person.person.paginate(getParaToInt(0, 1), 10));
		//List<Person> list = Person.person.find("select * from persons order by id asc");
       // setAttr("personlist", list);
        render("form.jsp");
		//renderJson(list);
		
	}
	
	public void add(){
	
	}
	
	@Before(LoginValidator.class)
	public void save() {
		getModel(Person.class).save();
		redirect("/form");
	}
	
	public void edit(){
		//renderJson(Person.person.findById(getParaToInt()));
	    setAttr("person", Person.person.findById(getParaToInt()));
	}
	
	@Before(LoginValidator.class)
	public void update(){
		getModel(Person.class).update();
		redirect("/form");
	}
	
	public void delete(){
		Person.person.deleteById(getParaToInt());
		redirect("/form");
	}
	
	public void getPersonJson(){
		List<Person> list = Person.person.findAll();
		renderJson(list);
	}
	
	public void searchCity(){
		System.out.println("into searchCity");
		System.out.println(getPara("City"));
		List<Person> list = Person.person.findByCity(getPara("City"));
		renderJson(list);
	}
}

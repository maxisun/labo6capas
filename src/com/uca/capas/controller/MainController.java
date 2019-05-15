package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oracle.tools.packager.Log;
import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {

	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll();
			log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e) {
			log.log(Level.SEVERE, "Exception Occured", e);
		}
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = "/findOne", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="id") int id) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDao.findOne(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("student", student);
		mav.setViewName("one");
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping("/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Agrego un nuevo usuario");
			//se le envia 1 porque es un nuevo usuario
			studentDao.save(s, 1);
		}
		catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value = "/edit", method= RequestMethod.POST)
	public ModelAndView edit(@RequestParam(value="id") int id ) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDao.findOne(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("student", student);
		mav.setViewName("edit");
		return mav;
	}
	
	@RequestMapping("/editData")
	public ModelAndView update(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Agrego un nuevo usuario");
			//se le envia 1 porque es un nuevo usuario
			studentDao.save(s, 0);
		}
		catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/deleteOne")
	public ModelAndView update(@RequestParam(value="name") String name) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			//se le envia 1 porque es un nuevo usuario
			studentDao.delete(name);
		}
		catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
}

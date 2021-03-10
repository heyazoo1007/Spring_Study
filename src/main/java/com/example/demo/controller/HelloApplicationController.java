package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloApplicationController {
	@GetMapping("hello")
	public String Hello(Model model) {
		model.addAttribute("data", "hello!!");
		return "hello";//hello template·Î °¡°ÔµÊ
	}
	@GetMapping("hello-mvc")
	public String HelloMvc(@RequestParam("name") String name, Model model){
		model.addAttribute("name", name);
		System.out.println(name);
		return "hello-templates";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String HelloString(@RequestParam("name") String name) {
		return "hello"+name;
	}
	@GetMapping("hello-api")
	@ResponseBody
	public Hello HelloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setname(name);
		return hello;
	}
	static class Hello{
		private String name;
		
		public String getname() {
			return this.name;
		}
		public void setname(String name) {
			this.name = name;
		}
	}
}

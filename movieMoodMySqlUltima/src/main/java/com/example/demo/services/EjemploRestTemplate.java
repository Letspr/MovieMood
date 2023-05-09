//package com.ejemplo.controllers;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//
//import com.ejemplo.dtos.Casa;
//
//@Controller
//@RequestMapping("/casa")
//public class ControllerRestTemplate {
//	
//	Logger log = LoggerFactory.getLogger(ControllerRestTemplate.class);
//
//	@GetMapping
//	public String listCasas(Model model){
//		log.debug("listCasas");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String url= "http://localhost:8085/casa";
//		
//		ResponseEntity<List<Casa>> responseEntity = 
//				  restTemplate.exchange(
//				    url,
//				    HttpMethod.GET,
//				    null,
//				    new ParameterizedTypeReference<List<Casa>>() {}
//				  );
//		List<Casa> casas = responseEntity.getBody();
//		
//		log.debug("casas:"+casas);
//		
//		model.addAttribute("casas", casas);
//		
//		return "casas";
//		
//	}
//
//	@PostMapping
//	public String newCasa(@RequestParam String nombre) {
//		log.debug("newCasa");
//
//		RestTemplate restTemplate = new RestTemplate();
//		Casa casa = new Casa();
//		casa.setNombre(nombre);
//
//
//		HttpEntity<Casa> request = new HttpEntity<>(casa);
//		String url= "http://localhost:8085/casa";
//		Casa casaResult = restTemplate.postForObject(url, request, Casa.class);
//
//		log.debug("casaResult:"+casaResult);
//		
//		return "redirect:/casa";
//	}
//
//	@GetMapping("/{id}")
//	public String viewCasa(Model model,@PathVariable Long id) {
//		log.debug("viewCasa");
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String url= "http://localhost:8085/casa/"+id;
//		
//		Casa casa = restTemplate.getForObject(url, Casa.class);
//				 		
//		log.debug("casa:"+casa);
//		model.addAttribute(casa);
//		
//		return "casa";
//
//	}
//
//	@PostMapping("/{id}")
//	public String modifyCasa(Model model,@ModelAttribute Casa casa) {
//		log.debug("modifyCasa");
//
//		RestTemplate restTemplate = new RestTemplate();
//		String url= "http://localhost:8085/casa";
//
//		HttpEntity<Casa> request = new HttpEntity<>(casa);
//		ResponseEntity<Casa> response = restTemplate
//				  .exchange(url, HttpMethod.PUT, request, Casa.class);
//		
//		log.debug("response:"+response.getBody());
//		
//		model.addAttribute("casa",response.getBody());
//		return "casa";
//
//	}
//
//	@GetMapping("/e/{id}")
//	public String deleteCasa(Model model,@PathVariable Long id) {
//		log.debug("deleteCasa");
//
//		RestTemplate restTemplate = new RestTemplate();
//		String url= "http://localhost:8085/casa/"+id;
//
//		HttpEntity<Long> request = new HttpEntity<>(id);
//		ResponseEntity<Object> response = restTemplate
//				  .exchange(url, HttpMethod.DELETE, request, Object.class);
//		
//		log.debug("response:"+response.getBody());
//		return "redirect:/casa";
//
//	}
//}

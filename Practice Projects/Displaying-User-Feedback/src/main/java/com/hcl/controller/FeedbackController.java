package com.hcl.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.hcl.entity.Feedback;
import com.hcl.service.ServiceInterface;



@RestController
@RequestMapping
public class FeedbackController {


	@Value("${api.key}")
	private String apikey;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ServiceInterface service;
	
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	@PostMapping("/home")
	public ModelAndView getMovieId(@RequestParam int id, ModelMap model) {
		ModelAndView mv = new ModelAndView("redirect:/feedback/"+id);
		return mv;
	}
	
	@GetMapping(path = "/feedback/{id}", produces = "application/json")

	public ModelAndView getMovieInfo(@PathVariable("id") int id, ModelMap model) {
	
		Feedback fb = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + id + "?" + "api_key=" + apikey, Feedback.class);
		Feedback feedback = new Feedback();
		feedback.setOriginal_title(fb.getOriginal_title());
		feedback.setOverview(fb.getOverview());
		feedback.setVote_count(fb.getVote_count());
		model.put("fb", feedback);
		ModelAndView mv = new ModelAndView("feedback");
		return mv;
	}

	@PostMapping(path = "/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addData(@PathVariable("id") int id) {
		Feedback fb = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + id + "?" + "api_key=" + apikey, Feedback.class);
		Feedback feedback = new Feedback();
		feedback.setOriginal_title(fb.getOriginal_title());
		feedback.setOverview(fb.getOverview());
		feedback.setVote_count(fb.getVote_count());
		service.addFeedback(feedback);
		ModelAndView mv = new ModelAndView("redirect:/result");
		return mv;
	}

	@GetMapping(path = "/result")
	public ModelAndView getResult() {
		ModelAndView mv = new ModelAndView("result");
		return mv;
	}

}

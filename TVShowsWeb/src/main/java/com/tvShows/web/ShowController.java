package com.tvShows.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tvShows.business.TvShow;
import com.tvShows.business.ShowRepository;

@Controller
@RequestMapping("/Shows")
public class ShowController {
	
	@Autowired
	private ShowRepository showRepository;
	
	@GetMapping("/List")
	public @ResponseBody Iterable<TvShow> getAllShows(){
		Iterable<TvShow>shows = showRepository.findAll();
		return shows;
	}
	
	@GetMapping("/Get")
	public @ResponseBody Optional<TvShow> getShow(@RequestParam int id) {
		Optional<TvShow>tvShow = showRepository.findById(id);
		return tvShow;
	}
	
	@PostMapping("/Add")
	public @ResponseBody TvShow addShow(@RequestBody TvShow show) {
		return showRepository.save(show);
	}
	
	@PostMapping("/Change")
	public @ResponseBody TvShow updateShow(@RequestBody TvShow show) {
		return showRepository.save(show);
	}
	
	@PostMapping("/Remove")
	public @ResponseBody String removeShow(@RequestBody TvShow show) {
		showRepository.delete(show);
		return "Show deleted";
	}

}

package com.example.AutoCompleteProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutocompleteController {
	
	@Autowired
	private TrieService trieService;

	@GetMapping("/autocomplete")
	public List<String> autocomplete(@RequestParam String prefix) {
		prefix = prefix.toLowerCase();
		return trieService.autocomplete(prefix);
	}

}

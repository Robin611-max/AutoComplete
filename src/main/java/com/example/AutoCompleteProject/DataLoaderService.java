package com.example.AutoCompleteProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DataLoaderService {
	@Autowired
	private NameRepository nameRepository;

	@PostConstruct
	public void loadData() throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/BoyNames.txt"));
//		String line;
//		while ((line = reader.readLine()) != null) {
//			NameClass name = new NameClass();
//			name.setName(line);
//			nameRepository.save(name);
//		}
//		System.out.println(nameRepository.findAll());
//		reader.close();
	}
}

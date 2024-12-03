package com.example.AutoCompleteProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class TrieService {

	private TrieNode root = new TrieNode();

	@Autowired
	private NameRepository nameRepository;

	@PostConstruct
	public void loadTrie() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/BoyNames.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			NameClass name = new NameClass();
			name.setName(line.toLowerCase());
			nameRepository.save(name);
		}
		List<NameClass> names = nameRepository.findAll();
		reader.close();	
		for (NameClass name : names) {
			insert(name.getName());
		}
		
	}

	public void insert(String word) {
		System.out.println("insert->");
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (!current.containsKey(c)) {
				current.put(c, new TrieNode());
			}
			current = current.get(c);
		}
		current.setEndOfWord(true);
	}

	public List<String> autocomplete(String prefix) {
	      System.out.println("prefix->"+prefix);
		List<String> result = new ArrayList<>();
		TrieNode current = root;
		 System.out.println("root->"+root.links[0]);
		// Traverse the Trie to reach the end of the prefix
		for (char c : prefix.toCharArray()) {
			if (current.containsKey(c)) {
				System.out.println("if-->");
				current = current.get(c);
			} else {
				System.out.println("else-->");
				return result; // No matches found
			}
		}
		// Find all words with this prefix
		findWordsWithPrefix(current, prefix, result);
		return result;
	}

	private void findWordsWithPrefix(TrieNode node, String prefix, List<String> result) {
		if (node.isEndOfWord()) {
			result.add(prefix);
		}
		for (char c = 'a'; c <= 'z'; c++) {
			if (node.containsKey(c)) {
				findWordsWithPrefix(node.get(c), prefix + c, result);
			}
		}
	}

	static class TrieNode {
		private TrieNode[] links = new TrieNode[26];
		private boolean endOfWord = false;

		public boolean containsKey(char ch) {
			System.out.println("ch-->"+ch);
		    // Ensure the character is within 'a' to 'z'
		    return links[ch - 'a'] != null;
		}

		public TrieNode get(char c) {
			return links[c - 'a'];
		}

		public void put(char c, TrieNode node) {
			links[c - 'a'] = node;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}
	}
}

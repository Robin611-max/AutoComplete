package com.example.AutoCompleteProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<NameClass, String> {
}
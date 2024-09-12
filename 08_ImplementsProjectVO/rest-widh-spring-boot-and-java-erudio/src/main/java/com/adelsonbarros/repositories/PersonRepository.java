package com.adelsonbarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adelsonbarros.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
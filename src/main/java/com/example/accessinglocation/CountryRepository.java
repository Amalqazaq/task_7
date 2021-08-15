package com.example.accessinglocation;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

	Country findById(int id);
}


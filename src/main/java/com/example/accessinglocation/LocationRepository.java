package com.example.accessinglocation;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
	Location findById(int id);
}

package com.example.accessinglocation;

import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {

	Region findById(int id);
}

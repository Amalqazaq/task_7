package com.example.accessinglocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(path="/location")
public class LocationController {
	@Autowired 
	 private LocationRepository locationRepository;
	
	
	 @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewRegion (@RequestParam String streetAddress,@RequestParam String postalCode,
			  @RequestParam String stateProvince,@RequestParam String City,@RequestParam int countryid) {
	  
		   Location n = new Location();
		   n.setStreetAddress(streetAddress);
		   n.setPostalCode(postalCode);
		   n.setStateProvince(stateProvince);
		   n.setCity(City);
		   n.setCountryId(countryid);
	     
		   locationRepository.save(n);
	      return "Saved";
	  }
	 
	 
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Location> getAllLocations() {
		    // This returns a JSON or XML with the users
		    return locationRepository.findAll();
		  }
	  
	  

	  @PutMapping(path="/updatestreet")
	  public @ResponseBody String updateStreetAddress(@RequestParam int id,@RequestParam String streetadress) {
		  
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  location.setStreetAddress(streetadress);
		  locationRepository.save(location);
		  return "Updated";
		  
	  }
	  @PutMapping(path="/updatepostal")
	  public @ResponseBody String updatePostalCode(@RequestParam int id,@RequestParam String postalcode) {
		  
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  locationRepository.save(location);
		  return "Updated";
		  
	  }
	  @PutMapping(path="/updatestate")
	  public @ResponseBody String updatestateProvince(@RequestParam int id,@RequestParam String stateprovince) {
		  
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  location.setStreetAddress(stateprovince);
		  locationRepository.save(location);
		  return "Updated";
		  
	  }
	  @PutMapping(path="/updatecity")
	  public @ResponseBody String updateCity(@RequestParam int id,@RequestParam String city) {
		  
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  location.setStreetAddress(city);
		  locationRepository.save(location);
		  return "Updated";
		  
	  }
	  @PutMapping(path="/updatecountryid")
	  public @ResponseBody String updateCountryId(@RequestParam int id,@RequestParam String countryid) {
		  
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  location.setStreetAddress(countryid);
		  locationRepository.save(location);
		  return "Updated";
		  
	  }
	  
	  @DeleteMapping(path="/delete")
	  public @ResponseBody String deleteRegion(@RequestParam int id) {
		  Location location;
		  location=locationRepository.findById(id);
		  if(location==null)
			  return "The id is not found";
		  locationRepository.deleteById(id);
		  return "delete";
	  }
	  
}

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
@RequestMapping(path="/country")
  public class CountryController {
	@Autowired 
     private CountryRepository countryRepository;
	
	 @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewCountry (@RequestParam String name,@RequestParam int regionid) {
	  
		   Country n = new Country();
	       n.setName(name);
	       n.setRegionid(regionid);
	       countryRepository.save(n);
	       return "Saved";
	      
	      
	  }
	 
	 
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Country> getAllRegions() {
		    // This returns a JSON or XML with the users
		    return countryRepository.findAll();
		  }
	    @PutMapping(path="/update")
	  public @ResponseBody String updateCountry(@RequestParam int id,@RequestParam String name) {
		  
		  Country country;
		  country=countryRepository.findById(id);
		  if(country==null)
			  return "The id is not found";
		  country.setName(name);
		  countryRepository.save(country);
		  return "Saved";
		  
	  }
	  
	  @DeleteMapping(path="/delete")
	  public @ResponseBody String deleteRegion(@RequestParam int id) {
		  Country country;
		  country=countryRepository.findById(id);
		  if(country==null)
			  return "The id is not found";
		  countryRepository.deleteById(id);
		  return "delete";
	  }
	  
	
}

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
//import org.springframework.web.bind.annotation.RestController;

@Controller // This means that this class is a Controller
@RequestMapping(path="/region")
public class RegionController {

	@Autowired 
	 private RegionRepository rgionRepository;
	

	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewRegion (@RequestParam String name) {
	  
		 Region n = new Region();
	      n.setName(name);
	      rgionRepository.save(n);
	      return "Saved";
	  }
	  
	  
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Region> getAllRegions() {
		    // This returns a JSON or XML with the users
		    return rgionRepository.findAll();
		  }
	  
	  @PutMapping(path="/update")
	  public @ResponseBody String updateRegion(@RequestParam int id, @RequestParam String name) {
		  Region region;
		  region=rgionRepository.findById(id);
		  if(region==null)
			  return "The id is not found";
		  
		  region.setName(name);
		  rgionRepository.save(region);
		  return "Updated";
		  
	  }
	  
	  @DeleteMapping(path="/delete")
	  public @ResponseBody String deleteRegion(@RequestParam int id) {
		  Region region;
		  region=rgionRepository.findById(id);
		  if(region==null)
			  return "The id is not found";
		  rgionRepository.deleteById(id);
		  return "delete";
	  }
	  
	  
}


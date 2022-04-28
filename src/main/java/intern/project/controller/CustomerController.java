package intern.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import intern.project.exception.ResourceNotFound;
import intern.project.model.Customer;
import intern.project.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerRepository cusRepo;

	@GetMapping("/cus")
	public List<Customer> getCus(){
		return cusRepo.findAll();
	}
	
	@GetMapping("/cus/{id}")
	public ResponseEntity<Customer> getCusById(@PathVariable(name = "id") int cusid) throws ResourceNotFound{
		Customer c = cusRepo.findById(cusid)
				.orElseThrow(() -> new ResourceNotFound("Error, Customer notfound id => " + cusid));
		return ResponseEntity.ok().body(c);
	}
	
	@PostMapping("/cus")
	public Customer addCus( @RequestBody Customer cus){
		return cusRepo.save(cus);
	}
	
	@PutMapping("/cus/{id}")
	public ResponseEntity<Customer> updateCus(@PathVariable(name = "id") int cusid, @RequestBody Customer cus) throws ResourceNotFound{
		Customer c = cusRepo.findById(cusid)
				.orElseThrow(() -> new ResourceNotFound("Error, update customer notfound id => " + cusid));
		c.setName(cus.getName());
		cusRepo.save(c);
		return ResponseEntity.ok().body(c);
	}
	
}

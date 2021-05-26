package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService)
	{
		employeeService=theEmployeeService;
	}
	
	//expose "/employees" and retrun list of employees
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null)
		{
			throw new RuntimeException( "Employ id not found - "+employeeId);
		}
		
		
		return theEmployee;
	}
	
	//saving the employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//if an id is passed through set it to 0
		//this is force to save an new  item .. instead of update
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	//updating the existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	//deleting the employee
	
	@DeleteMapping("/employees/{employeeId}")
	
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null)
		{
			throw new RuntimeException( "Employ id not found - "+employeeId);
		}
	
		
		employeeService.deleteById(employeeId);
		
		return "Deleted id -"+employeeId;
		
	}
	
}

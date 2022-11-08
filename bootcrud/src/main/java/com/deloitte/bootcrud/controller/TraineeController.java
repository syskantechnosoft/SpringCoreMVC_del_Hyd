package com.deloitte.bootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.bootcrud.entity.Trainee;
import com.deloitte.bootcrud.repo.TraineeRepository;
import com.deloitte.bootcrud.service.TraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	TraineeService traineeService;
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees() {
		return traineeService.getTrainees();
	}
	
	@GetMapping("/trainees/{id}")
	public Trainee getTraineeById(@PathVariable int id) {
		return traineeService.getTraineeById(id);
	}
	
	@PostMapping("/trainees")
	public void addTrainee(@RequestBody Trainee trainee) {
		traineeService.addTrainee(trainee);
	}
	
	@DeleteMapping("/trainees/{id}")
	public void deleteTrainee(@PathVariable int id) {
		traineeService.deleteTrainee(id);
	}
	
	@PutMapping("/trainees/{id}")
	public void editTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
		traineeService.editTrainee(id, trainee);
	}

}

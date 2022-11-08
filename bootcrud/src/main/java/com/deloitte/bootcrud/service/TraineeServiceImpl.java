package com.deloitte.bootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.bootcrud.entity.Trainee;
import com.deloitte.bootcrud.repo.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeRepository traineeRepository;

	@Override
	public List<Trainee> getTrainees() {
		return traineeRepository.findAll();
	}

	@Override
	public Trainee getTraineeById(int id) {
		return traineeRepository.findById(id).get();
	}

	@Override
	public void addTrainee(Trainee trainee) {
		traineeRepository.save(trainee);
	}

	@Override
	public void deleteTrainee(int id) {
		traineeRepository.deleteById(id);
	}

	@Override
	public void editTrainee(int id, Trainee trainee) {
		traineeRepository.save(trainee);
	}

}

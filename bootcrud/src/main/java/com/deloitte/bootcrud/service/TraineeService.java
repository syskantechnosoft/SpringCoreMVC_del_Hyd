package com.deloitte.bootcrud.service;

import java.util.List;

import com.deloitte.bootcrud.entity.Trainee;

public interface TraineeService {

	public List<Trainee> getTrainees();

	public Trainee getTraineeById(int id);

	public void addTrainee(Trainee trainee);

	public void deleteTrainee(int id);

	public void editTrainee(int id, Trainee trainee);

}

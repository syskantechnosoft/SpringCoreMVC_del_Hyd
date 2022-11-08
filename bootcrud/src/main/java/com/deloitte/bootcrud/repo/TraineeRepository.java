package com.deloitte.bootcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.bootcrud.entity.Trainee;

@Repository
public interface TraineeRepository  extends JpaRepository<Trainee, Integer>{

}

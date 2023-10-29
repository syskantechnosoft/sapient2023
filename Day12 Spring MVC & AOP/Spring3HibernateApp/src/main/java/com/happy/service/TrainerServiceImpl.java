package com.happy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.TrainerDao;
import com.happy.bean.Trainer;

@Service("trainerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerDao trainerDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTrainer(Trainer trainer) {
		trainerDao.addTrainer(trainer);
	}

	public List<Trainer> listTrainers() {
		return trainerDao.listTrainers();
	}

	public Trainer getTrainer(int empid) {
		return trainerDao.getTrainer(empid);
	}

	public void deleteTrainer(Trainer trainer) {
		trainerDao.deleteTrainer(trainer);
	}

}

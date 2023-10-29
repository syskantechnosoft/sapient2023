package com.happy.service;

import java.util.List;

import com.happy.bean.Trainer;

public interface TrainerService {

	public void addTrainer(Trainer trainer);

	public List<Trainer> listTrainers();

	public Trainer getTrainer(int id);

	public void deleteTrainer(Trainer trainer);

}

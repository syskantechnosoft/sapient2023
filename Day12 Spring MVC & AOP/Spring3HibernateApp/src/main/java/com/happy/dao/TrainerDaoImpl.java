package com.happy.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy.bean.Trainer;

@Repository("trainerDao")
public class TrainerDaoImpl implements TrainerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().saveOrUpdate(trainer);
	}

	@SuppressWarnings("unchecked")
	public List<Trainer> listTrainers() {
		return (List<Trainer>) sessionFactory.getCurrentSession().createCriteria(Trainer.class).list();
	}

	public Trainer getTrainer(int empid) {
		return (Trainer) sessionFactory.getCurrentSession().get(Trainer.class, empid);
	}

	public void deleteTrainer(Trainer trainer) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Trainer WHERE id = " + trainer.getId())
				.executeUpdate();
	}

}

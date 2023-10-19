package com.sapient.t1.repo;

import com.sapient.t1.model.Trainer;

import java.util.List;

public interface TrainerRepo {
    List<Trainer> findAll();
    Trainer findById(int id);
    int save(Trainer trainer);
    int update(int id, Trainer trainer);
    int deleteById(int id);
}

package com.happy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.happy.bean.Trainer;
import com.happy.service.TrainerService;

@Controller
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	@RequestMapping(value = "/saveTrainer", method = RequestMethod.POST)
	public ModelAndView saveTrainer(@ModelAttribute("command") Trainer trainerBean, BindingResult result) {
		Trainer trainer = prepareModel(trainerBean);
		trainerService.addTrainer(trainer);
		return new ModelAndView("redirect:/addTrainer.html");
	}

	@RequestMapping(value = "/trainers", method = RequestMethod.GET)
	public ModelAndView listTrainers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainers", prepareListofBean(trainerService.listTrainers()));
		return new ModelAndView("trainersList", model);
	}

	@RequestMapping(value = "/addTrainer", method = RequestMethod.GET)
	public ModelAndView addTrainer(@ModelAttribute("command") Trainer trainerBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainers", prepareListofBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}

	@RequestMapping(value = "/deleteTrainer", method = RequestMethod.GET)
	public ModelAndView editTrainer(@ModelAttribute("command") Trainer trainerBean, BindingResult result) {
		trainerService.deleteTrainer(prepareModel(trainerBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainer", null);
		model.put("trainers", prepareListofBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}

	@RequestMapping(value = "/editTrainer", method = RequestMethod.GET)
	public ModelAndView deleteTrainer(@ModelAttribute("command") Trainer trainerBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainer", prepareTrainerBean(trainerService.getTrainer(trainerBean.getId())));
		model.put("trainers", prepareListofBean(trainerService.listTrainers()));
		return new ModelAndView("addTrainer", model);
	}

	private Trainer prepareModel(Trainer trainerBean) {
		Trainer trainer = new Trainer();
		trainer.setName(trainerBean.getName());
		trainer.setEmail(trainerBean.getEmail());
		trainer.setId(trainerBean.getId());
		trainerBean.setId(0);
		return trainer;
	}

	private List<Trainer> prepareListofBean(List<Trainer> trainers) {
		List<Trainer> beans = null;
		if (trainers != null && !trainers.isEmpty()) {
			beans = new ArrayList<Trainer>();
			Trainer bean = null;
			for (Trainer trainer : trainers) {
				bean = new Trainer();
				bean.setName(trainer.getName());
				bean.setId(trainer.getId());
				bean.setEmail(trainer.getEmail());
				beans.add(bean);
			}
		}
		return beans;
	}

	private Trainer prepareTrainerBean(Trainer trainer) {
		Trainer bean = new Trainer();
		bean.setEmail(trainer.getEmail());
		bean.setName(trainer.getName());
		bean.setId(trainer.getId());
		return bean;
	}
}

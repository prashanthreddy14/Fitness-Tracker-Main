package com.fitness.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fitness.entity.FitnessActivity;
import com.fitness.repository.FitnessActivityRepository;

@Service
public class FitnessActivityService {

	private FitnessActivityRepository activityRepository;

	public FitnessActivityService(FitnessActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	public List<FitnessActivity> getUserActivities(Long userId) {
		return activityRepository.findByUserId(userId);
	}

	public List<FitnessActivity> getWeeklyActivities(Long userId) {
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minus(7, ChronoUnit.DAYS);
		return activityRepository.findByDateBetween(startDate, endDate);
	}

	public void saveActivity(FitnessActivity activity) {
		activityRepository.save(activity);
	}

	public void deleteActivity(Long userId) {
		activityRepository.deleteById(userId);
	}

	public ResponseEntity<FitnessActivity> updateActivity(FitnessActivity activity, Long userId) {
		FitnessActivity fitnessActivity = activityRepository.getById(userId);
		if(fitnessActivity!=null) {
			FitnessActivity updatedActivity=new FitnessActivity();
			updatedActivity.setActivityType(activity.getActivityType());
			updatedActivity.setDate(activity.getDate());
			updatedActivity.setDistance(activity.getDistance());
			updatedActivity.setDuration(activity.getDuration());
			activityRepository.save(updatedActivity);
		}
		return null;
	}

}

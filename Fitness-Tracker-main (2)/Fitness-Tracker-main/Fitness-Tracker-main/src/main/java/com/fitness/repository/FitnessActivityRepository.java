package com.fitness.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entity.FitnessActivity;

public interface FitnessActivityRepository extends JpaRepository<FitnessActivity,Long> {
	
	List<FitnessActivity> findByUserId(Long userId);

    List<FitnessActivity> findByDateBetween(LocalDate startDate, LocalDate endDate);

}

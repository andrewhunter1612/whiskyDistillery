package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import jdk.jfr.internal.test.WhiteBox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWhiskyFromAYear(){
		List<Whisky> found = whiskyRepository.findByYear(1991);
		assertEquals(1, found.size());

		List<Whisky> yearFound = whiskyRepository.findByDistilleryNameAndAge("Blair Athol", 12);
		assertEquals(1, yearFound.size());

		List<Whisky> regionsFound = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals(4, regionsFound.size());

	}

	@Test
	public void checkByRegion(){
		List<Distillery> found = distilleryRepository.findByRegion("Lowland");
		assertEquals(2, found.size());

		List<Distillery> foundAge = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(4, foundAge.size());
	}

}
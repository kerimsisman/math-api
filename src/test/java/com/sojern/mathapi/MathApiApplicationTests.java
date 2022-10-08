package com.sojern.mathapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sojern.mathapi.service.MathApiService;

@SpringBootTest
@DisplayName("Path Api Test Class")
class MathApiApplicationTests {
	List<Long> input = Arrays.asList(10L, 20L, 950L, 36L, 40L, 5L, 1L, 80L, 90L, 40L, 21L, 75L, 601L, 900L, 800L, 700L);
	@Autowired
	private MathApiService service;

	@Test
	@DisplayName("Min service test")
	void minTest() {
		List<Long> expected = Arrays.asList(1L, 5L);
		List<Long> result = service.min(input, 2L);
		assertEquals(result.size(), 2);
		assertEquals(result, expected);
	}

	@Test
	@DisplayName("Max service test")
	void maxTest() {
		List<Long> expected = Arrays.asList(700L, 800L, 900L, 950L);
		List<Long> result = service.max(input, 4L);
		assertEquals(result.size(), 4);
		assertEquals(result, expected);
	}

	@Test
	@DisplayName("Average service test")
	void averageTest() {
		int total = input.stream().mapToInt(d -> d.intValue()).sum();
		Double result = service.avg(input);
		assertEquals(result * input.size(), total);
	}

	@Test
	@DisplayName("Median service test")
	void medianTest() {
		List<Long> list1 = Arrays.asList(5L, 1L, 2L, 3L, 4L);
		Double result = service.median(list1);
		assertEquals(result, 3);

		List<Long> list2 = Arrays.asList(5L, 1L, 2L, 3L, 4L, 6L);
		Double result2 = service.median(list2);
		assertEquals(result2, Double.valueOf(7) / 2);
	}

	@Test
	@DisplayName("Percentil service test")
	void percentilTest() {
		List<Long> list1 = Arrays.asList(1L, 3L, 4L, 5L, 17L, 45L, 90L);
		Long result = service.percentile(list1, 20);
		assertEquals(result, 3);

		Long result2 = service.percentile(list1, 60);
		assertEquals(result2, 17);

		Long result3 = service.percentile(list1, 81);
		assertEquals(result3, 45);
	}

}

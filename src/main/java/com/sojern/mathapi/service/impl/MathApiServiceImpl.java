package com.sojern.mathapi.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.sojern.mathapi.exception.NoResultException;
import com.sojern.mathapi.service.MathApiService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MathApiServiceImpl implements MathApiService {

	@Override
	public List<Long> min(List<Long> numList, Long quantifier) throws IllegalArgumentException, NoResultException {
		log.info("min started quantifier:{}, numList:{}", quantifier, numList);
		validate(numList, quantifier);

		// Order given list
		Collections.sort(numList);

		// Get desired part
		List<Long> result = numList.subList(0, quantifier.intValue());
		log.info("min completed  quantifier:{}, numList:{} result:{}", quantifier, numList, result);

		return result;
	}

	@Override
	public List<Long> max(List<Long> numList, Long quantifier) throws IllegalArgumentException, NoResultException {
		log.info("max started quantifier:{}, numList:{}", quantifier, numList);
		validate(numList, quantifier);

		// Order given list
		Collections.sort(numList);

		// Get desired part
		List<Long> result = numList.subList(numList.size() - quantifier.intValue(), numList.size());
		log.info("max completed  quantifier:{}, numList:{} result:{}", quantifier, numList, result);

		return result;
	}

	@Override
	public Double avg(List<Long> numList) throws IllegalArgumentException, NoResultException {
		log.info("avg started numList:{}", numList);
		validate(numList, null);

		OptionalDouble optDouble = numList.stream().mapToDouble(d -> d.doubleValue()).average();
		log.info("avg completed numList:{}", numList);
		if (optDouble.isPresent()) {
			return optDouble.getAsDouble();
		} else {
			return null;
		}
	}

	@Override
	public Double median(List<Long> numList) throws IllegalArgumentException, NoResultException {
		log.info("median started numList:{}", numList);
		// Validate
		validate(numList, null);

		// Order given list
		Collections.sort(numList);

		// Calculate median
		Double median;
		if (numList.size() % 2 == 0)
			median = ((double) numList.get(numList.size() / 2) + (double) numList.get(numList.size() / 2 - 1)) / 2;
		else
			median = (double) numList.get(numList.size() / 2);

		log.info("median started numList:{} result:{}", numList, median);
		return median;
	}

	@Override
	public Long percentile(List<Long> numList, Integer qthPercentile)
			throws IllegalArgumentException, NoResultException {
		log.info("percentile started numList:{} qthPercentile:{}", numList, qthPercentile);
		validate(numList, null);
		if (qthPercentile < 0 || qthPercentile > 100) {
			throw new IllegalArgumentException("qthPercentile can not be greather than 100 and can not be less than 0");
		}
		// Order given list
		Collections.sort(numList);

		int index = (int) Math.ceil(qthPercentile / 100.0 * numList.size()) - 1;
		log.info("percentile started numList:{} qthPercentile:{} index:{}", numList, qthPercentile, index);
		return numList.get(index);
	}

	/**
	 * Validate inputs and throw suitable exception
	 * 
	 * @param numberList
	 * @param quantifier
	 * @throws IllegalArgumentException
	 */
	private void validate(List<Long> numberList, Long quantifier) throws IllegalArgumentException {

		// validate number list
		if (numberList == null) {
			throw new IllegalArgumentException("Input is missing!");
		}
		// remove all null values
		numberList.removeAll(Collections.singletonList(null));
		if (numberList.isEmpty()) {
			throw new IllegalArgumentException("Number list is missing!");
		}
		// validate Quantifier
		if (quantifier != null) {
			if (quantifier < 1) {
				throw new IllegalArgumentException("Quantifier is smaller than 1!");
			} else if (quantifier > numberList.size()) {
				throw new IllegalArgumentException("Quantifier is greater than list size!");
			}
		}
	}

}

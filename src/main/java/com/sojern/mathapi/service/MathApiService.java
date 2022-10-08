package com.sojern.mathapi.service;

import java.math.BigDecimal;
import java.util.List;

import com.sojern.mathapi.exception.NoResultException;

public interface MathApiService {
	/**
	 * Calculate minimum list by given list of numbers and a quantifier (how many)
	 * provides min number(s)
	 * 
	 * @param numList
	 * @param quantifier
	 * @return
	 */
	List<Long> min(List<Long> numList, Long quantifier) throws IllegalArgumentException, NoResultException;

	/**
	 * Calculate maximum list by given list of numbers and a quantifier (how many)
	 * provides max number(s)
	 * 
	 * @param numList
	 * @param quantifier
	 * @return
	 */
	List<Long> max(List<Long> numList, Long quantifier) throws IllegalArgumentException, NoResultException;

	/**
	 * Calculate average by given list of numbers calculates their average
	 * 
	 * @param numList
	 * @return
	 */
	Double avg(List<Long> numList) throws IllegalArgumentException, NoResultException;

	/**
	 * Calculate median given list of numbers calculates their median
	 * 
	 * @param numList
	 * @return
	 */
	Double median(List<Long> numList) throws IllegalArgumentException, NoResultException;

	/**
	 * Calculate percentile given list of numbers and quantifier 'q', compute the
	 * qth percentile of the list elements
	 * 
	 * @param numList
	 * @param qthPercentile
	 * @return
	 */
	Long percentile(List<Long> numList, Integer qthPercentile) throws IllegalArgumentException, NoResultException;
}

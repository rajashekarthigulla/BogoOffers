package com.example.demo;

import java.util.List;

public class BogoResponse {
	private List<Integer> discountedList;
	private List<Integer> payableList;

	public BogoResponse(List<Integer> discountedList, List<Integer> payableList) {
		this.discountedList = discountedList;
		this.payableList = payableList;
	}

	public List<Integer> getDiscountedList() {
		return discountedList;
	}

	public void setDiscountedList(List<Integer> discountedList) {
		this.discountedList = discountedList;
	}

	public List<Integer> getPayableList() {
		return payableList;
	}

	public void setPayableList(List<Integer> payableList) {
		this.payableList = payableList;
	}
}

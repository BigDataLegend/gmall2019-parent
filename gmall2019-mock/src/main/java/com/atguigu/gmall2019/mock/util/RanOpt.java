package com.atguigu.gmall2019.mock.util;

/**
 * @author hzhstart
 * @since 2019-07-20 16:45
 */
public class RanOpt<T> {

	T value;
	int weight;

	public RanOpt(T value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public T getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}
}


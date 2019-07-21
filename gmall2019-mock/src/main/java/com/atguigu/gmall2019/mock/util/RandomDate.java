package com.atguigu.gmall2019.mock.util;

import java.util.Date;
import java.util.Random;

/**
 * @author hzhstart
 * @since 2019-07-20 16:38
 */
public class RandomDate {

	Long logDateTime = 0L;
	int maxTimeStep = 0;


	public RandomDate(Date startDate, Date endDate, int num) {

		Long avgStepTime = (endDate.getTime() - startDate.getTime()) / num;
		this.maxTimeStep = avgStepTime.intValue() * 2;
		this.logDateTime = startDate.getTime();
	}

	public Date getRandomDate() {
		int timeStep = new Random().nextInt(maxTimeStep);
		logDateTime = logDateTime + timeStep;
		return new Date(logDateTime);
	}
}


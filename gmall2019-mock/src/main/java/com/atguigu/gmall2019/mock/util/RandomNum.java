package com.atguigu.gmall2019.mock.util;

import java.util.Random;

/**
 * @author hzhstart
 * @since 2019-07-20 16:44
 */
public class RandomNum {

	public static final int getRandInt(int fromNum, int toNum) {

		return fromNum + new Random().nextInt(toNum - fromNum + 1);

	}
}


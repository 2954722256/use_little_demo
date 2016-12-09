package com.aohuan.dodo.rx.qt5.counter.utils;

/**
 * @author C.C
 * @date 2015年12月1日 下午3:48:37
 * @version 1.0
 */
public class TimeUitls {
	public static String milliSecondToMinute(long millisencond) {
		long oneMinute = 1000 * 60;
		int minutes =(int) (millisencond / oneMinute);
		int second =(int) ((millisencond - minutes * oneMinute) / 1000);
		return getNum(minutes) + ":" + getNum(second);
	}

	public static String secondToMinute(int seconds) {
		int oneMinute = 60;
		int minutes = seconds / oneMinute;
		int mSecond = seconds - minutes * oneMinute;
		return getNum(minutes) + ":" + getNum(mSecond);
	}

	public static String getNum(int num) {
		if (num >= 10) {
			return "" + num;
		} else {
			return "0" + num;
		}
	}
}

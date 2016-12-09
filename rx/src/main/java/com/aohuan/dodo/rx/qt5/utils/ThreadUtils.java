package com.aohuan.dodo.rx.qt5.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadUtils {
	private static boolean isKilled = false;
	private static Map<String, Thread> map = new HashMap<>();

	public static Thread newThread(String name, Runnable runnable) {
		Thread thread = map.get(name);
		if (thread == null) {
			isKilled = false;//每次创建一个新的线程都要把存货状态设为false
			thread = new Thread(runnable, name);
			map.put(name, thread);
		}
		return thread;
	}

	/**
	 * 判断Thread是否还在
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isAlive(String name) {
		Thread thread = map.get(name);
		if (thread != null) {
			return !isKilled;
		}
		return false;
	}

	/**
	 * 杀死一个线程
	 * 
	 * @param name
	 * @return
	 */
	public static boolean killThread(String name) {
		Thread thread = map.get(name);
		if (thread == null) {
			return false;
		}
		isKilled = true;
		map.remove(name);
		thread.interrupt();
		return true;
	}
}

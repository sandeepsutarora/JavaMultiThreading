package com.sandeep.practice.multithreading;

class Runner1 implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 1: " + i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {

			}

		}

	}

}

class Runner2 implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 2: " + i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {

			}
		}

	}

}

public class AppRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Runner1());
		t1.start();
		Thread t2 = new Thread(new Runner2());
		t2.start();

	}

}

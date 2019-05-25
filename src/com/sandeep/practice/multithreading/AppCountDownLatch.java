package com.sandeep.practice.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorLatch implements Runnable {
	private CountDownLatch latch;

	public ProcessorLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		System.out.println("Started:....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		latch.countDown();
	}
}

public class AppCountDownLatch {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executer = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executer.submit(new ProcessorLatch(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {

		}
		System.out.println("Completed: ");
		executer.shutdown();
	}

}

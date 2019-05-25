package com.sandeep.practice.multithreading;

class MyRunnable implements Runnable {
	private String threadName;

	public MyRunnable(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {

			try {
				if (this.threadName == "First") {
					System.out.println("Running : " + threadName + " Thread + " + i);
					Thread.sleep(100);
				} else {

					System.out.println("Running : " + threadName + " Thread + " + i);
					Thread.sleep(2015);
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class RunnableImplementation {
	public static void main(String[] args) {

		Thread t1 = new Thread(new MyRunnable("First"));
		Thread t2 = new Thread(new MyRunnable("Second"));
		Thread t3 = new Thread(new MyRunnable("Third"));
		t1.start();
		try {
			Thread.sleep(100);
		} catch (Exception e) {

		}
		t2.start();
		t3.start();

	}

}

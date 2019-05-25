package com.sandeep.practice.multithreading;

class Workers implements Runnable {
	private volatile boolean isTerminnated = false;

	public void run() {
		while (!isTerminnated) {
			System.out.println("Hello from worker class...");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean isTerminnated() {
		return isTerminnated;
	}

	public void setTerminnated(boolean isTerminnated) {
		this.isTerminnated = isTerminnated;
	}

}

public class AppVolatile {
	public static void main(String[] args) {
		Workers worker = new Workers();
		Thread t1 = new Thread(worker);
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		worker.setTerminnated(true);
		System.out.println("Finneshed...............");
		
	}

}

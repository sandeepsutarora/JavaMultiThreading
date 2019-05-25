package com.sandeep.practice.multithreading;
//catching -- volatile

public class AppSynch {
	private int count = 0;

	//synchronized makes operation automic
	//intransic lock
	public synchronized void increament() {
		count++;
	}
	public static void main(String[] args) {

		AppSynch app = new AppSynch();
		app.doWork();

	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increament();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increament();
				}

			}

		});
		t1.start();
		t2.start();
		try {
		t1.join();
		t2.join();
		}catch (InterruptedException e)
		{
			
		}
		
		System.out.println("Count is: " + count);

	}

}

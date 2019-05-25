package com.sandeep.practice.multithreading;

public class Synchronized1 {
	private static long counter = 0;
	private static  void increament()
	{
		synchronized(Synchronized1.class) {
		++counter;
		}
	}
	public static void process() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = -1000000000; i < 1000000000; i++) {					
					increament();
				}
			}

		});		
		
		System.out.println("Finished ...");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = -1000000000; i < 1000000000; i++) {				
					increament();
				}
			}

		});
		
		
		t1.start();
		t2.start();
		System.out.println("Finished ...");
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		process();
		long end = System.currentTimeMillis();		
		System.out.println(counter);
		System.out.println("Time taken : "+ (end - start)/1000 );
	}

}

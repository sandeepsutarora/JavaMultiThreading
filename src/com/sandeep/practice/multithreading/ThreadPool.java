package com.sandeep.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processors implements Runnable {
	private int id = 0;

	public Processors(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Starting: " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		System.out.println("Completed: "+ id);
		
	}

}

public class ThreadPool {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<150;i++)
		{
			executor.submit(new Processors(i));
		}

		executor.shutdown();
		System.out.println("All the tasks sumbitted");
		try {
		executor.awaitTermination(1, TimeUnit.DAYS);}
		catch(Exception e)
		{
			
		}
		
		
		System.out.println("All Task completed");
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken to completed:"+ (end-start)/1000);
	}

}

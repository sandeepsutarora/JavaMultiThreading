package com.sandeep.practice.multithreading;


import java.util.List;
import java.util.Random;

import javax.swing.plaf.synth.SynthColorChooserUI;

import java.util.ArrayList;

public class Worker {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	Random random = new Random();

	public  void stargeOne() {
		synchronized (lock1) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		list1.add(random.nextInt(100));
		}
	}

	public void stargeTwo() {
		synchronized (lock2)
		{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for(int i=0;i<1000;i++)
		{
			stargeOne();
			stargeTwo();
		}
	}

	public void main() {
		
		System.out.println("Processing Started..........");
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
			
		});
		
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
			
		});
		
		t2.start();
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				process();
			}
			
		});
		
		t3.start();
		
		try {
		t1.join();
		t2.join();
		t3.join();
		}
		catch(InterruptedException e)
		{
			
		}
		
		
		long end   = System.currentTimeMillis();
		System.out.println((end-start)/1000);

	}

	
}

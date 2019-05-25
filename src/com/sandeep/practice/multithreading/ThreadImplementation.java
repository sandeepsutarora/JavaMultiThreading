package com.sandeep.practice.multithreading;

class Thread1 extends Thread {
	private String name;
	public Thread1(String name)
	{
		this.name=name;
	}
	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread 1-------------->: "+ this.name +" : :"+ i);
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
}

class Thread2 extends Thread {
	private String name;
	public Thread2(String name)
	{
		this.name=name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread 2 ==========>: " + this.name + " ::  " + i);
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
}

public class ThreadImplementation {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Thread1  t1 = new Thread1("First");
		Thread2  t2 = new Thread2("Second");
		Thread2  t3 = new Thread2("Third");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished the Tasks......");
		

	}

}

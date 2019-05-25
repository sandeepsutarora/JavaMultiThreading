package com.sandeep.practice.multithreading;

class MyThread extends Thread{
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println(this.name + "  " + i+" value of I");
			
		}
	}
}

public class DemoThread {

	public static void main(String[] args) {
		MyThread  t = new MyThread("Sachin");
		MyThread  t1 = new MyThread("Virat");
		MyThread  t2 = new MyThread("Sandeep");
		t.start();
		t1.start();
		t2.start();	
		

	}

}

package com.sandeep.practice.multithreading;

import java.util.Scanner;

class Processor extends Thread {
	//volatile ensures that running value can be changed and while 
	//loop will keep track if value gets changed 
	private volatile boolean running = true;

	public void run() {

		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {

			}
		}
	}

	public void shutDown() {
		running = false;
	}

}

public class ThreadApp {
	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		Processor proc2 = new Processor();
		proc2.start();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		proc1.shutDown();
		scan.nextLine();
		proc2.shutDown();
		
		
	}

}

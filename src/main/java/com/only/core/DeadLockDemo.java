package com.only.core;

public class DeadLockDemo {
	private static String A="A";
	private static String B="B";
	public static void main(String[] args){
		new DeadLockDemo().deadLock();
	}
	private void deadLock(){
		Thread threadA=new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized(A){
					try {
						Thread.currentThread().sleep(2000);
						A.wait(6000);
						System.out.print("a-wait");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(B){
						System.out.println("AB");
					}
				}
			}
		});
		Thread threadB=new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized(B){
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(A){


						System.out.println("BA");
						A.notify();
						try
						{
							Thread.currentThread().sleep(5000);
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		});
		threadA.start();
		threadB.start();
	}
}
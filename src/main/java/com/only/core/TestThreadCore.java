package com.only.core;

public class TestThreadCore implements Runnable
{
	private static int count;
    public static void main(String[] args)  throws  Exception{
		TestThreadCore syncThread = new TestThreadCore();
		Thread thread1 = new Thread(syncThread, "SyncThread1");
		Thread thread2 = new Thread(syncThread, "SyncThread2");
		thread1.start();
		thread2.start();
    }

	public TestThreadCore() {
		count = 0;
	}


	@Override
	public void run()
	{
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public int getCount() {
		return count;
	}
}

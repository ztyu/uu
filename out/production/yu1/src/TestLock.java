import java.util.concurrent.locks.ReentrantLock;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2014年11月6日 上午9:50:41
 * <p>
 * Company:
 * <p>
 *
 * @author
 * @version 1.0.0
 */
public class TestLock {

	private static int state = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ReentrantLock lock = new ReentrantLock();

		// thread1
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 30) {
					try {
						// 加锁
						lock.lock();
						if (state % 3 == 0) {
							System.out.print("1");
							state++;
						}
					}
					finally {
						lock.unlock();
					}

				}
			}
		});

		/*Thread thread = new Thread(()->{
			 System.out.println("nim=============");
		});
		thread.start();*/

		// thread2
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 30) {
					try {
						// 加锁
						lock.lock();
						if (state % 3 == 1) {
							System.out.print("2");
							state++;
						}
					}
					finally {
						lock.unlock();
					}
				}
			}
		});

		// thread3
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 30) {
					try {
						// 加锁
						lock.lock();
						if (state % 3 == 2) {
							System.out.println("3");
							state++;
						}
					}
					finally {
						lock.unlock();
					}
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
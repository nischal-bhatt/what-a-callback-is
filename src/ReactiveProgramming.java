
class Intint {
	public int x = 22;
}

public class ReactiveProgramming {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread started");
		
		Intint intint = new Intint();
		System.out.println("value of intint is " + intint.x);
		CallBack cb = (x) -> {
			x.x = x.x + 24;
			return x;
		};

		Runnable r = new Runnable() {

			@Override
			public void run() {
				new ReactiveProgramming().runningAsync(cb, intint);

			}

		};

		Thread t = new Thread(r);
		t.start();

		Thread.sleep(10000);
		// t.join();

		System.out.println("main thread completed! ");
		System.out.println("value of intint is " + intint.x);
	}

	public Intint runningAsync(CallBack callBack, Intint value) {

		System.out.println("2nd thread sleeping...");
		sleep(8000);
		return callBack.call(value);
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

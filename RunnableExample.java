class numbertask implements Runnable {
	public void run() {
		for(int i=1;i<=5;i++) {
		System.out.println(" Number : " +i);
		}
	}
}

class messagetask implements Runnable {
	public void run() {
		for(int i =1;i<=5;i++) {
			System.out.println(" Hello ");
		}	
	}
}
public class RunnableExample {
	public static void main(String[] args) {
		
		numbertask task1 = new numbertask();
		messagetask task2 = new messagetask();

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
	}	
}

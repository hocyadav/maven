
public class MyThreadClass implements Runnable {
	private int count = 0;
	
//	public void run() {
//		for(int i = 0; i < 20000; i++) {
//			count++;
//		}
//	}
	
	//solution : 40k
	public void run() {
		for(int i = 0; i < 20000; i++) {
			synchronized (this) {//this is current class
				count++;
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}


public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		MyThreadClass runnableObj = new MyThreadClass();
		Thread t1 = new Thread(runnableObj);
		Thread t2 = new Thread(runnableObj);
		
		t1.start();
		t2.start();
		//expected 20k + 20k = 40k count
		System.out.println(runnableObj.getCount());//wrong output
		
		//solution --> join() --> makes thread to complete its excution and move other thread to wait
		t1.join();//excute t1 and wait t2
		t2.join();
		
		System.out.println(runnableObj.getCount());//now we can improve somthing , but still not getting 40k
		
		//solution --> count is compound operation --> make it atomic by syncronize
		
		
	}
}

package sec06.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadPoolE {
	static int i = 0,j,k;
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<int[]>[] future = new Future[10];
		for (int x = 1; x<=10; x++) {
			Callable<int[]> callable = new Calla(x);

			future[x-1] = executorService.submit(callable);
		}
		
		for (int a = 1; a<=10; a++) {
			System.out.println(a+"**********");
			try {
				int[] ret = future[a-1].get();
				for (int b = 0; b<ret.length; b++) {
					if (ret[b]!=0)
						System.out.print(ret[b]+" ");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}catch (InterruptedException | ExecutionException e) {
				
			}
			System.out.println(" ");
		}
		executorService.shutdown();

	}

}

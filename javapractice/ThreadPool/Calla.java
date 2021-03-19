package sec06.practice;

public class Calla implements java.util.concurrent.Callable<int[]> {
	private final int i;
	
	Calla(int i){
		this.i = i;
	}
	
	@Override
	public int[] call() throws Exception {
		boolean[] notprime = new boolean[2001];
		System.out.println(i+"@@@@@");
		for (int j1 = (i-1)*1000+2; j1<=i*1000; j1++) {
			for (int k1=2; k1<=Math.sqrt(j1); k1++) {
				if (j1%k1==0) {
					if ((j1-(i-1)*1000)<0||(j1-(i-1)*1000)>1000) continue;
					notprime[j1-(i-1)*1000] = true;
					break;
				}
			}
		}
		
		int cnt = 0;
		for (int j2= (i-1)*1000+1; j2<=i*1000; j2++) {
			if ((j2-(i-1)*1000)<0||(j2-(i-1)*1000)>1000) continue;
			if (notprime[j2-(i-1)*1000]==false) {
				cnt++;
			}
		}
		int res[] = new int[cnt];
		cnt = 0;
		for (int j= (i-1)*1000+1; j<=i*1000; j++) {
			if ((j-(i-1)*1000)<0||(j-(i-1)*1000)>=1000) continue;
			if (notprime[j-(i-1)*1000]==false) {
				res[cnt++] = j;
				
			}
		}
		return res;
	}

}

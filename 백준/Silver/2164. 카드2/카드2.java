import java.io.*;
import java.util.*;

public class Main {
	
	static Queue<Integer> qu = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=num; i++) {
			qu.add(i);
		}
		while(qu.size()>1) {
			qu.poll();
			qu.add(qu.poll());
			
		}
		
		System.out.println(qu.peek());
			
	}
	

}
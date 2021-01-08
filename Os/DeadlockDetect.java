package Os;
import java.util.*;

public class DeadlockDetect {
	public static void main(String args[]) {
		int n =5,m=3;
		int[][] process = {{0,1,0},{2,0,0},{3,0,3},{2,1,1},{0,0,2}};
		int[][] request = {{0,0,0},{2,0,2},{0,0,0},{1,0,0},{0,0,2}};
		int[] available = {0,0,0};
		int[] work = available;
		boolean[] finish = new boolean[n];
		
		for(int i=0; i<5;i++) {
			if(checkEmpty(process[i])) {
				finish[i] = true;
				
			}
			finish[i]=false;
			System.out.println(finish[i]+"\t");
		}
		System.out.println();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			
			if(finish[i]==false) {
				if(checkResource(request[i], work)) {
					
					Add(work,process[i]);
					finish[i]=true;
					
				}else {
					q.add(i);
					
				}
				
			}
			System.out.print(finish[i]+"\t");
		}
		int flag =0,i;
		while(flag!= q.size()) {
			flag = q.size();
		while(q.size()!=0) {
			
			 i= q.remove();
			 if(finish[i]==false) {
					if(checkResource(request[i], work)) {
						
						Add(work,process[i]);
						finish[i]=true;
						
						
					}else {
						q.add(i);
						
					}
					
				}
				System.out.println(finish[i]+"\t");
			 
		}
		}
		if(flag==q.size()&&flag!=0) {
			while(q.size()!=0) {
				System.out.println("deadlocked:" + q.remove() );
			}
		}
		else {
			System.out.println("System is in safe state");
		}
		
		
		
		
	}
	static boolean checkEmpty(int[] process) {
		for(int i =0; i<process.length ; i++) {
			if(process[i]!=0) {
				return false;
			}
		}
		return true;
	}
	static boolean checkResource(int[] resource , int[] work) {
		for(int i =0; i<resource.length ; i++) {
			if(resource[i]>work[i]) {
				return false;
			}
		}
		
		return true;
		
	}
	static void Add(int[] work , int[] process) {
		for(int i =0; i<process.length ; i++) {
			work[i] = work[i]+process[i];
		}
	
	}

}
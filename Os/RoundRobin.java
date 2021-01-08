package Os;

import java.util.*;

public class RoundRobin {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no of processes: ");
		int n = sc.nextInt();
		Process[] p = new Process[n];
		System.out.println("Enter the arrival time and brust time: ");
		for(int i =0;i<n;i++) {
			p[i] = new Process(sc.nextInt(),sc.nextInt());
		}
		System.out.println("Slicing time : ");
		int s =sc.nextInt();
		roundRobin(p,s);
		sc.close();
		
	}

	private static void roundRobin(Process[] p , int slicingtime) {
		Queue<Process> q = new LinkedList<>();	
		int completion  = p[0].ArrivalTime;
		q.add(p[0]);
		Process process;
		
		int j=1,averageTurn =0,averageWaiting =0;
		while(q.size()!=0) {
			if(completion >=q.peek().ArrivalTime) {
				process = q.remove();
				if(process.BrustTime<= slicingtime) {
					completion += process.BrustTime;
					process.completionTime = completion;
				}else {
					completion += slicingtime;
					process.BrustTime -=slicingtime;
					process.completionTime = completion;
					while(j<p.length&&p[j].ArrivalTime<= completion) {
						q.add(p[j]);
						j++;
					}
					q.add(process);
					
				}
				
				
			}else {
				completion ++;
			}
			
		}
		System.out.println("RoundRobin");
		System.out.println("arrival\tbrust\tcompletion\tturnAround\tWaiting");
		for(int i =0; i<p.length;i++) {
			p[i].TrunAround = p[i].completionTime - p[i].ArrivalTime;
			p[i].waiting = p[i].TrunAround-p[i].BrustTime;
			 averageTurn = p[i].TrunAround;
			averageWaiting +=p[i].waiting;
			System.out.println(p[i].ArrivalTime+"\t"+p[i].BrustTime+"\t"+p[i].completionTime+"\t"+p[i].TrunAround+"\t"+p[i].waiting);
		}
		
		
		
	}
	

}
/*
0 4
1 5
2 2
3 1
4 6
5 3
*/

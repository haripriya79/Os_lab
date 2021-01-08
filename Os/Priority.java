package Os;

import java.util.*;

import Os.Process;


class PriorityCompare implements Comparator<Process>{
	public int compare(Process p1 , Process p2) {
		return p1.priority - p2.priority;
	}
}

public class Priority {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no of processes: ");
		int n = sc.nextInt();
		Process[] p = new Process[n];
		System.out.println("Enter the arrival time and brust time: ");
		for(int i =0;i<n;i++) {
			p[i] = new Process(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		priority(p);
		sc.close();
		
	}

	private static void priority(Process[] p) {
		PriorityQueue<Process> pq = new PriorityQueue<Process>(new PriorityCompare());
		int completion = p[0].ArrivalTime;
		pq.add(p[0]);
		Process process;
		int j=1,averageTurn =0,averageWaiting =0;
		while(pq.size()!=0) {
			if(completion >= pq.peek().ArrivalTime) {
				process = pq.remove();
				completion += process.BrustTime;
				process.completionTime = completion;
				while(j<p.length&&p[j].ArrivalTime<= completion) {
					pq.add(p[j]);
					j++;
				}
				
			}else {
				completion +=1;
			}
			
			
			
		}
		System.out.println("Priority");
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
 0 3 3
 1 6 4
 2 2 7
 3 1 9
 4 4 8
 
 */
/*
0  4 2
1 2 4 
2 3 6
3 5 10
4 1 8
5 4 12
6 6 9
 */

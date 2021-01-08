package Os;
import java.util.*;

import Os.Process;
class brustComparator implements Comparator<Process>{
	public int compare(Process p1 , Process p2) {
		return p1.BrustTime-p2.BrustTime;
	}
}
public class SJF {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no of processes: ");
		int n = sc.nextInt();
		Process[] p = new Process[n];
		System.out.println("Enter the arrival time and brust time: ");
		for(int i =0;i<n;i++) {
			p[i] = new Process(sc.nextInt(),sc.nextInt());
		}
		sjf(p);
		
	}

	private static void sjf(Process[] p) {
		PriorityQueue<Process> pq = new PriorityQueue<Process>(new brustComparator());
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
/*Enter the no of processes: 
5
Enter the arrival time and brust time: 
1 7
2 5
3 1
4 2
5 8
arrival	brust	completion	turnAround	Waiting
1	7	8	7	0
2	5	16	14	9
3	1	9	6	5
4	2	11	7	5
5	8	24	19	11
*/

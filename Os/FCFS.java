package Os;
import java.util.Scanner;

class Process{
	int ArrivalTime;
	int BrustTime;
	int completionTime;
	int TrunAround;
	int waiting;
	int priority;
	public Process(int arrivalTime, int brustTime) {
		super();
		ArrivalTime = arrivalTime;
		BrustTime = brustTime;
		
	}
	public Process(int arrivalTime, int brustTime, int priority) {
		super();
		ArrivalTime = arrivalTime;
		BrustTime = brustTime;
		this.priority = priority;
	}

	
}
public class FCFS {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no of processes: ");
		int n = sc.nextInt();
		Process[] p = new Process[n];
		System.out.println("Enter the arrival time and brust time: ");
		for(int i =0;i<n;i++) {
			p[i] = new Process(sc.nextInt(),sc.nextInt());
		}
		fcfs(p);
		
	}
	static void fcfs(Process[] p) {
		int completion = p[0].ArrivalTime;
		int averageTurn = 0 , averageWaiting =0;
		for(int i =0 ; i<p.length;i++) {
			if(completion >= p[i].ArrivalTime) {
				completion += p[i].BrustTime;
				p[i].completionTime = completion;
			}else {
				completion +=1;
			}
		}
		System.out.println("arrival\tbrust\tcompletion\tturnAround\tWaiting");
		for(int i =0; i<p.length;i++) {
			p[i].TrunAround = p[i].completionTime - p[i].ArrivalTime;
			p[i].waiting = p[i].TrunAround-p[i].BrustTime;
			averageTurn+=p[i].TrunAround;
			averageWaiting +=p[i].waiting;
			System.out.println(p[i].ArrivalTime+"\t"+p[i].BrustTime+"\t"+p[i].completionTime+"\t"+p[i].TrunAround+"\t"+p[i].waiting);
		}
		System.out.println();
	}
	
	

}

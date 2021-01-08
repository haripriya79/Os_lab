package Os;
import java.util.*;


// Predict the next brust time for sjf using little formula...
public class LittleFormula {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of actual brust time:");
		int n = sc.nextInt();
		int t[] = new int[n];
		for(int i =0 ;i<n;i++) {
			t[i] = sc.nextInt();
		}
		Arrays.sort(t);
		float simpleT[] = new float[n];
		System.out.println("Simple Averaging: ");
		int sum =0;
		for(int i=0; i<n;i++) {
			sum += t[i];
			simpleT[i] = 1/(i+1)*(sum);
			System.out.println("i : "+t[i] + "Predicted: "+simpleT[i]);
			
		}
		System.out.println("Exponential Averaging: ");
		float[] exponentialT = new float[n];
		System.out.println("Enter the first Predicted Brust time");
		exponentialT[0] = sc.nextInt();
		float alpha = (float)0.5;
		for(int i = 1 ; i< n ;i++) {
			
			exponentialT[i] = alpha * t[i] + (1-alpha) * exponentialT[i-1];
			System.out.println("i : "+t[i] + "Predicted: "+exponentialT[i]);
			
			
		}
	}

}

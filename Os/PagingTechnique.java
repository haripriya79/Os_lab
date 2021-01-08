package Os;
import java.util.*;

public class PagingTechnique {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Memory size: ");
		int mSize = sc.nextInt();
		 
		System.out.println("Enter the page Size: ");
		int pSize = sc.nextInt();
		int noFrames = mSize/pSize;
		x:
			System.out.println("Enter the process size: ");
		     int processSize = sc.nextInt();
		     int nopages  = processSize / pSize ;
		     int[] pageTable = new int[nopages];
		     for(int i =0;i<nopages;i++) {
		    	 System.out.println("Enter the frame no of page"+i+" :");
		    	 pageTable[i] = sc.nextInt();
		     }
		     System.out.println("Enter the Logical Address: (pageno and pageoffset)");
		     int pageno = sc.nextInt();
		     int pageoffset = sc.nextInt();
		     System.out.println("The page is present at frame :"+pageTable[pageno]);
		     System.out.println("Physical Address: ");
		     String bin1 = Integer.toBinaryString(pageTable[pageno]);
		     String bin2 = Integer.toBinaryString(pageoffset);
		     bin1 = bin1.concat(bin2);
		     System.out.println(Integer.parseInt(bin1,2));
		     
	}

}

package Os;

import java.util.Scanner;

public class FrameAllocation {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Memory size: ");
		int mSize = sc.nextInt();
		 
		System.out.println("Enter the page Size: ");
		int pSize = sc.nextInt();
		int noFrames = mSize/pSize;
		
		System.out.println("Enter the no of process: ");
		int noProcess = sc.nextInt();
		int pages[] = new int[noProcess];
		
		for(int i =0;i<noProcess;i++) {
		    	 System.out.println("Enter the process size  "+i+" :");
		    	 pages[i] =(int)Math.ceil(sc.nextInt()/pSize);
		    	 System.out.println();
		}
		System.out.println("Allocating the Equal no of Frames to process");
		int equal = 4;
		int allocated = noFrames;
		for(int i=0;i<pages.length;i++) {
			if(allocated>0) {
				System.out.println("Pages is allocated: process "+i);
				allocated -=equal;
				
			}else {
				System.out.println("Pages cannot be allocated");
			}
			
		}
		System.out.println("Allocating the process propertionally: ");
		double proportional = 0.4;
		allocated = noFrames;
		for(int i=0;i<pages.length;i++) {
			if(allocated>=equal) {
				System.out.println("Pages is allocated: process "+i);
				allocated -= (int)pages[i]*0.4;
				
			}else {
				System.out.println("Pages cannot be allocated");
			}
			
		}
		
		
	
	}

}

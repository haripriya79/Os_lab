package Os;

import java.util.Scanner;

class Memory{
	//next block address
	Memory next = null;
	String Filename;

	boolean allocated = false;
	
}

public class Linked {
	
	public static void main(String args[]) {
		System.out.println("Enter the Memory size: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		System.out.println("Enter the no of files: ");
		int n = sc.nextInt();
		File[] file = new File[n];
		
		String filename;
		int start;
		int blocks;
		
		for(int i =0;i<n;i++) {
			System.out.println("Enter the file name");
			filename = sc.next();
			System.out.println("Enter the starting index of the file");
			start = sc.nextInt();
			System.out.println("Enter the no of blocks");
			blocks = sc.nextInt();
			file[i] = new File(filename,start,blocks);
			
			
		}
		fileallocation(size , file);
	}

	private static void fileallocation(int size, File[] file) {
		Memory[] memory = new Memory[size];
		Memory prev = null;
		
		for(int i =0 ; i< file.length ; i++) {
			if(size>=file[i].blocks && memory[file[i].start]==null) {
				
				int blocks = file[i].blocks;
				int j = file[i].start;
				memory[j] = new Memory();
				while(blocks>0) {
					if(memory[j].allocated==true) {
						j++;
						continue;
					}else {
						memory[j].Filename = file[i].filename;
						memory[j].allocated = true;
					
						
						if(j!=0)
						memory[j].next = prev;
						prev = memory[j];
						
					
					
				}
				
				
			}
		}else {
			System.out.println("File cannot be allocated.");
		}
		}
		Memory m;
		for(int i=0;i<file.length;i++) {
			int j = file[i].start;
			m = memory[j];
			while(memory[j]!=null) {
				System.out.println("->"+memory[j]);
				m = m.next;
				
			}
		}
		
		
	}


}

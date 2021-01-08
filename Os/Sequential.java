package Os;

import java.util.Scanner;

class File{
	String filename;
	int start;
	int blocks;
	File(String filename, int start, int blocks) {
		super();
		this.filename = filename;
		this.start = start;
		this.blocks = blocks;
	}
	
}

public class Sequential {
	
	
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
		int[] memory = new int[size];
		int j;
		for(int i =0 ; i<file.length ; i++) {
			int start = file[i].start;
			int blocks = file[i].blocks;
			
			if(memory[start]!=1) {
				for(j = start ; j< (start+blocks);j++) {
					if(memory[j]==1) {
						System.out.println("File cannot be allocated - "+file[i].filename);
						break;
					}
				}
				if(j==(start+blocks)) {
					for(int k= start ; k< (start+blocks);k++) {
						memory[k]=1;
					}
					System.out.println("File is allocated - "+ file[i].filename);
				}
			}else {
				System.out.println("File cannot be allocated - "+file[i].filename);
			
				
			}
		}
		
	}

}

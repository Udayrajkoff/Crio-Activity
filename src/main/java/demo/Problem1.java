package demo;

import java.util.*;

public class Problem1 {
	//Problem Description
	//N students appeared for the board exams from a class. The answer of each student is a string (a single word).
	//You are assigned the task of checking how many answers are copied. 
	//You have to check each consecutive pair of answers (words), 
	//to see if they have the same starting character and ending character. This implies a copy. Return the count of such copying.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		sc.nextLine();
		for(int i=0; i<n; i++){
			arr[i] = sc.next();
		}
		System.out.println(broadExams(n, arr));
	}

	static int broadExams(int n, String[] arr){
		int count = 0;
		for(int i=0; i<n-1; i++){
			if(arr[i].charAt(0) == arr[i+1].charAt(0) && arr[i].charAt(arr[i].length()-1) == arr[i+1].charAt(arr[i+1].length()-1)){
				count++;
			}
		}
		
		return count;
	}
}
			

	






	


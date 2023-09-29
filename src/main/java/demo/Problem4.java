package demo;

import java.util.Scanner;

public class Problem4 {
    public int findDuplicateNumber(int[] nums){
        int n = nums.length;
        for(int i=0; i<n; i++){
            int id = Math.abs(nums[i]);
            nums[id-1] = nums[id-1]*(-1);
        }

        for(int i=0; i<n-1; i++){
            if(nums[i]>0){
                return(i+1);
            }
        }
        return -1;
  
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n+1];
    for(int i=0; i<n+1; i++){
        nums[i]=sc.nextInt();
    }
    sc.close();
    int result = new Problem4().findDuplicateNumber(nums);
    System.out.println(result);
}
}
package demo;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        System.out.println(passcode(A, B));
    }

    public static String passcode(String A, String B){
        StringBuilder result = new StringBuilder();
        int maxLen = Math.max(A.length(), B.length());

        for(int i=0; i<maxLen ; i++){
            if(i<A.length()){
                result.append(A.charAt(i));
            }
            if(i<B.length()){
                result.append(B.charAt(i));
            }
        }
        return result.toString();
    }
    
}

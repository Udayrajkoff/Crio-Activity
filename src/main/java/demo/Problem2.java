package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2{
    //Problem Description
    //Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    
    public static String isPalindrome(String s){
        String modifiedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    
        String reversedString = new StringBuilder(modifiedString).reverse().toString();
    
        if(modifiedString.equals(reversedString)){
            return "true";
        }else{
            return "false";
        }
    }
    
        public static void main(String[] args) throws IOException{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = in.readLine();
    
            String result = new Problem2().isPalindrome(line);
            System.out.println(result);
    
        }
    
    }
package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class Problem6 {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
    //  System.out.println("Enter valid integer spearated by space:");
    //  String input = sc.nextLine();
     
    //  ArrayList<Integer> list = new ArrayList<>();
    //  for(String number : input.split(" ")){
    //     list.add(Integer.parseInt(number));
    //  }

    //  HashSet<Integer> set = new HashSet<>(list);
    //  list.clear();
    //  list.addAll(set);

    //  System.out.println("List of integer after remove duplicate: " + list);
        
        System.out.println("Enter a String: ");
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for(char c : input.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
        }
        String output = result.toString();

        System.out.println("Orginial String: " + input);
        System.out.println("String without special characters: " + output);


}


    
}

package demo;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem3 {
    //
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int n = sc.nextInt();
        String[] words = new String[n];
        sc.nextLine();

        for(int i=0; i<n; i++){
            words[i] = sc.next();
        }
        System.out.println(countWords(sentence, n, words));
}

    static int countWords(String sentence, int n, String[] words){
       String[] sentenceWords = sentence.split(" ");

       Set<String> sentenceWordSet = new HashSet<>();
       int count = 0;

       for(String sentenceWord : sentenceWords){
        sentenceWordSet.add(sentenceWord.toLowerCase());
       }

       for(String word : words){
        if(sentenceWordSet.contains(word.toLowerCase())){
            count++;
            sentenceWordSet.remove(word.toLowerCase());
        }

       }

        return count;
    }
}

import java.util.*;
import java.io.*;

public class Main {
    
    public static ArrayList<String> validWords = new ArrayList<String>();
    public static Set<String> usedWords = new HashSet<String>();
    public static PriorityQueue<String> lenQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.length(), b.length()));

    public static Trie trie = new Trie();
    
    
    public static void main(String[] args) {
        int score = 0;
        int totalScore;
        try {
            File file = new File("words_alpha.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                trie.insert(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            Scanner scn = new Scanner(System.in);
            File file = new File("letters.txt");
            String str = chooseRandom(file);
            ArrayList<String> allPossiblePermutations = generatePermutations(str);
            char [] otherWords = str.substring(1).toCharArray();
            char centerLetter = str.charAt(0);
            System.out.println("Welcome to Spelling Bee ");
            for(char c : otherWords){
                System.out.print(c);
            }
            System.out.println("\nYour center letter is " + centerLetter);
            
            for(;;){
                String input = scn.nextLine();
                if(input.length() > 3){
                    if(containsCenterLetter(input, centerLetter) && correctWordsUsed(input,str) && isWord(input)){
                        System.out.println("THIS WORD WORKS");
                        score += input.length() - 3;
//                        switch(score){
//                            case
//                        }
                        System.out.println("score " + score);
                } else {
                    System.out.println("THIS DOES NOT WORK");
                }
            }
        }
            
    } catch (Exception e){
            e.printStackTrace();
        }
        

    }
    
    public int getAllValidWords(){
//        Set<String> set = generatePermutations()


        return 0;
    }
    

    
    public static boolean containsCenterLetter(String str, char c){
        if(str.contains(Character.toString(c))){
            return true;
        }
        return false;
    }
    
    
    public static boolean correctWordsUsed(String input, String str){
        char [] arr = input.toCharArray(); 
        Set<Character> set = new HashSet<Character>();
        for(int i =0; i < str.length(); i++){
            set.add(str.charAt(i));
        }
        
        for(char c : arr){
            if(set.add(c)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isWord(String str){
        if(trie.search(str)){
            return true;
        }
        return false;
    }
    
    public static String chooseRandom(File file) throws IOException{
        String str = null;
        Random random = new Random();
        int i = 0;
        for(Scanner scn = new Scanner(file); scn.hasNext();){
            ++i;
            String line = scn.nextLine();
            if(random.nextInt(i) == 0){
                str = line;
            }
        }
        return str;
    }
    
    public static ArrayList<String> generatePermutations(String str) {
        ArrayList<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }
    
    
    private static void generatePermutationsHelper(String prefix, String suffix, ArrayList<String> permutations) {
        int n = suffix.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n), permutations);
            }
        }
    }
    
}

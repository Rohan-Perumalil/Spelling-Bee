import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
         Set<String> set = new HashSet<String>();
        try{
            File file = new File("words_alpha.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNext()){
                String str = scn.nextLine().trim().toLowerCase();
                if(str.length() > 3){
                    set.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(String s :set){
            System.out.println(s);
        }
    }
}

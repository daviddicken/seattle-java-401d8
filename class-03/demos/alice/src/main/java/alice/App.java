/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package alice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Scanners load things in chunks
        // load it with a path ? How to read a file with a scanner java
        // Use the File class - simple files - contains a reference to the Path class, it does the heavy lifting of connecting it if we provide it a good filepath

        // Exception === Error from js
        Scanner book;
        try {
             book = new Scanner(new File("src/main/resources/alice.txt"));
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("We couldn't find that book, could you get a better filepath?");
            return;
        }


        while(book.hasNext()){ // hasNext checks to see if there is more to load;
            String nextChar = book.next();
//            System.out.println(book.next());
        }

        // count the characters in the book
        // characters : Caterpillar, Cheshire, Hatter, Dee, Dum
        HashSet<String> names = new HashSet<>();
        names.add("Caterpillar");
        names.add("Cheshire");
        names.add("Hatter");
        names.add("Tweedle-Dee");
        names.add("Tweedle-Dum");
        names.add("Alice");

        HashMap<String, Integer> appearCount = new HashMap<>();
        for(String name : names){
            appearCount.put(name, 0);
        }


        while(book.hasNext()){
            String potentialName = book.next();
//            System.out.println(potentialName);
            if(names.contains(potentialName) ){
                // increment the property of our hashset by 1
                int nameCount = appearCount.get(potentialName) + 1;
                appearCount.put(potentialName, nameCount);
            }
        }

        System.out.println("Alice's count " + appearCount.get("Alice"));
        System.out.println("Hatter's count " + appearCount.get("Hatter"));
        System.out.println("Pillar's count " + appearCount.get("Caterpillar"));
        System.out.println("Cheshire's count " + appearCount.get("Cheshire"));
        System.out.println("Dee's count " + appearCount.get("Tweedle-Dee"));
        System.out.println("Dum's count " + appearCount.get("Tweedle-Dum"));
    }
}

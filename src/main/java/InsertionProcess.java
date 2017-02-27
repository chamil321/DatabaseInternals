import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by chamil on 2/27/17.
 */
public class InsertionProcess {

    public static ArrayList<String> generateRandomWords() throws FileNotFoundException {
        String filepath = "/home/chamil/Documents/work/BplusTr/src/main/resources/input.txt";
        Scanner s = new Scanner(new File(filepath));
        ArrayList<String> randomWords = new ArrayList<String>();
        while (s.hasNext()){
            randomWords.add(s.next());

        }
        s.close();
        //System.out.println(randomWords.get(3));
        return randomWords;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Stemming stemming = new Stemming();
        //InsertionManager IM = new InsertionManager();

        ArrayList<String> wordlist = generateRandomWords();
        System.out.println(wordlist.size());

        for(int i=0;i<wordlist.size();i++){
            stemming.transformToStem(wordlist.get(i),i+1);
        }

        /*stemming.transformToStem("eating",0);
        stemming.transformToStem("eats",1);
        stemming.transformToStem("eatery",2);
        stemming.transformToStem("eater",3);
        stemming.transformToStem("eats",4);
        stemming.transformToStem("eats",5);
        stemming.transformToStem("eats",6);
        stemming.transformToStem("eater",7);
        stemming.transformToStem("eater",8);*/

        //IM.showTree();
        //System.out.println(IM.showTree().height());
        stemming.insertionManager.showTree();
        System.out.println("Like :");
        stemming.retrieve("the");


    }
}

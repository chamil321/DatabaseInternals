/**
 * Created by chamil on 2/27/17.
 */
public class InsertionProcess {

    public static void main(String[] args) {
        Stemming stemming = new Stemming();

        stemming.transformToStem("eating",0);
        stemming.transformToStem("eats",1);
        stemming.transformToStem("eatery",2);
        stemming.transformToStem("eater",3);
        stemming.transformToStem("eats",4);
        stemming.transformToStem("eats",5);
        stemming.transformToStem("eats",6);
        stemming.transformToStem("eater",7);
        stemming.transformToStem("eater",8);

    }
}

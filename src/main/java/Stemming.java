import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.stemmer.Stemmer;

/**
 * Created by chamil on 2/27/17.
 */

public class Stemming {

    String origin,stem;
    Integer location;
    InsertionManager insertionManager = new InsertionManager();
    Stemmer stemmer = new PorterStemmer();

    public void transformToStem(String origin, Integer location){

        this.origin = origin;
        this.location = location;
        if(!this.origin.equals(null)) {     //add null check to location as well
            stem = stemmer.stem(origin).toString();
            System.out.println("stem: "+stem);
            insertionManager.insertStem(this.origin,this.location,stem);
        }

    }
}

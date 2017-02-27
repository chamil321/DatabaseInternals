import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.stemmer.Stemmer;

/**
 * Created by chamil on 2/27/17.
 */

public class Stemming {

    String origin,stem,query,stemmedQuery;
    Integer location;
    InsertionManager insertionManager = new InsertionManager();
    Stemmer stemmer = new PorterStemmer();

    public void transformToStem(String origin, Integer location){

        this.origin = origin;
        this.location = location;
        if(!this.origin.equals(null)) {     //add null check to location as well
            origin = origin.toLowerCase();
            stem = stemmer.stem(origin).toString();
            System.out.println("stem: "+stem);
            insertionManager.insertStem(this.origin,this.location,stem);
        }

    }

    public void retrieve(String query){
        //getting the word from query
        this.query = query;
        if(!this.query.equals(null)) {
            query = query.toLowerCase();
            stemmedQuery = stemmer.stem(query).toString();
            System.out.println("Query: "+query+" Stem: "+stemmedQuery);
            insertionManager.retrieveWords(this.query,stemmedQuery);
        }

    }


}

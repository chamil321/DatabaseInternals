import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamil on 2/24/17.
 */
public class InsertionManager {

    int treeIndex = -1;
    BplusTree BTree;
    BplusTree SubBTree;
    ArrayList<String> listOfStem = new ArrayList<String>();
    ArrayList<BplusTree> listOfBtree = new ArrayList<BplusTree>();
    ArrayList<Integer> listOfOrigins = new ArrayList<Integer>();

    public InsertionManager(){
        
        BTree = new BplusTree();
    }

    public boolean insertStem(String origin,int originLocation, String stem){
      if(!stem.equals("null")){

          if(BTree.search(BTree.getRoot(),stem,BTree.height())==null) {

              treeIndex++;
              SubBTree = new BplusTree();
              listOfOrigins = new ArrayList<Integer>();

              listOfBtree.add(treeIndex,SubBTree);
              listOfStem.add(treeIndex,stem);

              BTree.put(stem,treeIndex);
              listOfOrigins.add(originLocation);
              SubBTree.put(origin,listOfOrigins);

              System.out.println("Creating new subtree: "+origin);

          }
          else{

              int index = listOfStem.indexOf(stem); //get tree index of stem
              BplusTree retrievedSubBtree = listOfBtree.get(index);

              if(retrievedSubBtree.search(retrievedSubBtree.getRoot(),origin,retrievedSubBtree.height())==null){
                  listOfOrigins = new ArrayList<Integer>();     //new list to this word
                  listOfOrigins.add(originLocation);
                  retrievedSubBtree.put(origin,listOfOrigins);
              }
              else{
                  System.out.println("Adding to the existing node list");
                  retrievedSubBtree.addToList(retrievedSubBtree,origin,originLocation); // add location to existing node
              }


              //retrievedSubBtree.put(origin,listOfOrigins.add(originLocation));

              System.out.println("Add to existing tree: "+origin);
              //System.out.println(retrievedSubBtree);
              //ArrayList<Integer> list = (ArrayList<Integer>) retrievedSubBtree.get(origin);
              //list.get()

          }
          return true;
      }else{

          return false;
      }
    }

    public boolean retrieveWords(String inputString, String stemmedQuery){
        //if(BTree.search(BTree.getRoot(),stemmedQuery,BTree.height())!=null) {
            //get related stems
            ArrayList<String> assertList = new ArrayList<String>();
            ArrayList<String> totalList = new ArrayList<String>();
            String adjecentStem = getNextString(stemmedQuery);
            String adjecentString = getNextString(inputString);
            ArrayList stemList = BTree.getValues(reduceStem(stemmedQuery), adjecentStem);


            for(int i=0;i<stemList.size();i++){
                int index = listOfStem.indexOf(stemList.get(i)); //get tree index of stemmedQuery
                BplusTree retrievedSubBtree = listOfBtree.get(index);
                assertList = retrievedSubBtree.getValues(inputString, adjecentString);
                for(int k=0;k<assertList.size();k++){
                    System.out.println(assertList.get(k)+":"+retrievedSubBtree.getList(retrievedSubBtree.getRoot(),assertList.get(k),retrievedSubBtree.height()));
                }
                totalList.addAll(assertList);
            }
            //System.out.println(totalList);




        //}
        //else{
            //System.out.println("No Stem available");
            //boolean ismatched = false;
            //while(!ismatched){
                //String newStem = reduceString(stemmedQuery);

            //}
       // }
        return true;
    }

    public String getNextString(String word){
        return word.substring(0, word.length()-1) + (char)((int) (word.charAt(word.length()-1)) + 1);
    }

    public String reduceStem(String word){
        if(word.length()>=3){
            return word.substring(0,2) ;
        }
        else return word;

    }

    public BplusTree showTree(){
        System.out.println("Main Btree");
        System.out.println(this.BTree);
        return this.BTree;
    }
}

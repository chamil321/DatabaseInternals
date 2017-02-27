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

              if(retrievedSubBtree.search(retrievedSubBtree.getRoot(),origin,BTree.height())==null){
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

          System.out.println("Main Btree");
          System.out.println(BTree);
          return true;
      }else{

          return false;
      }
    }

    public boolean retrieveWords(String inputString){
        return true;
    }
}
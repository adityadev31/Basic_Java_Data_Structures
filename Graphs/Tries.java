import java.util.*;


class TriNode{
    char data;
    boolean isTerminating;
    TriNode children[];
    TriNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TriNode[26];
    }
}


class TriActions{
    TriNode root;
    TriActions(){
        root = new TriNode('\0');
    }
    
    void addTrie(String word, TriNode root){     // base case
        if(word.length()==0){ 
            root.isTerminating = true;
            return; 
        }
        int childIndex = word.charAt(0) - 'a';
        TriNode child = root.children[childIndex];
        if(child == null){    // create a new child and add it to the root
            child = new TriNode(word.charAt(0));
            root.children[childIndex] = child;
        }
        addTrie(word.substring(1), child);
    }
    
    void addTrie(String word){ addTrie(word, root); }
    
    
    boolean searchTrie(String word, TriNode root){
        if(word.length()==0){ return root.isTerminating; }  // base case
        int childIndex = word.charAt(0) - 'a';
        TriNode child = root.children[childIndex];
        if(child == null) { return false; }
        return searchTrie(word.substring(1), child);
    }
    
    boolean searchTrie(String word){ return searchTrie(word, root); }
    
    
    void delTrie(String word, TriNode root){
        if(word.length()==0){               // base case
            root.isTerminating = false;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TriNode child = root.children[childIndex];
        if(child != null){
            delTrie(word.substring(1), child);
        }
        else
            return;
    }
    
    void delTrie(String word){ delTrie(word, root); }
    
}


public class Main {
    public static void main(String[] args) throws Exception {
        TriActions ob1 = new TriActions();
        ob1.addTrie("add");
        ob1.addTrie("bat");
        ob1.addTrie("sub");
        System.out.println(ob1.searchTrie("add"));
        System.out.println(ob1.searchTrie("bats"));
        ob1.delTrie("bat");
        System.out.println(ob1.searchTrie("bat"));
    }
}



/**

output:-
true
false
false

**/

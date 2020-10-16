/*  USED AS A DICTIONARY */

import java.util.*;

public class Main{
    
    static class Trie{
        Trie children[];
        boolean isEnd;
        Trie(){
            isEnd = false;
            children = new Trie[26];
            for(int i=0; i<26; i++) children[i] = null;
        }
    }
    
    public static Trie root;        // declaring root node
    
    // insert
    public static void insert(String str){
        int n = str.length();
        Trie parent = root;
        int index = -1;
        for(int i=0; i<n; i++){
            index = str.charAt(i)-'a';
            if(parent.children[index] == null) parent.children[index] = new Trie();
            parent = parent.children[index];
        }
        parent.isEnd = true;
    }
    
    // search
    public static boolean search(String str){
        Trie parent = root;
        int n = str.length(), index = -1;
        for(int i=0; i<n; i++){
            index = str.charAt(i)-'a';
            if(parent.children[index] == null) return false;
            parent = parent.children[index];
        }
        if(parent.isEnd) return true;
        return false;
    }
    
    // delete
    public static void delete(String str){
        if(search(str)){
            Trie parent = root;
            int n = str.length(), index = -1;
            for(int i=0; i<n; i++){
                index = str.charAt(i)-'a';
                parent = parent.children[index];
            }
            if(parent.isEnd) parent.isEnd = false;
            System.out.println("item deleted...");
        }
        else System.out.println("item not found..");
    }
    
    public static void main(String[] args){
        
        String items[] = {"apple","app","ball","balloon","cat","dog"};
        String sitems[] = {"apple","ape","bald","balloon","cat","doggy"};
        String sop[] = {" not found", " found"};
        
        int n = items.length;
        root = new Trie();
        
        // insert
        for(int i=0; i<n; i++) insert(items[i]);
        
        // search
        System.out.println("\nSearching ...");
        for(int i=0; i<n; i++){
            if(search(sitems[i])) System.out.println(sitems[i] + sop[1]);
            else System.out.println(sitems[i] + sop[0]);
        }
        
        // delete
        System.out.println("\ndeleting....");
        delete(sitems[1]);
        delete(items[3]);
        System.out.println(search(items[3]));
        insert(items[3]);
        System.out.println(search(items[3]));
    }
    
}


/*
output:-


Searching ...
apple found
ape not found
bald not found
balloon found
cat found
doggy not found

deleting....
item not found..
item deleted...
false
true

*/

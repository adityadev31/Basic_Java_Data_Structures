import java.util.*;

 class Student{
   int roll;
   String name;
   String gpa;
   Student(int a, String b, String c){
     roll = a;
     name = b;
     gpa  = c;
   }
 }

 class Main
 {
   public static void main(String args[])
   { 
    
    ArrayList<Student> list = new ArrayList<>();
    list.add(new Student(10, "anjali", "8.6"));
    list.add(new Student(5, "mridul", "7.0"));
    list.add(new Student(1, "chirag", "7.2"));
    list.add(new Student(7, "mayank", "9.4"));
    list.add(new Student(2, "yash", "8.3"));
    list.add(new Student(4, "ritik", "6.9"));
    
    Collections.sort(list, new Comparator<Student>(){
      @Override
      public int compare(Student a, Student b){
        return a.gpa.compareTo(b.gpa);       // as
cending
      }
    });
    
    for(Student x : list) System.out.println(x.roll + " " + x.name + " " + x.gpa);
   }
 }

/**

4 ritik 6.9
5 mridul 7.0
1 chirag 7.2
2 yash 8.3
10 anjali 8.6
7 mayank 9.4


**/

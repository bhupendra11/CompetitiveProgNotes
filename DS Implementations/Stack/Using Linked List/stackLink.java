import java.util.*;


public class stackLink{
 private Node first = null;
 private int size =0;
 private class Node{
 String data;
 Node next;


 }

 public boolean isEmpty(){

 return first ==null;

 }
 public void push(String item){
 Node oldfirst = first;
 first = new Node();
 first.data = item;
 first.next=oldfirst;
 size++;

 }

 public String pop() throws Exception {
 if(size<=0)throw new Exception("Stack empty");
     
 String data = first.data;
 first = first.next;
 size--;
 return data;

 
 }

 public static void main(String args[]) throws Exception{

 stackLink stack = new stackLink();
 Scanner sc = new Scanner(System.in);
 String in;

 while(true ){
 in =   sc.nextLine();

 if(in.equals("end"))break;
 else if(in.equals("-"))System.out.println(stack.pop());
 else stack.push(in); 
 

 }
  




 }
 

}

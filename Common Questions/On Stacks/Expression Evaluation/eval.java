
import java.util.*;

public class eval{
    
    public static void main(String args[]){
        
        
        Scanner sc = new Scanner(System.in);
        
        String ip = sc.nextLine();
        
        String postfix =  infixToPostfix (ip);  
        
        //System.out.println(postfix);
        
        int evalResPostfix = evalPostfix(postfix);
        
        System.out.println("Result = " +evalResPostfix);
        //String input[] = ip.split(" ");
        
        sc.close();
    }
    
    
    // without brackets
    public static int evalPostfix(String p){
        
        p = p.trim();
        String arr[] = p.split(" ");
        
        Stack<String> s = new Stack<String>();
        
        for(int i=0; i<arr.length ; i++){
            
            String c = arr[i];
           //  System.out.println(" c= " +c);
            
            if(isNumeric(c)){
                s.push(c);
            }
            else{   // if operator
                char oper = c.charAt(0);
             //   System.out.println("oper = " + oper +" Stack size = "+s.size());
                int op2 = Integer.parseInt(s.pop());
                int op1 = Integer.parseInt(s.pop());
                
                int res =  evalExp(op1, op2, oper);
                s.push(res+"");
                
            }
            
        }
        
        int output = Integer.parseInt(s.pop());
        
        return output; 
        
        
    }
    
    public static int evalExp(int op1, int op2, char oper){
        
        if(oper== '*') return op1*op2;   
        else  if(oper== '/') return op1/op2;   
        else  if(oper== '+') return op1+op2;   
        else  if(oper== '-') return op1-op2;   
        return 0;
    }
    
    
    
    
    public static String infixToPostfix( String str){
        
        String arr[] = str.split(" ");
        Stack<String> s = new Stack<String>();
        StringBuffer res = new StringBuffer("");
        
        for(int i=0; i< arr.length ; i++){
            
            String ip = arr[i];
            //System.out.println("ip=  "+ip); 
            
            if(isNumeric(ip)){
                res.append(ip+" ");   
            }
            else{
                // is operator
                if(isOperator(ip)){
                    while(!s.empty() && !isOpenParen(s.peek())  && hasHigherPrec(s.peek() , ip) ){
                        res.append(s.peek()+" ");
                        s.pop();
                    }
                    s.push(ip);
                    
                }
                
                // open bracket
                if(isOpenParen(ip)){
                    s.push(ip);
                }           
                
                //close bracket
                if(isCloseParen(ip)){
                    while(!s.empty() && !isOpenParen(s.peek())  ){
                        res.append(s.peek()+" ");
                        s.pop();
                    }
                    s.pop();
                    
                }
                
            }
            
        }
        
        while(!s.empty()){
            res.append(s.pop()+" ");   
            
        }
        
        
        
        
        
        return res.toString();
    }
    
    public static boolean isNumeric(String s){
        
        try{
            double d = Double.parseDouble(s);
        }
        catch(NumberFormatException nfe){
            return false;   
        }
        return true;
    }
    
    
    public static boolean isOperator(String s){
        char c = s.charAt(0);
        
        if( c== '*' || c=='/' || c=='+' || c=='-'  ){
            return true;   
        }
        return false;
    }
    
    
    
    public static boolean hasHigherPrec(String a, String b){
        
        if(  val(a.charAt(0)) < val(b.charAt(0))   ) return true;
        else return false;
        
    }
    
    
    public static int val(char t){
        
        if(t=='(' || t==')'||t=='{' || t=='}' || t=='[' || t==']' )  return 1;
        
        else if( t=='*' || t=='/' ) return 2;
        
        else if(  t=='+' || t=='-' ) return 3;
        
        return 0;
        
    }
    
    public static boolean isOpenParen(String s){
        char t = s.charAt(0);
        if(t=='(' || t=='{' ||  t=='['  )  return true;
        return false;  
        
    }
    
    public static boolean isCloseParen(String s){
        char t = s.charAt(0);
        
        if(t==')' || t=='}' || t==']' ) return true;
        return false;
        
    }
    
    
    
    
    
    
    
}

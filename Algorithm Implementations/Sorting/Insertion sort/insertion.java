import java.io.*;
import java.util.*;
public class insertion{
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        // Read Input
        for(int i=0; i< N ;i++){
            a[i] = sc.nextInt();
            
        }
        int min;
        
        for(int i=0; i<N ;i++){
           
            for(int j=i; j>0 ;j--){
                if(a[j] < a[j-1]){
                     int temp = a[j];
                     a[j] = a[j-1];
                     a[j-1] = temp;
                    
                }
                
            }
            
          
            
        }
        
        
        for(int i=0; i< N ;i++){
            System.out.print(a[i]+"");
        }
        
        sc.close();
        
    }
    
    
}

public class quicksort{
    
    static int A[] = {6,2,3,1,9,10,15,13,12,17, 33, 0 , 5 ,4};
    public static void main(String args[])  {
        
        
        Quicksort(A, 0, A.length-1);
        
        for(int i=0; i<A.length ; i++){
            System.out.print(A[i]+" ");
        }
        
        
    }
    
    
    public static void Quicksort(int A[],int start,int  end){
        
        if(start>= end)return ;
        
        int i = start+1;
        int j = end;
        int temp;
        
        while(i<j){
           
            
            while(A[i] < A[start]){
                i= i+1;   
            }
            
            while(A[j] > A[start]){
                j=j-1;   
            }
            
            if(i<j){
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            
        }
        
        // swap a[j] and a[start]
        
        temp = A[j];
        A[j] = A[start];
        A[start]= temp;
        
        Quicksort(A, start, j-1);
        Quicksort(A,j+1,end);
    }
    
    
    
    
    
}
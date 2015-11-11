
import java.io.*;
import java.util.*;

public class mergesort{
    
     static int A[] = {6,2,3,1,9,10,15,13,12,17, 33, 0 , 5 ,4};
    public static void main(String args[]){
        
        
       
        MergeSort(A);
        
        for(int i=0; i<A.length ; i++){
            System.out.print(A[i]+" ");
        }
        
        
    }
    
    
    public static void MergeSort(int[] A){
        int n = A.length;
        if(n<2) return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        int k =0      ; // index for A array
        
        for(int i=0; i< mid; i++)  {
            left[i] = A[k];
            k++;
        }
        for(int j=0; j< n-mid ; j++){
         right[j] = A[k];
         k++;
        }
        
        MergeSort(left);
        MergeSort(right);
        Merge(A, left , right);
        
        
    }
    
    public static void Merge(int[] A, int[] L , int[] R){
        
        int nA = A.length ;
        int nL = L.length;
        int nR = R.length;
        int i=0, j=0, k=0;        //indexes for  main array, left subarray and right subarray
        
        while(j <nL  && k < nR){    // when both subarrays have elements
            
            if(L[j] < R[k]){
                
                A[i] = L[j];
                j++;
            }
            else{
                A[i] = R[k];
                k++;
                
            }
            i++;
            
        }
        
        
        while(k < nR ){          // when left is finished
            A[i]  = R[k];
            i++;
            k++;
        }
        
        while( j < nL ){         // when right is finished
            A[i]  = L[j];
            i++;
            j++;
        }
        
        
        
        
        
        
    }
    
    
}
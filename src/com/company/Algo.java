package com.company;

// firstIndexOf , lastIndexOf , has functions have raw implementation.
// for other functions we will reuse the implemented functions.

// Explanation:

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algo {
    private static int firstIndexOf(int arr[],int x){
        int lo=0,hi=arr.length-1;
        int res=-1;
        while(lo<=hi){
            int mid = (lo + hi) / 2;
            if (arr[mid] > x)
                hi = mid - 1;
            else if (arr[mid] < x)
                lo = mid + 1;
            else
            {
                res = mid;
                hi = mid - 1;
            }
        }
        return res;
    }

    //SecondIndexOf makes use of firstIndexOf
    private static int secondIndexOf(int []arr, int x){
        int firstIndex=firstIndexOf(arr,x);
        if(firstIndex!=-1 && firstIndex<arr.length-1 && arr[firstIndex+1]==x)
            return firstIndex+1;
        else    return -1;
    }
    private static int lastIndexOf(int arr[],int x){
        int lo=0,hi = arr.length - 1;
        int res = -1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (arr[mid] > x)
                hi = mid - 1;
            else if (arr[mid] < x)
                lo = mid + 1;
            else
            {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }
    static boolean has(int arr[],int sum){
        Set<Integer> hash=new HashSet<>();
        for(int element : arr){
            if(hash.contains(sum-element))
                return true;
            hash.add(element);
        }
        return false;
    }

    //hasTriple makes use of has function
    private static boolean hasTriple(int arr[],int sum){
        for(int i=2;i<arr.length;i++){
            int arraySoFar[]= Arrays.copyOfRange(arr, 0, i-1);
            if(has(arraySoFar,sum-arr[i]))  return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={1,3,5,5,7,8,8,8,9,11,12,12,15};
        System.out.println(firstIndexOf(arr, 8));
        System.out.println(secondIndexOf(arr, 8) );
        System.out.println( lastIndexOf(arr, 8));
        System.out.println( has(arr, 23));
        System.out.println( hasTriple(arr, 35));
    }
}




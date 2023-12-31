// 1D_Array_Basics_with_code
import java.util.*;
import java.lang.*;
import java.io.*;
public class Arrays {




        public static void update(int marks[]){
            for(int i=0;i<marks.length;i++){
                marks[i]= marks[i]+1;
            }
        }
        public static int Search(int n[] , int key){
            for(int i=0;i<n.length;i++){
                if(n[i]==key){
                    return i;
                }
            }
            return -1;
        }
        public static int largestNumber(int a[]){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<a.length;i++){
                if(a[i]> max){
                    max = a[i];
                }
            }
            return max;
        }
        public static int BinarySearch(int number[], int key){
            int start =0,end=number.length-1;
            while(start <= end){
                int mid = (start + end)/2;
                // comparison
                if(number[mid]== key){
                    return mid;
                }
                if(number[mid]<key){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            return -1;
        }
        public static void ReverseArray(int [] array){
            int first =0, last = array.length-1;
            while(first<last){
                // swap
                int temp = array[last];
                array[last]= array[first];
                array[first]=temp;
                first++;
                last--;
            }
        }
        public static void Pair(int []number){
            int count=0;
            for(int i=0;i<number.length;i++){
                for(int j=i+1;j<number.length;j++){
                    System.out.print("("+number[i]+","+number[j]+")");
                    count++;
                }
                System.out.println();
            }
            System.out.print("count pf pairs is "+count);
        }
        public static void PrintSubarray(int numbers[]){
            int count=0; int sum=0;int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<numbers.length;i++){
                for(int j=i;j<numbers.length;j++){

                    for(int k=i;k<=j;k++){
                        sum = sum+numbers[k];
                        System.out.print(numbers[k]+" ");// subarray
                    }
                    count++;
                    System.out.println();

                    if(sum >max){
                        max = sum;
                    }

                    if(min>sum){
                        min = sum;
                    }
                    sum=0;
                }
                System.out.println();
            }
            System.out.println("total subarray is "+ count);
            System.out.println("MAX sum of Subarray " +max);
            System.out.println("MIN sum of Subarray " +min);
        }
        public static void MaxSubarray(int number[]){
            int currSum=0;
            int maxSum = Integer.MIN_VALUE;
            int Prefix[]= new int[number.length];
            Prefix[0]= number[0];
            for(int i=1;i<Prefix.length;i++){
                Prefix[i]=Prefix[i-1]+number[i];
            }

            for(int i=0;i<number.length;i++){
                int start =i;
                for(int j=i;j<number.length;j++){
                    int end =j;
                    currSum = start==0 ? Prefix[end] : Prefix[end] - Prefix[start-1];
                    if(maxSum < currSum){
                        maxSum = currSum;
                    }
                }
            }
            System.out.println("max sum "+maxSum);
        }
        public static void Kadanes(int numbers[]){
            int ms = Integer.MIN_VALUE;
            int cs =0;

            for(int i=0;i<numbers.length;i++){
                cs = cs+numbers[i];
                if(cs<0){
                    cs=0;
                }
                ms = Math.max(cs,ms);
            }
            System .out.println("Kadanes max sum of Subarray "+ms);
        }
        public static int height(int height[]){
            int left[] = new int[height.length];
            left[0]=height[0];
            for(int i=1;i<left.length;i++){
                left[i]=Math.max(height[i],left[i-1]);
            }
            int right[] = new int[height.length];
            right[height.length-1] = height[height.length-1];
            for(int i=right.length-2;i>=0;i--){
                right[i] = Math.max(height[i],right[i+1]);
            }

            int trappedwater =0;
            for(int i=0;i<height.length;i++){
                int waterlevel = Math.min(left[i],right[i]);
                trappedwater += waterlevel- height[i];
            }
            return trappedwater;
        }
        public static int Stocks(int [] price){
            int buysPrice = Integer.MAX_VALUE;
            int maxProfit =0;
            for(int i=0;i<price.length;i++){
                if(buysPrice <price[i]){
                    int profit = price[i]- buysPrice;
                    maxProfit = Math.max(maxProfit,profit);
                }else{
                    buysPrice =price[i];
                }
            }
            return maxProfit;
        }
        public static void main (String[] args) throws java.lang.Exception
        {
            // dataType arrayName[] = new dataType[Size];
            //Creating an array
            int mark[] = new int[50];
            int number[] = {1,2,3};
            int morenumber[] = {4,5,6};
            String fruits[] = {"apple","mango","orange"};

            // Passing arrays as IllegalArgumentException
            int marks[] = {97,98,99};
            update(marks);
            for(int i=0;i<marks.length;i++){
                System.out.print(marks[i]+" ");
            }
            System.out.println();

            // Linear Search TC O(n)
            // find the index of element in a given arrays
            int[] n = {2,4,6,8,10,12,14,16};
            int key =10;
            int index = Search(n , key);
            System.out.print(index);
            System.out.println();

            //largest number
            int a[] = {1,2,3,4,5};
            System.out.print(largestNumber(a));
            System.out.println();

            // BinarySearch TC O(log n)
            int b[] = {2,4,6,8,10,12,14};
            int k =10;
            System.out.println(BinarySearch(b,k));

            // Reverse an arrays
            int c[] = {2,4,6,8,10};
            ReverseArray(c);
            for(int j=0;j<c.length;j++){
                System.out.print(c[j]+" ");
            }
            System.out.println();

            // Pairs in an array TC O(n^2)
            int d [] ={2,4,6,8,10};
            Pair(d); // total pair = n(n-1)/2
            System.out.println();

            // Print Subarrays "a continuous part of array"
            PrintSubarray(d);

            // Max Subarrays Sum
            int e[] = {1,-2,6,-1,3};
            PrintSubarray(e);

            // Max Subarray sum by Prefix sum
            int f[] = {-2,-3,4,-1,-2,1,5,-3};
            MaxSubarray(f);

            // max Subarray sum by Kadane's Algorithm
            Kadanes(f);

            // Trapping Rainwater
            int height[] = {4,2,0,6,3,2,5};
            System.out.println(height(height));

            // Buys & Sell Stocks
            int price [] = {7,1,5,3,6,4};
            System.out.println(Stocks(price));

        }
    }
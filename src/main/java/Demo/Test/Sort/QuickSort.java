package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/21.
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));


    }


    public static void sort(int[] arr,int low,int high){
        int start = low;
        int end = high;
        //固定分割
        int key = arr[low];
        while (end>start){
            while (arr[end]>=key&&end>start){
                end--;
            }
            if(arr[end]<=key){
                int temp =  arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (arr[start]<=key&&end>start){
                start++;
            }
            if(arr[start]>=key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        if(start>low) sort(arr,low,start-1);
        if(end<high) sort(arr,end+1,high);
    }
}

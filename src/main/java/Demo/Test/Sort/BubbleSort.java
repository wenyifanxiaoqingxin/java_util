package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/22.
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};

        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    public static int[] bubbleSort(int[] arr){

        for(int i =0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        return arr;
    }
}

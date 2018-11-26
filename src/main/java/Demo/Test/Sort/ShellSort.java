package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/23.
 * 希尔 排序
 */
public class ShellSort {


    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};

        System.out.println(Arrays.toString(shellSort(a)));

    }


    public static  int[] shellSort(int[] arr){
        if(arr==null||arr.length<=1){
            return arr;
        }
        int creteNumber = arr.length/3;
        while (creteNumber>=1){
            for (int i=0;i<arr.length;i++){
                for (int j=i;j<arr.length-creteNumber;j+=creteNumber){
                    if(arr[j]>arr[j+creteNumber]){
                        int temp = arr[j];
                        arr[j] = arr[j+creteNumber];
                        arr[j+creteNumber] = temp;
                    }
                }
            }
            creteNumber = creteNumber/3;
        }
        return arr;

    }
}

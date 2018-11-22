package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/22.
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};

        System.out.println(Arrays.toString(insertSort(a)));
    }

    public static int[] insertSort(int[] arr){

        int  preIndex ,current;

        for(int i=1;i<arr.length;i++){
            preIndex = i-1;
            current = arr[i];
            while(preIndex>=0&&arr[preIndex]>current){
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }
}

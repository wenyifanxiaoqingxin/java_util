package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/22.
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};

        System.out.println(Arrays.toString(selectSort(a)));
    }

    public static int[] selectSort(int[] arr){

        int mindex;
        for(int i=0;i<arr.length;i++){
            mindex = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    mindex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mindex];
            arr[mindex] = temp;
        }

        return arr;
    }
}

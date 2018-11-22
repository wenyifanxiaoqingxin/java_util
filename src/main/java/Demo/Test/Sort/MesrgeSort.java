package Demo.Test.Sort;

import java.util.Arrays;

/**
 * Created by fx on 2018/11/21.
 * 归并排序
 */
public class MesrgeSort {

    public static void main(String[] args) {

        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }



    public static void mergeSort(int[] arr,int low,int high){

        int middle = (low+high)/2;
        if(low>=high){
            return;
        }
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,high,middle);
    }

    public static void merge(int[] a,int low,int high,int mid){

        int[] temp = new int[high+1];
        int i=low;
        int center = mid+1;
        int k =low;
        //把较小的数移动到新数组
        while (low<=mid&&center<=high){
            if(a[low]<a[center]){
                temp[k++]= a[low++];
            }else{
                temp[k++]= a[center++];
            }
        }
        //左边剩余移动到数组
        while (low<=mid){
            temp[k++]=a[low++];
        }
        while (center<=high){
            temp[k++]=a[center++];
        }

        for (int x=i;x<=high;x++){
            a[x] = temp[x];
        }

    }
}

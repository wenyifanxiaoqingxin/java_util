package Demo.Test.Sort;


import java.util.Arrays;

/**
 * Created by fx on 2019/1/7.
 * 堆排序
 */
public class HeapSort {

    private int arr[];
    private int heapSize;
    public HeapSort(){

    }
    public HeapSort(int[] arr){

    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i+1;
    }
    private int right(int i){
        return 2*i+2;
    }

    //构建最大堆
    public  void buildMaxHeap(int[] arr){
        this.arr = arr;
        this.heapSize = arr.length;

        for(int i=parent(heapSize-1);i>=0;i--){
                maxHeapify(i);
        }
    }
    //保持最大堆的特性
    public void maxHeapify(int i){
        int l =left(i);
        int r = right(i);
        int largest = i;

        if(l<=heapSize-1&&arr[l]>arr[largest]){
            largest = l;
        }
        if(r<=heapSize-1&&arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            this.maxHeapify(largest);
        }

    }

    //堆排序方法
    public void heapSort(int[] arr){
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>0;i--){
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapSize--;
            maxHeapify(0);
        }
    }


    public static void main(String[] args) {
        int a[] = new int[]{3,4,5,2,5,7,12,4,7,8};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}

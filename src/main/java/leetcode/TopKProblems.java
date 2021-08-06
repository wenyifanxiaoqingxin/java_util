package leetcode;

/**
 * @description: TopK问题，如在十亿个数找出最大的数或者最大的k个数
 * @author: fanxiao
 * @email: fanxiao@koolearn.com
 * @date: 2021/8/4 10:19 上午
 * 最小堆算法
 */
public class TopKProblems {

    private int[] createHeap(int a[],int k){
        int[] result = new int[k];
        //构建前n个数组
        for(int i=0;i<k;i++){
            result[i] = a[i];
        }
        //构建堆
        for(int i=result.length/2-1;i>0;i--){
            heapify(result,i);
        }

        return result;
    }

    //构建最小堆
    void heapify(int[] result,int i){

        int left =2*i+1;
        int right = 2*i+2;
        int smallest =i;
        if(left<result.length&& result[left]<result[smallest]){
                smallest = left;
        }
        if(right<result.length && result[right]<result[smallest]){
            smallest = left;
        }
        if(smallest==i){
            return;
        }else{
            int temp = result[i];
            result[i] = result[smallest];
            result[smallest]=temp;
        }
        heapify(result,smallest);
    }

    //调整堆
    void filterDown(int a[], int value) {
        a[0] = value;
        int parent = 0;

        while(parent < a.length){
            int left = 2*parent+1;
            int right = 2*parent+2;
            int smallest = parent;
            if(left < a.length && a[parent] > a[left]){
                smallest = left;
            }
            if(right < a.length && a[smallest] > a[right]){
                smallest = right;
            }
            if(smallest == parent){
                break;
            }else{
                int temp = a[parent];
                a[parent] = a[smallest];
                a[smallest] = temp;
                parent = smallest;
            }
        }
    }

    //遍历数组，并且调整堆
    int[] findTopKByHeap(int input[], int k) {
        int heap[] = this.createHeap(input, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] > heap[0]) {
                this.filterDown(heap, input[i]);
            }

        }
        return heap;

    }

    public static void main(String[] args) {
        int a[] = { 100,101,5,4,88,89,845,45,8,4,5,8,452,1,5,8,4,5,8,4,588,44444,88888,777777,100000};
        int result[] = new TopKProblems().findTopKByHeap(a, 5);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}

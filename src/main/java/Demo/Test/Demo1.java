package Demo.Test;

/**
 * Created by fx on 2018/11/12.
 */
public  class Demo1 {

    public static void main(String[] args) {
        int num[] = new int[]{-2,-1,0,1};
        System.out.println(getMinAbs(num));;
    }


     static  int getMinAbs(int[] num) {
        //当数组只有一个元素的情况直接返回
        if (num.length == 1)
            return num[0];

        //当数组非负时直接返回num[0]，当数组非正时直接返回num[num.length-1]
        if (num[0] >= 0)
            return num[0];
        else if (num[num.length - 1] <= 0)
            return num[num.length - 1];

        //当数组有正有负时，返回最大的负数与最小的非负数中较小的那一个
        int low = 0, high = num.length - 1, mid =(low + high) / 2;
        while (low < high) {
            if (num[mid] < 0)
                low = mid + 1;
            else if (num[mid] > 0) {
                if (num[mid] * num[mid - 1] < 0)
                    return Math.min(Math.abs(num[mid - 1]), num[mid]);
                high = mid - 1;
            } else
                return num[mid];

            mid = (low + high) / 2;
        }

        return 0;

    }
}

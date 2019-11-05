package thinkInJava;

import java.util.Scanner;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/7/25 20:40
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();

        System.out.println(getStep(numbers));
    }

    private static int getStep(int numbers){
        int methodNumber=0;
        if( numbers ==1 || numbers == 2){
            return numbers;
        }else {
            methodNumber = getStep(numbers-2)+ getStep(numbers-1);
            return methodNumber;
        }

    }
}

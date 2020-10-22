package Demo.Test.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/12/3 15:21
 */
public class LaymbdaMap {
    public static void main(String[] args) {


        List<Double> costBeforePrice = Arrays.asList(100.0,200.0,300.0,400.0);
        costBeforePrice.stream().forEach(System.out::println);
        costBeforePrice.stream().map((cost)->1.12*cost).forEach(System.out::println);
    }
}

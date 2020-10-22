package Demo.Test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/12/3 15:45
 */
public class LaymbdaCollection {
    public static void main(String[] args) {
        List<String> filtered = Arrays.asList("abc","bcdf","jkl","df");
        Predicate<String> predicate = (s)->s.length()>2;
        filtered.stream().filter(predicate).forEach(System.out::println);
    }


}

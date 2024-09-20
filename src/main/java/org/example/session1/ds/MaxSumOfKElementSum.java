package org.example.session1.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MaxSumOfKElementSum {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 3, 7, 9, 4);
        maxSumOfKElementSum(integerList,2);
    }

    private static void maxSumOfKElementSum(List<Integer> integers,int subsetSize){
        integers.sort(Comparator.comparingInt(Integer::intValue).reversed());
        int sum = IntStream.range(0, subsetSize)
                .map( v -> {
                    System.out.println(integers.get(v));
                    return integers.get(v);
                })
                .sum();
        System.out.println(sum);

    }
}

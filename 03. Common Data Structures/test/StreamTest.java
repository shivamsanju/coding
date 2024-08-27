package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args){
        String[] names = new String[]{"Kevin", "Paul", "Sammy", "John", "Joe", "Brad", "Harry"};
        Arrays.stream(names).forEach(System.out::println);

        List<String> namesList = List.of(names);
        namesList.stream().filter(x -> x.startsWith("J")).forEach(x -> System.out.print(x + " "));
        List<String> na = namesList.stream().filter(x -> x.startsWith("J")).collect(Collectors.toList());


        System.out.print(IntStream.range(0, 100).filter(x -> x%3 == 0).sum());


    }
}

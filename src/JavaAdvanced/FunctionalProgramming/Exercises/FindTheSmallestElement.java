package FunctionalProgramming.Exercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.List;
        import java.util.function.Function;
        import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<List<Integer>, Integer> smallestIndex =
                list ->  list.lastIndexOf(list.stream().min(Integer::compare).get());
        List<Integer> numbs = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(smallestIndex.apply(numbs));
    }
}

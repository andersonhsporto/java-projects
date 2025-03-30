import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "data.txt";

            List<Integer> leftList = readList(filePath, true);
            List<Integer> rightList = readList(filePath, false);

            leftList.sort(Integer::compareTo);
            rightList.sort(Integer::compareTo);

            List<Integer> distanceNbr = IntStream.range(0, leftList.size())
                    .mapToObj(i -> Math.abs(leftList.get(i) - rightList.get(i)))
                    .collect(Collectors.toList());

            int sum = distanceNbr.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Sum: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readList(String path, boolean isLeft) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            return reader.lines()
                    .map(line -> line.split("\\s+"))
                    .map(parts -> Integer.parseInt(parts[isLeft ? 0 : 1]))
                    .collect(Collectors.toList());
        }
    }
}

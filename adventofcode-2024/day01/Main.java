package com.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            Map<Integer, List<Integer>> levels = readFile("src/main/resources/data.txt");
            Integer safeLevels = 0;

            for (Map.Entry<Integer, List<Integer>> entry : levels.entrySet()) {
                if (isSafe(entry.getValue())) {
                    System.out.println("Level: " + entry.getKey() + " Nodes: " + entry.getValue());
                    safeLevels++;
                }
            }
            System.out.println(safeLevels + " reports are safe.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, List<Integer>> readFile(String path) throws IOException {
        Map<Integer, List<Integer>> levels = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            int level = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                List<Integer> nodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                levels.put(level++, nodes);
            }
        }
        return levels;
    }

    private static boolean isSafe(List<Integer> levels) {
        List<Integer> diffs =
                IntStream.range(0, levels.size() - 1)
                        .map(i -> levels.get(i + 1) - levels.get(i))
                        .boxed()
                        .collect(Collectors.toList());

        if (diffs.stream().anyMatch(diff -> Math.abs(diff) > 3 || diff == 0)) {
            return false;
        }

        boolean hasIncreasing = diffs.stream().anyMatch(diff -> diff > 0);
        boolean hasDecreasing = diffs.stream().anyMatch(diff -> diff < 0);

        return !(hasIncreasing && hasDecreasing);
    }


}

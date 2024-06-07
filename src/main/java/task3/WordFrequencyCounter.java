package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

    public static void displayWordFrequenciesSorted(File file) {
        if (!file.exists()) {
            System.err.println("File not found: " + file.getPath());
            return;
        }
        if (file.length() == 0) {
            System.err.println("File is empty: " + file.getPath());
            return;
        }
        Map<String, Integer> wordFrequencies = countWordFrequencies(file);
        if (wordFrequencies.isEmpty()) {
            System.err.println("No words found in the file: " + file.getPath());
            return;
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencies.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static String[] readFileAndSplitWords(File file) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordsList.toArray(new String[0]);
    }

    private static Map<String, Integer> countWordFrequencies(File file) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = readFileAndSplitWords(file);
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}

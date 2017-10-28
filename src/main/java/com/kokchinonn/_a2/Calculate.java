//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import static com.kokchinonn._a2.AssignmentTwo.KEYWORDS;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculate {
    
    void Format() throws IOException{
        
        final String[] info = new String[4];
        List<Information> informations = new ArrayList<>();
        FileHandler fileHandler = new Save();
        
        try (Stream<java.nio.file.Path> paths = Files.walk(Paths.get("Assignment2_TestFiles"))) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                final String[] name = new String[1];
                try{
                List<String> content = Files.lines(path).collect(Collectors.toList());
                content.forEach(s -> {
                    if (s.startsWith("//Semester: #") && info[0] == null) {
                        info[0] = s.split("#")[1];
                    } else if (s.startsWith("//Course: #") && info[1] == null) {
                        info[1] = s.split("#")[1];
                    } else if (s.startsWith("//Group: #") && info[2] == null) {
                        info[2] = s.split("#")[1];
                    } else if (s.startsWith("//Task: #") && info[3] == null) {
                        info[3] = s.split("#")[1];
                    } else if (s.startsWith("//Matrik: #")) {
                        name[0] = s.split("#")[1];
                    }
                });
                if (name[0] != null) {
                    Map<String, Integer> wordCount = new HashMap<>();
                    long comments = content.stream().filter(line -> line.contains("//")).count();
                    long blanks = content.stream().filter(line -> line.replaceAll("\\s", "").length() == 0).count();
                    long actual = content.size() - blanks - comments;
                    final int[] totalKeywords = {0};
                    KEYWORDS.forEach(keyword -> {
                        final int[] count = {0};
                        content.forEach(line -> count[0] += Arrays.stream(line.split("\\s")).filter(word -> word.equals(keyword)).count());
                        if (count[0] > 0) {
                            totalKeywords[0] += count[0];
                        }
                        wordCount.put(keyword, count[0]);
                    });
                    Information information = new Information(name[0], content.size(), blanks, comments, actual, wordCount, actual + totalKeywords[0]);
                    informations.add(information);}
                } catch (IOException e) {
                }
            });
        }
        fileHandler.storeData(info,informations);
        
    }
}

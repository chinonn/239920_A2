//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignmentTwo {

    public static final List<String> KEYWORDS = Arrays.asList("null", "true", "false", "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while");
    public static final String FILENAME = "result.xlsx";
    
    public static void main(String[] args) throws Exception {
       Find find=new Find();
       String[] listJavaFile = find.listJavaFile;
       AssignmentTwo assignmentTwo= new AssignmentTwo();
       assignmentTwo.compute();      
    }
    
    void compute() throws IOException{
        final String[] headers = new String[4];
        List<Information> informations = new ArrayList<>();
        FileHandler fileHandler = new Save();
        
       try (Stream<Path> paths = Files.walk(Paths.get("Assignment2_TestFiles"))) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                final String[] name = new String[1];
                try{
                List<String> content = Files.lines(path).collect(Collectors.toList());
                content.forEach(s -> {
                    if (s.startsWith("//Semester: #") && headers[0] == null) {
                        headers[0] = s.split("#")[1];
                    } else if (s.startsWith("//Course: #") && headers[1] == null) {
                        headers[1] = s.split("#")[1];
                    } else if (s.startsWith("//Group: #") && headers[2] == null) {
                        headers[2] = s.split("#")[1];
                    } else if (s.startsWith("//Task: #") && headers[3] == null) {
                        headers[3] = s.split("#")[1];
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
        fileHandler.storeData(headers,informations);
    }
}
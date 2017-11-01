//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.util.Arrays;
import java.util.List;

public class AssignmentTwo {

    public static final List<String> KEYWORDS = Arrays.asList("null", "true", "false", "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while");
    public static final String FILENAME = "result.xlsx";
    
    public static void main(String[] args) throws Exception {
       Find find=new Find();
       String[] listJavaFile = find.listJavaFile;    
       Calculate calculate= new Calculate();
       calculate.Format();
    }
}
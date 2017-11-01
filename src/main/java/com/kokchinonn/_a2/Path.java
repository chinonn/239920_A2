//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.io.File;

public class Path {
    
    public static String getPath(String folderName) {
        return System.getProperty("user.dir") + File.separator + folderName;
    }
    
}

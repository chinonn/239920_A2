//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.util.Map;

public class Information {
        private String name;;
        
        Information(String name, long loc, long blank, long comment, long actual, Map<String, Integer> wordCount, long total) {
            this.name = name;
        }
        
        public String getName() {
        return name;
        }
        
        public void setName(String name) {
        this.name = name;
        }     
}

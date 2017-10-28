//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import static org.junit.Assert.*;

public class pathTest {
    
     public void testGetPath() {
        System.out.println("getPath");
        String folderName = "";
        String expResult = "C://Users//Users//Documents//NetBeansProjects//AssignmentTwo//Assignment2_TestFiles";
        String result = Path.getPath(folderName);
        assertEquals(expResult, result);
    }
}

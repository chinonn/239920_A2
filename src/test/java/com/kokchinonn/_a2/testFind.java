package com.kokchinonn._a2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class testFind {
    
    public testFind() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddTree() {
        System.out.println("addTree");
        File file = new File("C://Users//Users//Documents//NetBeansProjects//AssignmentTwo//Assignment2_TestFiles");
        Collection<File> all = new ArrayList<>();
        Find.addTree(file, all);
    }

    @Test
    public void testFilterJava() {
        System.out.println("filterJava");
        Collection<File> listAllFileName = new ArrayList<>();
        String[] expResult = {};
        String[] result = Find.filterJava(listAllFileName);
        assertArrayEquals(expResult, result);

    }
}

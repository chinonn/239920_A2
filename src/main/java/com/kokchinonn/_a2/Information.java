//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment1
//Matrik: #239920
//Name: #Kok Chin Onn
package com.kokchinonn._a2;

import java.util.Map;

public class Information {
        private String name;
        private long loc;
        private long blank;
        private long comment;
        private long actual;
        private Map<String, Integer> wordCount;
        private long total;
        
        Information(String name, long loc, long blank, long comment, long actual, Map<String, Integer> wordCount, long total) {
            this.name = name;
            this.loc = loc;
            this.blank = blank;
            this.comment = comment;
            this.actual = actual;
            this.wordCount = wordCount;
            this.total = total;
        }
        
        public String getName() {
        return name;
        }
        
        public void setName(String name) {
        this.name = name;
        }
        
        public long getLoc() {
        return loc;
        }

        public void setLoc(long loc) {
        this.loc = loc;
        }
        
        public long getBlank() {
        return blank;
        }
        
        public void setBlank(long blank) {
        this.blank = blank;
        }
        
        public long getComment() {
        return comment;
        }

        public void setComment(long comment) {
        this.comment = comment;
        }

        public long getActual() {
        return actual;
        }

        public void setActual(long actual) {
        this.actual = actual;
        }

        public Map<String, Integer> getWordCount() {
        return wordCount;
        }

        public void setWordCount(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
        }

        public long getTotal() {
        return total;
        }

        public void setTotal(long total) {
        this.total = total;
        }
}

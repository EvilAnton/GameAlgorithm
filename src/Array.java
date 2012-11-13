import java.util.*;

/**
 * Class with main methods for working with arrays.
 * @param printArray Prints an array as (9 x n) dimension array.
 * @param findMatch Finds in the given array nearest elements equal each other or their summ equals ten. 
 * Returns their indexes in the array.
 * @param getFirstArray returns the initializing array.
 * @param getMatchList returns the list with indexes of matches.
 * @author Copyright (c) Anton Shekhov 
 */
public class Array {
    
    // initializing array
    private final int [] FIRST_ARRAY = {1,2,3,4,5,6,7,8,9,1,1,1,2,1,3,1,4,1,5,1,6,1,7,1,8,1,9};
    ArrayList <Index> matchList = new ArrayList <> ();
    private int j = 0;
    private int i = 0;

    /**
     * Looking for the matches of the elements, located near by.
     * Create a list with indexes of matches elements.
     */
    void findMatch (int [] array) {
        // m - is a namber of raw
        int m = 1;
        int length = array.length;
        
        // hides zerous from the end
        if (array[length-1] == 0){
            while (array[length-1] == 0) {
                length--;
            }
        }     

        int counter = 0;
        // По всей длине массива
        for (i = 0; i < (length - 1); i++) {
            // пропускает все нулевые элементы
            if (array[i] == 0) {
              while (array[i] == 0){
                i++;
              }
            }

            // Проверка по горизонтали
            // System.out.print (i + " ");
            for (j = i+1; j < length; j++){
                //System.out.print (j+"; ");
                // checks for zerous in a raws
                if (array[j] == 0) { 
                    while (array[j] == 0) {
                        j++;
                    }
                }
                
                if (array[i] == array[j] | array [i] + array [j] == 10) {
                  Index ind = new Index (i, j);
                  matchList.add(counter, ind);
                  counter++;
                  //System.out.print("counter: " + array[i] + " and " + array[j] + "; ");
                  break;
                }
                
                if (array [i] != array [j]){
                    break;
                }
            }
            // Проверка по вертикали    
            for (j = i + 9 * m; j < length; m++) {
                //System.out.print (j+" ");
                // checks for zerous in the columns
                if (array[j] == 0) {
                    while (array[i] == 0) {
                        m++;
                    }
                }
                
                if (array[i] == array[j] | array [i] + array [j] == 10) {
                  Index ind = new Index (i, j);
                  matchList.add(counter, ind);
                  counter++;
                  //System.out.print("counter: " + array[i] + " and " + array[j]);
                  break;
                } 
                
                if (array [i] != array [j]){
                    break;
                }   
            }
        }
    }
    
    // Returns the initializing array
    int [] getFirstArray (){
        return FIRST_ARRAY;
    }
    
    /** 
     * Returns the list with indexes of matches
     */ 
    ArrayList getMatchList (){
        return matchList;
    }
    
    // Prints array as on the paper (9 x n)
    void printArray (int[] array){
        for (i = 0; i < (array.length/9);  i++) {
            for (j = 0; j < 9; j++){
                System.out.print("[" + array[(i*9)+j] + "] ");
            }
            System.out.println();
        }
    }
    
}

class Index {
    int [] m = new int [2];
    Index (int first, int second){
       m [0] = first; 
       m [1] = second;
    }
}




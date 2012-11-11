import java.util.*;

/**
 * Consists main methods for working with arrays
 * @param printArray Prints an array as 9 x n dimension array
 * @param print Prints any array
 * @param findMatch Finds in the given array nearest elements equal each other or their summ equals ten. 
 * Returns their indexes in the array.
 * @author Copyright (c) Anton Shekhov 
 */
public class Array {
    
    final int [] FIRST_ARRAY = {1,2,3,4,5,6,7,8,9,1,1,1,2,1,3,1,4,1,5,1,6,1,7,1,8,1,9};
    ArrayList <Index> list = new ArrayList <> ();
    private int j = 0;
    private int i = 0;
    
    void printArray (int[] array){
        for (i = 0; i < (array.length/9);  i++) {
            for (j = 0; j < 9; j++){
                System.out.print("[" + array[(i*9)+j] + "] ");
            }
            System.out.println();
        }
    }
    void printList (ArrayList list){
        for (int i = 0; i < list.size(); i++){
            Index ob = (Index) list.get(i);
            System.out.print(i+ ")");
            for (int j = 0; j < ob.m.length; j++){
                System.out.print ("[" + ob.m[j] +"] ");
            }
            System.out.println();
        }
    }
    void printTwoDimArray (int [][] array){
        for (i = 0; i < array.length; i++){
            for (j = 0; j < array[i].length; j++){
                System.out.print ("[" + array[i][j] + "] ");
            }
            System.out.println();
        }
    }
    int [] getFirstArray (){
        return FIRST_ARRAY;
    }
    /** 
     * Return list with indexes
     */ 
    ArrayList getList (){
        return list;
    }
    int [][] getMatchAsMatrix () {
        int [][] matches = new int [list.size()][];
        for (int i = 0; i < list.size(); i++){
            Index ob = (Index) list.get(i);
            matches[i] = ob.m;
        }
        //printTwoDimArray (matches);
        return matches;
    }

    
    /**
     * Looking for the matches of the elements, located near by.
     * Create a list with indexes of matches elements.
     */
    void findMatch (int [] array) {
        int m = 1;
        int length = array.length;
        int counter = 0;
        // По всей длине массива
        for (i = 0; i < (length - 1); i++) {
        // пропускает все нулевые элементы
            if (array[i] == 0) {
                while (array[i] == 0){
                    i++;
                }
            }
            //System.out.print("["+i+"] - ");
            // Проверка по горизонтали
            for (j = i+1; j < length; j++){
                //System.out.print (j+"; ");                
                if (array[i] == array[j] | array [i] + array [j] == 10) {
                  Index ind = new Index (i, j);
                  list.add(counter, ind);
                  counter++;
                  //System.out.print("counter: " + array[i] + " and " + array[j] + "; ");
                  break;
                }
                if (array [i] != array [j] & array[j] != 0){
                    break;
                }
            }
            // Проверка по вертикали    
            for (j = i + 9 * m; j < length; m++) {
                //System.out.print (j+" ");                
                if (array[i] == array[j] | array [i] + array [j] == 10) {
                  Index ind = new Index (i, j);
                  list.add(counter, ind);
                  counter++;
                  //System.out.print("counter: " + array[i] + " and " + array[j]);
                  break;
                }
                if (array [i] != array [j] & array[j] != 0){
                    break;
                }
            }
            //System.out.println();
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




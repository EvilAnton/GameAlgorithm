import java.util.*;

/**
 * Class implements the one step of checking and creation of new arrays.
 * Extends all method of Array class.
 * @param startStep take an array and based on checkList create N new arrays. 
 *      Input (int [] array), return void
 * 
 * @author  Anton Shekhov 
 */
public class Step extends Array {
    
    // The collection with arrrays for the next step
    ArrayList <Data> stepList = new ArrayList <> ();
    // The collection with arrays for the next round (which has no more matches)
    ArrayList <Data> roundList = new ArrayList <> ();
    
    /**
     * The one itteration of step. 
     * @param array int [] which is need to be analize
     */
    void startStep (int [] array) {
        int i;
        // Findes the matches in the first, array-base. Fills the matchList.
        findMatch(array);
        
        // If there are no matches, then fills the roundList. This array is quit until the next Round
        if (matchList.isEmpty()) {
            Data oldArray = new Data (array);
            roundList.add(oldArray);
        }
        // else fills the stepList for the nex Step
        else {
            // Creates the list of future arrays
            for (i = 0; i < matchList.size(); i++){
                // create temp array, which will be used for creation of new array
                int [] temp = new int [array.length];
                // copies input array to the temp array
                System.arraycopy(array, 0, temp, 0, array.length);
                // takes from listMatches indexes of i elements
                Index ob = (Index) matchList.get(i);
                
                //System.out.println ((ob.m[0]+1) + " and " + (ob.m[1]+1));
                // changes to zerous elements from the listMatches
                temp[ob.m[0]] = 0;
                temp[ob.m[1]] = 0;

                // create a copy of class Data with changed array
                Data newArray = new Data (temp);
                // fills stepList by changed array
                stepList.add(i, newArray);
            }
        }
    }
    
    /**
     * Get i-th array from the stepList.
     * @param i the array's index in the list
     * @return array
     */
    int [] getStepArray (int i) {
        return stepList.get(i).newArray;        
    }
    
    /**
     * 
     * @param array 
     */
    void writeInRoundList (int [] array){
        int length = array.length;
        int countZero = 0;
        for (int i = 0; i < length; i++){
            if (array[i] == 0) {
                countZero++;
            }
        }

    }
}

/**
 * Class for creaction an array object.
 * @author Anton Shekhov
 */
class Data {
    int [] newArray;
    // Constructor of the class
    Data (int [] newArray) {
        this.newArray = newArray;
        /*for (int i = 0; i < newArray.length; i++){
         * System.out.print(newArray[i]);
         * }
         * System.out.println();*/
    }
}

class Integer {
    int n;
    Integer (int n){
        this.n = n;
    }
}

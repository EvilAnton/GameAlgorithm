
import java.util.*;



/**
 * Class implements the one step of checking and creation of new arrays.
 * @author  Anton Shekhov 
 */
public class Step extends Array{

    ArrayList <Data> data = new ArrayList <> ();

    void startStep (int [] array) {
          int i;
          // Findes the matches in the first, array-base.
          findMatch(array);

          // Creates the list of future arrays
          for (i = 0; i < list.size(); i++){
            int [] temp = new int [array.length];
            System.arraycopy(array, 0, temp, 0, array.length);
            Index ob = (Index) list.get(i);
            System.out.println ((ob.m[0]+1) + " and " + (ob.m[1]+1));
          
            temp[ob.m[0]] =0;
            temp[ob.m[1]] = 0;
            Data mtr = new Data (temp);
          // Adds changed array in the ArrayList data
            data.add(i, mtr);
          }

        
    }
}

class Data {
    //int [] newArray;
    Data (int [] newArray) {

         for (int i = 0; i < newArray.length; i++){
         System.out.print(newArray[i]);
         }
         System.out.println();
    }
}

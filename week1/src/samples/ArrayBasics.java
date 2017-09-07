package samples;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Basic use of Arrays.
 *
 * An array is a consecutive "row" of variables (elements). All variables in the array must have the same type!
 *
 * We can't access an array directly, an array is an nameless object in memory. To
 * access it we need an array variable i.e. a variable declared with an array type.
 * An array variable will hold a reference to the array object.
 *
 * Array types are:
 * - int[], int array
 * - double[],
 * - char[]
 * - etc. for all primitive type (type with brackets after)
 * - String[], array of strings
 * - .. more later.
 *
 * To access individual variables we use indices (the order number of the variable)
 * - Indexing starts at 0! So last element is length -1
 *
 */
public class ArrayBasics {

    public static void main(String[] args) {
        new ArrayBasics().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] arr = {7, 1, 0, 4, -2};   // Declare array variable arr and initialize it
        // Will create object with 5 int variables with given values and index 0 to 4.


        out.println(arr);                  // Bad (strange) output style ... (will print id of object in memory)
        out.println(Arrays.toString(arr)); // ... much better, use built in utility (see import at top)

        out.println(arr[0]);       // Use index to read value of single variable
        out.println(arr[3]);

        // --- Some manipulation, using indices ------------
        arr[0] = 2;     // Assign using index
        int n = 8;
        arr[1] = n;
        n = arr[2];
        arr[4]--;       // Decrement
        arr[2] = arr[3];
        out.println(Arrays.toString(arr));

        //arr[5]++;      // Exception, index outside

        int j = 2;      // Variables for indexing
        arr[j] = 99;
        arr[j + 1] = arr[j];  // Indexing may use variables or expressions
        out.println(Arrays.toString(arr));

        // --- Create arrays in running code, i.e. NOT at declaration, MUST use "new" ------

        arr = new int[6];  // New array with 6 variables with value 0, default initialization
        out.println(Arrays.toString(arr));

        arr = new int[]{2, 9, 0, 1, -4};  // New array with 5 initialized variables
        out.println(Arrays.toString(arr));

        // -------------------------------------------

        int[] arr2 = {6, 7, 8};  // This is another declaration, declaring arr2 variable, no need for new!

        // ------- Traversing (visit all variables)-----------------

        // Arrays has default way to get length
        out.println("Length of array is " + arr2.length);

        // Use for loop to traverse (i.e. access one variable at the time in order)
        for (int i = 0; i < arr2.length; i++) {  // NOTE: Strictly less!
            out.print(2 * arr2[i] + " ");
        }
        out.println();

        // ----  IO  --------------------------
        String[] names = new String[3];   // Declare and create String array
        out.print("Input 3 names (enter after each) > ");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }
         out.println("Names are:");
        for (int i = 0; i < names.length; i++) {
            out.println(names[i]);
        }

    }
}

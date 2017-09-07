package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using classes for compound data of different types that in some sense belongs together
 *  (may be same type).
 *  Here we describe a "hero" using a class.
 *
 * See:
 * - ClassBasics
 */
public class Ex6Classes {

    public static void main(String[] args) {
        new Ex6Classes().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {


    }

    // ------ The class to use  -----------
    // A class for variables that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}

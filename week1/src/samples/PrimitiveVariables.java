package samples;


import static java.lang.System.*;

/*
 *  Primitive variables
 *
 *  A variable in Java is a alterable container for a specific type of value.
 *
 *  A primitive variable is a variable declared with a primitive type ( a built in type).
 *
 *  The primitive types are:
 *  - int, integers (14345)
 *  - double, real numbers (3.56)
 *  - boolean, the values true, false
 *  - char, a single character ('q')
 *  - and a few more (we don't need)
 *
 *  String is *NOT* a primitive type (more in other samples)!
 *
 *  Before using a variable it *MUST* be declared and initialized
 *  - Declare means specify type and name (yes, in that order)
 *  - In this sample we declare and initialize at the same time.
 *  - Declaration is a statement so put ; last
 *
 */
public class PrimitiveVariables {

    public static void main(String[] args) {
        new PrimitiveVariables().program();
    }

    void program() {
        // int a;         // Bad! Must give initial value
        int a = 0;        // Declare integer variable a, type and name, then initialize to 0
        int b = 5;        // 0 and 5 are integer literals (fixed values), automatically assigned type int
                          // I.e. literals and variables are compatible (types matches)

        out.println(a);   // This will print *value* in variable a on screen
        out.println(b);   // 5

        // ------ Assignment and in/decrement with int's ----------------
        a = 6;            // 0 overwritten now a contains 6
        b = a;            // 5 overwritten, replaced with a *copy* of a's value
        out.println(b);   // 6

        b++;              // Increment
        out.println(b);   // 7
        b--;              // Decrement
        out.println(b);   // 6

        a = b++;          // Avoid!! Just for illustration
        out.println(a);   // 6, *old* value of b was used in assignment (value before increment)!

        a = a + 1;        // + is addition. *Right side* of = evaluated first, then copied to left
        out.println(a);   // 7

        b = b + 2;        // Again
        out.println(b);   // 9

        // -- Other primitive types  -----------------------------
        boolean bl = true;
        double d = 0.77;  // NOTE: dot. 0.77 is a double literal, assigned type double
        char ch1 = 'X';   // NOTE: Single quote, 'X' is a character literal, assigned type char
        char ch2 = ' ';   // Space character

        // s is *NOT* a primitive variable (more to come)
        String s = "Hello world!";  // Double quote for Strings. Anything in double quotes is assign type String.

    }
}

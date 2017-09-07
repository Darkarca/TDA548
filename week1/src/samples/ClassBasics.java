package samples;

import static java.lang.System.out;

/*
 *  Classes are used when we have compound data (often different types) that
 *  in some sense belong together
 *
 *  Classes also defines new types (so we can declare variables).
 *
 */
public class ClassBasics {
    public static void main(String[] args) {
        new ClassBasics().program();
    }

    void program() {
        // A class also introduces a new typ (Dog). Use type to declare variable
        Dog d = new Dog();  // Must instantiate, i.e. create a dog object named d
        d.name = "Fido";    // Assign values to dog object, use "dot"-notation
        d.age = 3;

        d.age++;   // Getting older ...

        printDog(d);   // Send complete dog to method

        // Use new type to create an array of dogs
        Dog[] dogs = {new Dog(), new Dog()};  // 2 dogs
        dogs[0].name = "Caesar";   // dogs[0] is a dog, then dot-notation to access variables
        dogs[0].age = 13;
        dogs[1].name = "Rufus";
        dogs[1].age = 6;

        out.println(dogs[0].name);  // Print selected variables
        out.println(dogs[0].age);
        out.println(dogs[1].name);
        out.println(dogs[1].age);

        Dog dog = findOldest(dogs);
        printDog(dog);

        incAge(d);
        printDog(d);
    }

    // --- A class -----
    // Class declaration, keep all data for some Dog in one place
    class Dog {
        String name;   // A Dog has a name and...
        int age;       // ... and age
    }

    // Print complete dog
    void printDog(Dog dog) {
        out.print("Name: " + dog.name);   // Access values using dot-notation
        out.println(" Age:" + dog.age);
    }

    // Search for oldest Dog
    Dog findOldest( Dog[] dogs){
        int index = 0;
        int maxAge = dogs[index].age;
        for( int i = 0 ; i < dogs.length ; i++){
            if( dogs[i].age > maxAge){
                index = i;
                maxAge = dogs[i].age;
            }
        }
        return dogs[index];
    }

    void incAge( Dog dog ){
        dog.age++;
    }

}

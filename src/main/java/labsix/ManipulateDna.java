package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * This is lab six for Computer Science 111.
 * This lab will teach us to use the random class.
 * We will use this random class multiple times in this assignment.
 */
public class ManipulateDna {
  /**
   * This program will take a string of DNA and manipulate it.
   * Manipulations will be either inserting, deleting, or changing a random place in the DNA.
   * It will create multiple lines of output where we do all 3 manipulations.
   * I use a new random integer for each manipulation.
   */
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Aaron Altmeyer " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dna = scanner.nextLine();
    // Step Two: Compute the complement of the DNA String
    String udna = dna.toUpperCase();
    System.out.println("Okay, I am going to manipulate the DNA string: " + udna);
    System.out.println(" ");
    System.out.println("Enter a string containing only C, G, T, and A: " + udna);
    String comp1 = dna.replace('a', 'T');
    String comp2 = comp1.replace('t', 'A');
    String comp3 = comp2.replace('c', 'G');
    String comp4 = comp3.replace('g', 'C');
    System.out.println("Complement of " + udna + " is " + comp4);

    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    Random rnd = new Random();
    int inspos = rnd.nextInt(udna.length());
    String dnaletters = "ATCG";
    char letter = dnaletters.charAt(rnd.nextInt(dnaletters.length()));
    String insertdna = udna.substring(0, inspos) + letter + udna.substring(inspos);
    System.out.println("Inserting from positon " + inspos + " gives: " + insertdna);

    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    int delpos = rnd.nextInt(udna.length());
    String deletedna = udna.substring(0, delpos) + udna.substring(delpos + 1);
    System.out.println("Deleting from position " + delpos + " gives: " + deletedna);

    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    int cpos = rnd.nextInt(udna.length());
    String dd2 = udna.substring(0, cpos) + udna.substring(cpos + 1);
    String id2 = dd2.substring(0, cpos) + letter + dd2.substring(cpos);
    System.out.println("Changing from position " + cpos + " gives: " + id2);
    
    // Step Six: Display a final thankyou message
    System.out.println(" ");
    System.out.println("Thanks for using the ManipulateDna program.");
    System.out.println("Have an awesome day.");
  }

}

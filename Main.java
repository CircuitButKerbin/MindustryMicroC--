// Java Program to illustrate Reading from FileReader
// using BufferedReader Class

// Importing input output classes
import java.io.*;

// Main class
public class Main {

  // main driver method
  public static void main(String[] args) throws Exception {

    // File path is passed as parameter
    File cmm = new File("program.cmm");
    File mma = new File("prog.mma");
    // Note: Double backquote is to avoid compiler
    // interpret words
    // like \test as \t (ie. as a escape sequence)

    // Creating an object of BufferedReader class
    BufferedReader br = new BufferedReader(new FileReader(cmm));
    boolean dblock = false;
    // Declaring a string variable
    String st;
    // Condition holds true till
    // there is character in a string
    // Start reading this glorious file
    int filesize = 0;
    // ##############################//
    br.mark(8192);
    while (br.readLine() != null) {
      filesize = filesize + 1;
      System.out.println(filesize);
    }
    System.out.println(filesize);
    br.reset();
    String Code[] = new String[filesize];
    System.out.println(br.readLine());
    for (int i = 0; i < filesize; i++) {
      Code[i] = br.readLine();
    }
    System.out.println("Printing array");
    for (int i = 0; i < (filesize - 1); i++) {
      System.out.println(Code[i]);
    }
    System.out.println("Starting Compilation");
    for (int i = 0; i < (filesize - 1); i++) {
      if (Code[i].contains("data")) {
        System.out.println("Datablock at " + Integer.toString(i));
        int DBLen = i;
        System.out.println(Code[i].split(" ")[1]);
        if (Code[i].split(" ")[1] == "{") {
          System.out.println("Line 53");
          for (int z = 0; z < (filesize - 1); z++) {
            if ((Code[i] == "}\n") || (Code[i].split(" ")[0] == "}")) {
              System.out.println("Data Block size is: " + Integer.toString(z - DBLen));
            }
          }
        }

      }
    }
  }
}
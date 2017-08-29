// This program reads a string, removes all its heading and
// trailing spaces, and replaces every block of consecutive
// spaces with a single space.

// Add import statement(s) below
import java.util.*;

public class PrettyPrinter {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  System.out.println("Enter a line below:");
  String line = sc.nextLine();
  String newLine = line.trim();
  newLine = newLine.replaceAll("[ ]+", " ");

 
  System.out.println("Pretty-printed line:");
  System.out.println("|" + newLine + "|");
 }
}


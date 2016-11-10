import java.util.Scanner;

public class Plurals {
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a noun: (or 'quit' to end)");
      String word = input.nextLine();

      while (!word.equals("quit")) {
         if (word.length() == 0) {
            System.out.println("No word entered");
         } else {
            System.out.println("Plural of " + word + " is " + makePlural(word));
         }
         word = input.nextLine();
      }

      System.out.println("Goodbye");
   }

   //Returns the plural of word
   public static String makePlural(String word) {
      String ending = lastTwoChars(word);

      if (ending.endsWith("o")) {
         if (isAVowel(ending.charAt(0))) {
            return word + "s";
         } else {
            return word + "es";
         }
      } else if (ending.endsWith("y")) {
         if (isAVowel(ending.charAt(0))) {
            return word + "s";
         } else {
            return dropLastNChars(word, 1) + "ies";
         }
      } else if (ending.equals("ch") || ending.equals("sh") || ending.equals("ss") || word.endsWith("s") || word.endsWith("x")) {
      	 return word + "es";
      } else if (word.endsWith("f")) {
      	 return dropLastNChars(word, 1) + "ves";
      } else if (word.endsWith("fe")) {
      	 return dropLastNChars(word, 2) + "ves";
      } else {
      	 return word + "s";
      }
   }

   //Returns the String word with the last N characters removed.
   public static String dropLastNChars(String word, int n) {
         return word.substring(0, word.length() - n);
   }

   //Returns the last two letters of word as a single string.
   public static String lastTwoChars(String word) {
         return word.substring(word.length() - 2);
   }

   //Returns true if letter is a vowel, otherwise it returns false
   public static boolean isAVowel(char letter) {
      if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
        return true;
      } else {
        return false;
      }
   }
}

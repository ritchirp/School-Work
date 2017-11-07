// Robert Ritchie
// CSE 174
// takes a word and converts it to pig latin
// Test Cases:
// easy, easyway
// hard, ardhay
// hmm, hmmay

import java.util.Scanner;

public class PigLatin{
   public static void main(String[] args){
      // gets the word
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a word: ");
      String word = keyboard.next();
      
      // obtains the position of the first vowel
      int vowelPosition = word.indexOf('a');
      if(word.indexOf('a')==-1)
         vowelPosition = 29; //note: the longest word in the oxford english dictionary is 30 letters
                             // and ends in a consonant
      if(word.indexOf('e')<vowelPosition && word.indexOf('e')!=-1)
         vowelPosition = word.indexOf('e');
      if(word.indexOf('i')<vowelPosition && word.indexOf('i')!=-1)
         vowelPosition = word.indexOf('i');
      if(word.indexOf('o')<vowelPosition && word.indexOf('o')!=-1)
         vowelPosition = word.indexOf('o');
      if(word.indexOf('u')<vowelPosition && word.indexOf('u')!=-1) 
         vowelPosition = word.indexOf('u');
      
      // converts the word to pig latin
      String conversion;
      if(vowelPosition == 0)
         conversion = word + "way";
      else if(vowelPosition == 29)
         conversion = word + "ay";
      else
         conversion = word.substring(vowelPosition) + word.substring(0,vowelPosition) + "ay";
      
      System.out.print("Pig Latin:    " + conversion);
   }
}
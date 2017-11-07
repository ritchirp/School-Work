// Robert Ritchie
// CSE 174
// Takes a date and finds basic information (i.e. day of the week, leap year etc.) about the date

import java.util.Scanner;

public class Program8{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Enter a date in mm/dd/yyyy format:");
      String date = keyboard.next();
      int day = getDay(date);
      int month = getMonth(date);
      int year = getYear(date);
      
      if (!isValidDate(month, day, year))
         System.out.print("This is not a valid date.");
      else{
         System.out.println("You entered " + dayOfWeek(month, day, year) + ", " + getMonthName(month)
                               + " " + day + ", " + year + ".");
         System.out.println("This month has " + daysInMonth(month, isLeapYear(year)) + " days.");
         
         if (isLeapYear(year))
            System.out.println(year + " is a leap year.");
         else
            System.out.println(year + " is not a leap year.");
         
         System.out.println("This is day number " + elapsedDays(month, day, year) + " of the year.");
      }
   }
   
   // Takes a string in the format mm/dd/yyyy and gets the month as an integer
   public static int getMonth(String date){
      return Integer.parseInt(date.substring(0,2));
   }
   
   // Takes a string in the format mm/dd/yyyy and gets the day as an integer
   public static int getDay(String date){
      return Integer.parseInt(date.substring(3,5));
   }
   
   // Takes a string in the format mm/dd/yyyy and gets the year as an integer
   public static int getYear(String date){
      return Integer.parseInt(date.substring(6,10));
   }
   
   // Determines whether a given year is a leap year or not
   public static boolean isLeapYear(int year){
      return (year%400==0 || (year%100!=0 && year%4==0));
   }
   
   // Determines the number of days in a given month
   public static int daysInMonth(int month, boolean leapYear){
      if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
         return 31;
      else if(month==4 || month==6 || month==9 || month==11)
         return 30;
      else if(month==2 && leapYear)
         return 29;
      else if(month==2 && !leapYear)
         return 28;
      else
         return -1;
   }
   
   // Determines whether a given date in mm/dd/yyyy format is a valid date
   public static boolean isValidDate(int month, int day, int year){
      return ((month>=1 && month<=12) && (day>=1 && day<=daysInMonth(month, isLeapYear(year))) && year>=0);
   }
   
   // Given a date, determines the day of the week of that date
   // Returns "ERROR" if the given date is invalid
   public static String dayOfWeek(int month, int day, int year){
      if (!isValidDate(month,day,year))
         return "ERROR";
      // Gauss' algorithm for the first day of the year
      int firstDay = (1 + 5*((year-1)%4) + 4*((year-1)%100) + 6*((year-1)%400))%7;
      int dayNumber = (firstDay + elapsedDays(month, day, year))%7-1;
      
      String dayOfWeek = "";
      switch (dayNumber){
         case 0: dayOfWeek = "Sunday"; break;
         case 1: dayOfWeek = "Monday"; break;
         case 2: dayOfWeek = "Tuesday"; break;
         case 3: dayOfWeek = "Wednesday"; break;
         case 4: dayOfWeek = "Thurday"; break;
         case 5: dayOfWeek = "Friday"; break;
         case 6: dayOfWeek = "Saturday"; break;
      }
      return dayOfWeek;
   }
   
   // Given an integer representing a month 1-12, returns the string of that month's name
   // Returns "ERROR" if the number is not in the range 1-12
   public static String getMonthName(int month){
      String monthName;
      switch (month){
         case 1:
            monthName = "January";
            break;
         case 2:
            monthName = "Febuary";
            break;
         case 3:
            monthName = "March";
            break;
         case 4:
            monthName = "April";
            break;
         case 5:
            monthName = "May"; 
            break;
         case 6:
            monthName = "June"; 
            break;
         case 7:
            monthName = "July"; 
            break;
         case 8:
            monthName = "August"; 
            break;
         case 9:
            monthName = "September"; 
            break;
         case 10:
            monthName = "October"; 
            break;
         case 11:
            monthName = "November"; 
            break;
         case 12:
            monthName = "December"; 
            break;
         default:
            monthName = "ERROR"; 
            break;
      }
      return monthName;
   }
   
   // Takes a date and determines which day of the year it is
   public static int elapsedDays(int month, int day, int year){
      if (!isValidDate(month, day, year))
         return -1;
      int x = 1;
      int elapsedDays = 0;
      while (x<month){
         elapsedDays += daysInMonth(x,isLeapYear(year));
         x++;
      }
      elapsedDays +=day;
      return elapsedDays;
   }
}
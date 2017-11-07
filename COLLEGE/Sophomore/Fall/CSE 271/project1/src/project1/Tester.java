/**
 * 
 */
package project1;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Robbie Ritchie
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		AppointmentBook testBook = new AppointmentBook();
		Scanner in = new Scanner(System.in);
		
		testBook.add(AppointmentType.ONETIME, "My birthday", new GregorianCalendar(1997, 7, 21));
		testBook.add(AppointmentType.ONETIME, "Someone elses birthday", new GregorianCalendar(1990, 8, 27));
		testBook.add(AppointmentType.MONTHLY, "The 13th", new GregorianCalendar(1500, 0, 13));
		testBook.add(AppointmentType.MONTHLY, "The 12th", new GregorianCalendar(2020, 8, 12));
		testBook.add(AppointmentType.DAILY, "Words", new GregorianCalendar(2000, 0, 1));
		testBook.add(AppointmentType.DAILY, "Blah blah blah", new GregorianCalendar(1995, 0, 1));
		
		ArrayList<Appointment> list = testBook.getAppointments();
		
		System.out.println("Enter year: ");
		int year = in.nextInt();
		System.out.println("Enter month: ");
		int month = in.nextInt();
		System.out.println("Enter day: ");
		int day = in.nextInt();
		
		System.out.println("The following appointments occur on this date:");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).occursOn(year, month, day))
				System.out.println(list.get(i));
		}
		
	}

}

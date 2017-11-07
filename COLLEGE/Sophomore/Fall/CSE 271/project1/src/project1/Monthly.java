/**
 * 
 */
package project1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Robbie
 *
 */
public class Monthly extends Appointment {
	
	/*
	 * @param day The day of the month the appointment will recur on
	 * @param year The initial year the appointment occurs
	 * @param month The initial month the appointment occurs. Goes from 0-11
	 * @param desc A string for the description of the appointment
	 * Creates a new Monthly object with the initial date it will occur from
	 */
	public Monthly(int year, int month, int day, String desc){
		super();
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		this.setDate(date);
		this.setDescription(desc);
	}
	
	/*
	 * (non-Javadoc)
	 * @see project1.Appointment#occursOn(int, int, int)
	 */
	@Override
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar when = new GregorianCalendar(year, month, day);
		return (this.getDate().before(when) && this.getDate().get(Calendar.DAY_OF_MONTH)==day);
	}
	/*
	 * (non-Javadoc)
	 * @see project1.Appointment#getType()
	 */
	@Override
	public AppointmentType getType(){
		return AppointmentType.MONTHLY;
	}
	
	@Override
	public String toString(){
		return super.toString() + " Reoccurs monthly on the " + this.getDate().get(Calendar.MONTH) + ".";
	}

}

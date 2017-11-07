/**
 * 
 */
package project1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Robbie Ritchie
 *
 */
public class Onetime extends Appointment {
	
	/*
	 * @param year Year of the appointment date
	 * @param month Month of the appointment date (0-11)
	 * @param day Day of the month of the appointment date
	 */
	public Onetime(int year, int month, int day, String desc) {
		super();
		this.setDate(new GregorianCalendar(year, month, day));
		this.setDescription(desc);
	}
	
	/*
	 * @param year The year the date occurs on
	 * @param month The month the date occurs on. Months are represented by 0-11
	 * @param day The day of the Month
	 */
	@Override
	public boolean occursOn(int year, int month, int day) {
		return (day == this.getDate().get(Calendar.DAY_OF_MONTH) &&
				this.getDate().get(Calendar.MONTH) == month && 
				this.getDate().get(Calendar.YEAR) == year);
	}
	
	/*
	 * (non-Javadoc)
	 * @see project1.Appointment#getType()
	 */
	@Override
	public AppointmentType getType(){
		return AppointmentType.ONETIME;
	}
	
	@Override
	public String toString(){
		return super.toString() + " Doesn't reoccur.";
	}
}

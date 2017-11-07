/**
 * 
 */
package project1;

import java.util.GregorianCalendar;

/**
 * @author Robbie Ritchie
 *
 */
public class Daily extends Appointment {
	
	/*
	 * @param year The initial year of the appointment
	 * @param month THe initial month of the appointment
	 * @param day The initial day of the month of the appointment
	 * @param desc Description of the appointment
	 */
	public Daily(int year, int month, int day, String desc){
		super();
		this.setDate(new GregorianCalendar(year, month, day));
		this.setDescription(desc);
	}
	
	/*
	 * @param year The year the date occurs on
	 * @param month The year the month occurs on. Months are represented by 0-11
	 * @param day The day of the Month
	 */
	@Override
	public boolean occursOn(int year, int month, int day) {
		GregorianCalendar when = new GregorianCalendar(year, month, day);
		return (this.getDate().before(when) || this.getDate().equals(when));
	}
	
	/*
	 * (non-Javadoc)
	 * @see project1.Appointment#getType()
	 */
	@Override
	public AppointmentType getType(){
		return AppointmentType.DAILY;
	}
	
	@Override
	public String toString(){
		return super.toString() + " Reoccurs daily.";
	}

}

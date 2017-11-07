package project1;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Robbie Ritchie

public abstract class Appointment {
	private String description;
	private GregorianCalendar date;
	
	/*
	 * @param year The year the date occurs on
	 * @param month The year the month occurs on. Months are represented by 0-11
	 * @param day The day of the Month
	 */
	public abstract boolean occursOn(int year, int month, int day);

	/*
	 * returns the description String
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * sets the description String
	 * @param description The new string that will replace the old description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	 * returns the GregorianCalendar representing the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	
	/*
	 * Sets the date to a new GregorianCalendar object
	 * @param date the GregorianCalendar object that will replace the old date
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	/*
	 * Returns the Type of the appointment
	 * Will return AppointmentType.DAILY, AppointmentType.MONTHLY, or
	 * AppointmentType.ONETIME depending on the object type
	 */
	public abstract AppointmentType getType();
	/*
	 * Returns a string representation of relevant info of an appointment
	 * All subclasses override this method
	 * mm/dd/yyyy format
	 */
	@Override
	public String toString(){
		return "Initial date: " + (date.get(Calendar.MONTH)+1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.YEAR) +
				" Description: " + this.description + "-";
	}
}

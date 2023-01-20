package model.entities;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// método estático para que não seja instanciado outro formato de data na Classe Reservation
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) { //O .after é uma função do Java que calcula se a data "In" é depois da "Out"
			throw new DomainException("Check-out date must be after check-in date.");
		}	
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // calcula a diferença entre as data por milésimos de seg.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}   // função do java que converte o "diff" de MILISECONDS para DAYS.
	
	public void updateDates (Date checkIn, Date checkOut) {
		Date now = new Date(); // Instanciar data do sistema
		
		if (checkIn.before(now) || checkOut.before(now)) { // se a data de In ou Out foram antes de agora
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkOut.after(checkIn)) { //O .after é uma função do Java que calcula se a data "In" é depois da "Out"
			throw new DomainException("Check-out date must be after check-in date.");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+ " nigths.";				
	}
	
}

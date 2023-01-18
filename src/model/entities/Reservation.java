package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// m�todo est�tico para que n�o seja instanciado outro formato de data na Classe Reservation
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
		long diff = checkOut.getTime() - checkIn.getTime(); // calcula a diferen�a entre as data por mil�simos de seg.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}   // fun��o do java que converte o "diff" de MILISECONDS para DAYS.
	
	public String updateDates (Date checkIn, Date checkOut) {
		Date now = new Date(); // Instanciar data do sistema
		
		if (checkIn.before(now) || checkOut.before(now)) { // se a data de In ou Out foram antes de agora
			return " Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) { //O .after � uma fun��o do Java que calcula se a data "In" � depois da "Out"
			return " Check-out date must be after check-in date";
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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

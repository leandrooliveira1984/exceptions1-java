package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// o throws ParseException demostra que se o programador n�o tratar a exce��o, o proprio java tratar�
		// por meio dela. Ent�o para n�o usar o throws o programador deve tratar a exce��o (try-catch).
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) { //O .after � uma fun��o do Java que calcula se a data "out" � depois da "in"
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date(); // Instanciar data do sistema
			if (checkIn.before(now) || checkOut.before(now)) { // se a data de In ou Out foram antes de agora
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) { //O .after � uma fun��o do Java que calcula se a data "out" � depois da "in"
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {			
			reservation.updateDates(checkIn, checkOut);			
			System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}

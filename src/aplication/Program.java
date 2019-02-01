package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Entities.Reservation;
import model.Exception.DomainException;

public class Program {

	public static void main(String[] args)  {
			Scanner sc = new Scanner(System.in);
			try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/mm/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Check -out date (dd/mm/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.println("Check-in date (dd/mm/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy)");
			checkout = sdf.parse(sc.next());
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}

/**
 * 
 * @author Sebastian Guerrero <sguerrer>
 * @section A
 * @date 9/9/15
 * 
 * 
 */

// You may not import any additional classes or packages.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightManager {
	
	public ArrayList<Flight> flights = new ArrayList<Flight>();
	
	// Use this method to test your code. Completely remove the main method
	// when you're done.
	public static void main(String[] args) {
		FlightManager fm = new FlightManager();
	}
	
	// Do not change this method.
	public FlightManager() {
		loadFlights();
	}
	
	/**
	 * Loads the flight data using the given specification. You must use the
     * specification provided in the write-up in order to receive full credit.
	 */
	private void loadFlights() {
		String filename = "flights.txt";
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				// Look up the String.split method in the Java API to
				// understand how it works!
				String[] splitLine = line.split("[|]");
				
				// Write your code here for loadFlights
				Integer distance = Integer.valueOf(splitLine[5]);
				Flight data = new Flight(splitLine[0], splitLine[1], splitLine[2],
										 splitLine[3], splitLine[4],distance);
				flights.add(data);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("I could not load the file. Please make sure " +
			                   "the file is in the correct directory.");
			System.exit(0);
		} catch(Exception e) {
			System.out.println("Error while creating the flights:");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Returns the flights ArrayList.
	 * @return ArrayList<Flight>
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/**
	 * Finds and returns all Flights that depart from the given ICAO airport
     * code. This method must run in O(n) time. For example (your data may be
     * different):
	 *   Flights f = new Flights();
	 *   f.getFlightsDepartingFrom("PIT");
	 *   // could return [DL8273, WN2834, WN5243]
	 * @param airport - the ICAO airport code to search for
	 * @return - an ArrayList of Flight objects that depart from the given
	 * ICAO code
	 */
	public ArrayList<Flight> getFlightsDepartingFrom(String airport) {
		ArrayList<Flight> flightsDeparting = new ArrayList<Flight>(); 
		for (Flight f : flights) {
			if (f.getDepartureAirport().equals(airport)) {
				flightsDeparting.add(f);
			}
		}
		return flightsDeparting; 
	}
	
	
	
	/**
	 * Finds and returns an ArrayList<Flight> representing all direct Flights
     * starting in startAirport and ending at endAirport, grouped by their
     * unique identifier. For example:
	 *   Flights f = new Flights();
	 *   f.getFlightsAlongPath("PIT", "LAS"); // could return [WN2834, WN5243]
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an ArrayList<Flight> that are non-stop
	 */
	public ArrayList<Flight> getNonStopFlights(String departureAirport,
	        String arrivalAirport) {
		ArrayList<Flight> nonStopFlights = new ArrayList<Flight>(); 
		ArrayList<Flight> flightsDeparting = getFlightsDepartingFrom(departureAirport);
		for (Flight f : flightsDeparting) {
			if (f.getArrivalAirport().equals(arrivalAirport)) {
				nonStopFlights.add(f);
			}
		}
		return nonStopFlights;
	}
		
	/**
	 * Cancels all flights that stop in the given airport. You must deepCopy
     * the global flights ArrayList and then remove any flights that ever exist
     * in at a given airport.
	 * @param airport - the airport that has canceled all flights
	 * @return - an ArrayList<Flight> that are still able to fly
	 */
	public ArrayList<Flight> cancelFlights(String airport) {
		ArrayList<Flight> updatedFlights = deepCopy(flights);
		for (int i = updatedFlights.size() - 1; i > -1; i --) {
			if (updatedFlights.get(i).getArrivalAirport().equals(airport) || 
				updatedFlights.get(i).getDepartureAirport().equals(airport)) {
				updatedFlights.remove(i);
			}
		}
		return updatedFlights;
	}

    // Extra credit method. If you don't want to implement this method,
	// just leave it as is.
    public ArrayList<Flight> cancelFlightsCorrectly(String airport) {
		return null; // remove this line when you're done
	}
	
	/**
	 * Calculates the total distance traveled for all given flightIdentifiers
	 * @param flightIdentifiers - an ArrayList<String> representing the
     *      flightIdentifiers to search for
	 * @return - the total distance (in miles) traveled
	 */
	public int getTotalDistance(ArrayList<String> flightIdentifiers) {
		int totalDistance = 0;
		for (Flight f : flights) {
			if (flightIdentifiers.contains(f.getIdentifier())) {
				totalDistance += f.getDistance();
			}
		}
		
		return totalDistance;
	}
	
	/**
	 * Arranges the flights in an ArrayList<ArrayList<Flight>>. Each
     * ArrayList<ArrayList> represents a unique flight path. Each
     * ArrayList<ArrayList<Flight>> represents a collection of the flight path,
	 * in the same order as the input file.
	 */
	public ArrayList<ArrayList<Flight>> arrangedFlights() {
		ArrayList<ArrayList<Flight>> theFlights = new ArrayList<ArrayList<Flight>>();
		ArrayList<Flight> newFlights = new ArrayList<Flight>();
//		newFlights.add(flights.get(0));
//		theFlights.add(newFlights);

		for (Flight f : flights){
			if (theFlights.size() == 0){
				newFlights.add(f);
				theFlights.add(newFlights);
				newFlights = new ArrayList<Flight>();
			}
			else {
				if (newFlights.size() > 0) {
					theFlights.add(newFlights);
					newFlights = new ArrayList<Flight>();
				}
				for (ArrayList<Flight> a : theFlights) {
					newFlights = new ArrayList<Flight>();

					if (a.get(0).getIdentifier().equals(f.getIdentifier())) {
						a.add(f);
						break;
					}
					else {
						newFlights = new ArrayList<Flight>();
						newFlights.add(f);
					}
					}
			}
			}
		if (newFlights.size() > 0 ) {
			theFlights.add(newFlights);
		}
		return theFlights;
	}
	
	/**
	 * Returns an ArrayList<ArrayList<Flight>> corresponding to all flights that start at
     * departureAirport and end at arrivalArrival airport and have at least 1
     * stop in between. 
	 * 
	 * HINT: You may find it helpful to use the arrangedFlights() method.
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an organized list of all multi-hop flights
	 */
	public ArrayList<ArrayList<Flight>> getMultiHopFlights(String departureAirport,
	        String arrivalAirport) {
		ArrayList<Flight> newFlights = new ArrayList<Flight>();
		ArrayList<ArrayList<Flight>> theFlights = arrangedFlights();
		ArrayList<ArrayList<Flight>> hopFlights = new ArrayList<ArrayList<Flight>>();
		for (ArrayList<Flight> a : theFlights) {
			newFlights = new ArrayList<Flight>();
			theFlights = arrangedFlights();
			for (Flight l : a) {
					if (newFlights.size() >= 0 && l.getDepartureAirport().equals(departureAirport)) {
						newFlights.add(l);
					} 
					else if (newFlights.size() > 0 && l.getArrivalAirport().equals(arrivalAirport)) {
						newFlights.add(l);
						hopFlights.add(deepCopy(newFlights));
					}
					else if (newFlights.size() > 0 && !(l.getArrivalAirport().equals(arrivalAirport))) {
						newFlights.add(l);
					}
				}
		}
		return hopFlights;
	}

	/**
	 * Returns an ArrayList<Flight> of all the flights that depart from the
	 * given airport in the AM (i.e. between 0000 and 1159, midnight and
	 * noon). This method must run in O(n) time.
	 *
	 * @param departureAirport - the ICAO code of the departure airport
	 * @return - a list of all the departing AM flights from the airport
	 */
	public ArrayList<Flight> morningDepartingFlights(String departureAirport) {
		ArrayList<Flight> morningFlights = new ArrayList<Flight>(); 
		for (Flight f : flights) {
			int time = Integer.parseInt(f.getDepartureTime());
			if (time >= 0 && time <= 1159 && f.getDepartureAirport().equals(departureAirport)) {
				morningFlights.add(f);
			}
		}
		return morningFlights; 
	}
	
  
	
	/**
	 * Returns an ArrayList<Flight> of Flight(s) that go from the specified
	 * departure airport to the specified arrival airport in the fewest number
	 * of miles. The shortest flight path can be nonstop or multi-hop. If there
	 * is no flight path that goes between the two specified airports, return
	 * an empty List.
	 
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - a list of the Flights in the shortest flight path, in order
	 */
	public ArrayList<Flight> shortestFlight(String departureAirport,
	        String arrivalAirport) {
		ArrayList<Flight> nonStopFlights = getNonStopFlights(departureAirport, arrivalAirport); 
		ArrayList<ArrayList<Flight>> hopFlights = getMultiHopFlights(departureAirport, arrivalAirport);
		int minDistance = 100000000;
		ArrayList<Flight>  minFlight = new ArrayList<Flight>();
		for (Flight f : nonStopFlights) {
			int distance = f.getDistance();
			if (distance < minDistance ) {
				minDistance = distance;
				minFlight.clear();
				minFlight.add(f);
			}
		}
		for (ArrayList<Flight> a : hopFlights) {
			int distance = 0;
			for (Flight l : a) {
				distance += l.getDistance();
			}
			if (distance < minDistance ) {
				minDistance = distance;
				minFlight.clear();
				minFlight = a; 
			}
			
		}
		
		
	    return minFlight; // remove this line when you're done
	}
	
	/**
	 * deepCopies an ArrayList<Flight>
	 * @param theFlights
	 * @return - a new ArrayList<Flight> containing the same Flights in the
     *      same order as the given ArrayList<Flight>
	 */
	private ArrayList<Flight> deepCopy(ArrayList<Flight> theFlights) {
		ArrayList<Flight> newCopy = new ArrayList<Flight>();
		for (Flight f : theFlights) {
			Flight flightObject = new Flight(f.getIdentifier(), f.getDepartureAirport(),
											f.getDepartureTime(),f.getArrivalAirport(),
											f.getArrivalTime(),f.getDistance());
			newCopy.add(flightObject);
		}
		return newCopy;
	}

}


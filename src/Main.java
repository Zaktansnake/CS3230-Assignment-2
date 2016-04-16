import java.util.*;

public class Main {

	public static void main(String[] args) {
		//data types to store input
		int numOfVillages, numOfPoliceStations, villagePosition, counter = 0;
		ArrayList<Integer> positionOfVillages = new ArrayList<Integer>();
		
		Scanner scan = new Scanner(System.in);
		
		numOfVillages = scan.nextInt();
		numOfPoliceStations = scan.nextInt();
		
		if(numOfVillages > 300) {
			System.err.println("Error! Number of Villages is above 300!");
			System.exit(0);
		} else if(numOfPoliceStations > 30) {
			System.err.println("Error! Number of Police Stations is above 30!");
			System.exit(0);
		} else if (numOfPoliceStations >= numOfVillages) {
			System.err.println("Error! Number of Police Stations exceed number of Villages!");
			System.exit(0);
		}
		
		while(scan.hasNext()) {
			counter++;
			villagePosition = scan.nextInt();
			if(villagePosition > 10000) {
				System.err.println("Error! Village Position is above 10,000!");
				System.exit(0);
			} else {
				positionOfVillages.add(villagePosition);
			}
		}
		
		int answer = calculateMinimum(numOfVillages, numOfPoliceStations, counter, positionOfVillages);
		
		System.out.println(answer);
		scan.close();
	}
	
	public static int calculateMinimum(int nov, int nops, int c, ArrayList<Integer> pov) {
		return 9;
	}
}

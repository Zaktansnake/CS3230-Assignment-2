import java.util.*;

public class Main {

	public static void main(String[] args) {
		//data types to store input
		int numOfVillages, numOfPoliceStations, villagePosition;
		ArrayList<Integer> positionOfVillages = new ArrayList<Integer>();
		
		Scanner scan = new Scanner(System.in);
		
		numOfVillages = scan.nextInt();
		numOfPoliceStations = scan.nextInt();
		
		while(scan.hasNext()) {
			villagePosition = scan.nextInt();
			positionOfVillages.add(villagePosition);
		}
		
		int answer = calculateMinimum(numOfVillages, numOfPoliceStations, positionOfVillages);
		
		System.out.print(answer);
		scan.close();
	}
	
	public static int calculateMinimum(int nov, int nops, ArrayList<Integer> pov) {
		return 9;
	}
}

import java.util.*;

public class Main {

	public static void main(String[] args) {
		//data types to store input
		int answer, numOfVillages, numOfPoliceStations, villagePosition;
		
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
			System.out.println(0);
			System.exit(0);
		}
		
		int[] villagePositions = new int[numOfVillages];
		
		for(int i = 0; i < numOfVillages; i++) {
			villagePosition = scan.nextInt();
			if(villagePosition > 10000) {
				System.err.println("Error! Village Position is above 10,000!");
				System.exit(0);
			} else {
				villagePositions[i] = villagePosition;
			}
		}
		
		answer = calculateMinimum(numOfVillages, numOfPoliceStations, villagePositions);
		
		System.out.println(answer);
		scan.close();
	}
	
	public static int calculateMinimum(int numOfVillages, int numOfPoliceStations, int[] villagePositions) {
		int[][]allDistances = new int[numOfVillages][numOfPoliceStations];
		int[][]villageDistances = new int[numOfVillages][numOfVillages];
		
		calculateDistance(villageDistances, villagePositions);
		
		for (int i = 0; i < numOfVillages; ++i) {
			Arrays.fill(allDistances[i], Integer.MAX_VALUE / 2);
		}
		for (int i = 0; i < numOfVillages; ++i) {
			allDistances[i][0] = villageDistances[0][i];
		}
		for (int k = 1; k < numOfPoliceStations; ++k) {
			for (int i = 0; i < numOfPoliceStations; ++i) {
				for (int j = 0; j < i; ++j) {
					if (allDistances[j][k - 1] + villageDistances[j + 1][i] < allDistances[i][k]) {
						allDistances[i][k] = allDistances[j][k - 1] + villageDistances[j + 1][i];
					}
				}
			}
		}
		return allDistances[numOfVillages - 1][numOfPoliceStations - 1];
	}
	
	public static void calculateDistance(int[][] villageDistances, int[] villagePositions) {
		for (int i = 0; i < villageDistances.length - 1; ++i) {
			for (int j = i + 1; j < villageDistances.length; ++j) {
				int mid = (i + j) / 2;
				for (int k = i; k < mid; ++k) {
					villageDistances[i][j] += villagePositions[mid] - villagePositions[k];
				}
				for (int k = mid + 1; k <= j; ++k) {
					villageDistances[i][j] += villagePositions[k] - villagePositions[mid];
				}
			}
		}
	}
}

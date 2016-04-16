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
		int[][]villageDistances = calculateDistance(villagePositions, numOfVillages);
		int[][]allDistances = new int[numOfVillages + 1][numOfPoliceStations + 1];
		
		for(int i = 0; i <= numOfVillages; i++) {
			allDistances[i][1] = villageDistances[1][i];
		}
		
		for(int j = 2; j <= numOfPoliceStations; j++) {
			for(int k = j; k <= numOfVillages; k++) {
				allDistances[k][j] = Integer.MAX_VALUE;
				for(int l = 0; l < k; l++) {
					if(allDistances[k][j] == Integer.MAX_VALUE || allDistances[k][j] > allDistances[l][j-1] + villageDistances[l+1][k]) {
						allDistances[k][j] = allDistances[l][j-1] + villageDistances[l+1][k];
					}
				}
			}
		}
		
		return allDistances[numOfVillages][numOfPoliceStations];
	}
	
	static int[][] calculateDistance(int[] villagePositions, int numOfVillages) {
		int[][] villageDistances = new int[numOfVillages+1][numOfVillages+1];
		for(int i = 1; i <= numOfVillages; i++) {
			for(int j = i+1; j <= numOfVillages; j++) {
				int mid = (i+j)/2;
				for(int k = i; k <= j; k++) {
					villageDistances[i][j] += Math.abs(villagePositions[k-1] - villagePositions[mid - 1]);
				}
			}
		}
		return villageDistances;
	}
}

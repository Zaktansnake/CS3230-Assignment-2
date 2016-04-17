//Name: David Chong Yong Ming
//Matric No: A0116633L
//CS3230 Assignment 2 - Police Office Allocation

import java.util.*;

//Time Complexity: O(p*v^2)
//Space Complexity: O(v)

public class Main {

	public static void main(String[] args) {
		//For storing STDIN input
		int answer, numOfVillages, numOfPoliceStations, villagePosition;
		
		Scanner scan = new Scanner(System.in);
		
		//scans in the first line containing the number of villages and police stations
		numOfVillages = scan.nextInt();
		numOfPoliceStations = scan.nextInt();
		
		//checks if the input is valid according to assignment requirements
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
		
		//initializes an array to store the position of each village
		int[] villagePositions = new int[numOfVillages];
		
		//for loop used to store the village positions in a array
		for(int i = 0; i < numOfVillages; i++) {
			villagePosition = scan.nextInt();
			//checks that the village position input fits the assignment requirements
			if(villagePosition > 10000) {
				System.err.println("Error! Village Position is above 10,000!");
				System.exit(0);
			} else {
				villagePositions[i] = villagePosition;
			}
		}
		
		answer = calculateMinimum(numOfVillages, numOfPoliceStations, villagePositions);
		
		//prints out answers to STDOUT
		System.out.println(answer);
		scan.close();
	}
	
	public static int calculateMinimum(int numOfVillages, int numOfPoliceStations, int[] villagePositions) {
		//initializes two two-dimensional arrays to find the least possible sum 
		int[][]villageDistances = calculateDistance(villagePositions, numOfVillages);
		int[][]allDistances = new int[numOfVillages+1][numOfPoliceStations+1];
		
		//stores the second row of villageDistances in the second column of allDistances
		for(int i = 0; i <= numOfVillages; i++) {
			allDistances[i][1] = villageDistances[1][i];
		}
		
		//inserts a maximum value to store the calculated least possible sum
		for(int j = 2; j <= numOfPoliceStations; j++) {
			for(int k = j; k <= numOfVillages; k++) {
				allDistances[k][j] = Integer.MAX_VALUE;
				for(int l = 0; l < k; l++) {
					//checks if the current location has a max value or is greater than the previously calculated least possible sum
					if(allDistances[k][j] == Integer.MAX_VALUE || allDistances[k][j] > allDistances[l][j-1] + villageDistances[l+1][k]) {
						//changes the distance to the combined value of the previous least possible sum and the distance to the village
						allDistances[k][j] = allDistances[l][j-1] + villageDistances[l+1][k];
					}
				}
			}
		}
		
		//allDistances[numOfVillages][numOfPoliceStations] denotes the least possible sum of police office allocation for the villages
		return allDistances[numOfVillages][numOfPoliceStations];
	}
	
	static int[][] calculateDistance(int[] villagePositions, int numOfVillages) {
		int[][] villageDistances = new int[numOfVillages+1][numOfVillages+1];
		
		//calculates the total distances between each village and stores it horizontally in the two-dimensional array similar to permutations
		for(int i = 1; i <= numOfVillages; i++) {
			for(int j = i+1; j <= numOfVillages; j++) {
				int mid = (i+j)/2;
				for(int k = i; k <= j; k++) {
					villageDistances[i][j] += Math.abs(villagePositions[k-1] - villagePositions[mid-1]);
				}
			}
		}
		return villageDistances;
	}
}

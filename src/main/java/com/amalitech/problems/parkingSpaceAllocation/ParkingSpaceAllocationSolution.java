package com.amalitech.problems.parkingSpaceAllocation;

import java.util.*;

public class ParkingSpaceAllocationSolution {

    record Vehicle(String id, int length) {}
    record Space(String id, int length) {}
    record Assignment(String vehicleId, String spaceId) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;

        while (true) {
            System.out.print("Enter number of spaces: ");
            int n = scanner.nextInt(); // Number of spaces
            System.out.print("Enter number of vehicles: ");
            int m = scanner.nextInt(); // Number of vehicles

            if (n == 0 && m == 0) {
                break;
            }

            List<Space> spaces = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int index = i + 1;
                System.out.printf("Enter space %d: (name, length): ", index);
                spaces.add(new Space(scanner.next(), scanner.nextInt()));
            }

            List<Vehicle> vehicles = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int index = i + 1;
                System.out.printf("Enter vehicle %d (name, length): ", index);
                vehicles.add(new Vehicle(scanner.next(), scanner.nextInt()));
            }

            solveCase(caseNumber++, n, m, spaces, vehicles);
        }
        scanner.close();
    }

    private static void solveCase(int caseNumber, int n, int m, List<Space> spaces, List<Vehicle> vehicles) {
        vehicles.sort(Comparator.comparingInt(v -> v.length));

        List<Assignment> assignments = new ArrayList<>();
        long totalWastedSpace = 0;
        boolean[] spaceUsed = new boolean[spaces.size()];

        List<Space> sortedSpaces = new ArrayList<>(spaces);
        sortedSpaces.sort(Comparator.comparingInt(s -> s.length));

        Map<String, Integer> originalIndices = new HashMap<>();
        for(int i=0; i<spaces.size(); i++){
            originalIndices.put(spaces.get(i).id, i);
        }


        for (Vehicle vehicle : vehicles) {
            int bestSpaceIndex = -1;
            int minWaste = Integer.MAX_VALUE;
            String bestFitSpaceId = null;

            for (int j = 0; j < sortedSpaces.size(); j++) {
                Space currentSpace = sortedSpaces.get(j);
                int originalIndex = originalIndices.get(currentSpace.id);
                if (!spaceUsed[originalIndex] && currentSpace.length >= vehicle.length) {
                    int waste = currentSpace.length - vehicle.length;
                    if (waste < minWaste) {
                        minWaste = waste;
                        bestSpaceIndex = originalIndex;
                        bestFitSpaceId = currentSpace.id;
                    }
                }
            }

            if (bestSpaceIndex != -1) {
                spaceUsed[bestSpaceIndex] = true;
                assignments.add(new Assignment(vehicle.id, bestFitSpaceId));
                totalWastedSpace += minWaste;
            }
        }

        assignments.sort(Comparator.comparing(a -> a.vehicleId));

        System.out.printf("Case %d: %d vehicles parked%n", caseNumber, assignments.size());
        System.out.printf("Total wasted space: %d feet%n", totalWastedSpace);

        System.out.print("Assignments: ");
        if (assignments.isEmpty()) {
            System.out.println("none");
        } else {
            for (int i = 0; i < assignments.size(); i++) {
                System.out.print(assignments.get(i).vehicleId + "->" + assignments.get(i).spaceId);
                if (i < assignments.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

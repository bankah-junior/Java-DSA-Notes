package com.amalitech.problems.parkingSpaceAllocation;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    public static void BubbleSort(String[] key, int[] values) {
        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    // Swap keys
                    String tempKey = key[j];
                    key[j] = key[j + 1];
                    key[j + 1] = tempKey;
                    // Swap values
                    int tempValue = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tempValue;
                }
            }
        }
    }
    public static void Solution(int caseNumber, int n, int m, String[] spaceKeys, int[] spaceValues, String[] vehicleKeys, int[] vehicleValues) {
        BubbleSort(spaceKeys, spaceValues);
        BubbleSort(vehicleKeys, vehicleValues);
        List<Integer> allocatedSpaces = new ArrayList<>();
        List<Integer> allocatedVehicles = new ArrayList<>();
        int vehiclesParked = 0;
        int wastedSpace = 0;
        for (int i = 0; i < n; i++) {
            if (allocatedVehicles.contains(i)) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (allocatedVehicles.contains(j)) {
                    continue;
                }
                if (vehicleValues[j] <= spaceValues[i]) {
                    allocatedSpaces.add(i);
                    allocatedVehicles.add(j);
                    vehiclesParked++;
                    wastedSpace += spaceValues[i] - vehicleValues[j];
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("Case " + caseNumber + ": " + vehiclesParked + " vehicles parked");
        System.out.println("Total wasted space: " + wastedSpace + " feet");
        System.out.print("Assignments: ");
        for (int i = 0; i < allocatedSpaces.size(); i++) {
            System.out.print(vehicleKeys[allocatedVehicles.get(i)] + "->" + spaceKeys[allocatedSpaces.get(i)] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Case 1
        int n01 = 5;
        int m01 = 5;
        String[] spaceKeys01 = {"A1", "A2", "A3", "B1", "B2"};
        int[] spaceValues01 = {20, 25, 18, 30, 22};
        String[] vehicleKeys01 = {"CAR1", "CAR2", "SUV1", "TRUCK", "VAN"};
        int[] vehicleValues01 = {18, 24, 16, 28, 21};
        Solution(1, n01, m01, spaceKeys01, spaceValues01, vehicleKeys01, vehicleValues01);

        // case 2
        int n02 = 3;
        int m02 = 4;
        String[] spaceKeys02 = {"P1", "P2", "P3"};
        int[] spaceValues02 = {15, 20, 25};
        String[] vehicleKeys02 = {"V1", "V2", "V3", "V4"};
        int[] vehicleValues02 = {22, 18, 14, 12};
        Solution(2, n02, m02, spaceKeys02, spaceValues02, vehicleKeys02, vehicleValues02);

        // case 3
        int n03 = 2;
        int m03 = 2;
        String[] spaceKeys03 = {"SPOT1", "SPOT2"};
        int[] spaceValues03 = {30, 40};
        String[] vehicleKeys03 = {"BIG", "SMALL"};
        int[] vehicleValues03 = {45, 25};
        Solution(3, n03, m03, spaceKeys03, spaceValues03, vehicleKeys03, vehicleValues03);

        // case 4
        int n04 = 0;
        int m04 = 0;
        String[] spaceKeys04 = {};
        int[] spaceValues04 = {};
        String[] vehicleKeys04 = {};
        int[] vehicleValues04 = {};
        Solution(4, n04, m04, spaceKeys04, spaceValues04, vehicleKeys04, vehicleValues04);
    }
}

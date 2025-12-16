package com.amalitech.search.megaCorp.service;

import com.amalitech.search.megaCorp.model.Department;
import com.amalitech.search.megaCorp.util.BinarySearch;
import com.amalitech.search.megaCorp.util.LinearSearch;

public class FindEmployee {

    private static final LinearSearch linearSearchUtil = new LinearSearch();
    private static final BinarySearch binarySearchUtil = new BinarySearch();

    /**
     * Recursively searches for an employee ID in the department hierarchy.
     *
     * @param dept     The department to search within.
     * @param targetId The employee ID to search for.
     * @return true if the employee ID is found, false otherwise.
     */
    public static boolean findEmployee(Department dept, int targetId) {
        if (dept == null) return false;

        if (linearSearchUtil.linearSearch(dept.getInterns(), targetId)) return true;

        if (binarySearchUtil.binarySearch(dept.getManagers(), targetId)) return true;

        if (dept.getSubDepartments() != null)
            for (Department sub : dept.getSubDepartments())
                if (findEmployee(sub, targetId)) return true;

        return false;
    }
}

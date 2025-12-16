package com.amalitech.search.megaCorp;

import com.amalitech.search.megaCorp.model.Department;

import java.util.Arrays;
import java.util.List;

import static com.amalitech.search.megaCorp.service.FindEmployee.findEmployee;

public class MegaCorpSearch {
    public static void main(String[] args) {
        Department techSupport = new Department(
                "Tech Support",
                List.of(88),
                Arrays.asList(850, 900),
                List.of()
        );

        Department tech = new Department(
                "Tech",
                List.of(99),
                Arrays.asList(700, 750, 800),
                List.of(techSupport)
        );

        Department marketing = new Department(
                "Marketing",
                Arrays.asList(55, 12),
                Arrays.asList(601, 602, 603),
                List.of()
        );

        Department headOffice = new Department(
                "Head Office",
                Arrays.asList(902, 14, 7),
                Arrays.asList(100, 200, 300, 400, 500),
                Arrays.asList(marketing, tech)
        );

        System.out.println(findEmployee(headOffice, 88));
        System.out.println(findEmployee(headOffice, 101));
    }
}


package com.amalitech.problems.licensePlateValidator;

public class LicensePlateValidatorSolution {
    public static String LicensePlateChecker(String licensePlate) {
        String replaceHyphen = licensePlate.replaceAll("-", "");
        String replaceSpace = replaceHyphen.replaceAll(" ", "");
        String cleanedLicensePlate = replaceSpace.replaceAll("_", "");
        if (cleanedLicensePlate.length() > 5) {
            if (cleanedLicensePlate.length() == 6){
                String firstThreeAfterRegionCode = cleanedLicensePlate.substring(0, 3);
                String secondThreeAfterRegionCode = cleanedLicensePlate.substring(3, 6);
                // Validate all six characters
                if (!cleanedLicensePlate.matches("[A-Z0-9]{6}")) {
                    return "Invalid";
                }
                return firstThreeAfterRegionCode + "-" + secondThreeAfterRegionCode;
            }
            if (cleanedLicensePlate.length() == 8){
                String regionCode = cleanedLicensePlate.substring(0, 2);
                String lastSix = cleanedLicensePlate.substring(2, 8);
                String firstThreeAfterRegionCode = cleanedLicensePlate.substring(2, 5);
                String secondThreeAfterRegionCode = cleanedLicensePlate.substring(5, 8);
                // Validate region code
                if (!regionCode.matches("[A-Z]{2}")) {
                    return "Invalid";
                }
                // Validate last six characters
                if (!lastSix.matches("[A-Z0-9]{6}")) {
                    return "Invalid";
                }
                return regionCode + "-" + firstThreeAfterRegionCode + "-" + secondThreeAfterRegionCode;
            }
        }

        return "Invalid";
    }
    public static void main(String[] args) {
        String licensePlate01 = "CA-ABC-123";
        String licensePlate02 = "XYZ789";
        String licensePlate03 = "12-AB34CD";
        String licensePlate04 = "GH_1A2B3C";
        String licensePlate05 = "AB-12.34.56";
        String licensePlate06 = "TX ABC1";
        System.out.println(LicensePlateChecker(licensePlate01));
        System.out.println(LicensePlateChecker(licensePlate02));
        System.out.println(LicensePlateChecker(licensePlate03));
        System.out.println(LicensePlateChecker(licensePlate04));
        System.out.println(LicensePlateChecker(licensePlate05));
        System.out.println(LicensePlateChecker(licensePlate06));
    }
}

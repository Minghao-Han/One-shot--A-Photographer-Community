package com.ShengQin.OneShot.Utils;

public enum Gender {
    Male,Female, Unknown, Walmart;

    public static String toString(Gender gender) {
        switch (gender){
            case Male -> {
                return "Male";
            }
            case Female -> {
                return "Female";
            }
            case Unknown -> {
                return "Unknown";
            }
            case Walmart -> {
                return "Walmart";
            }
            default -> {
                return "wtf";
            }
        }
    }

    public static Gender getGender(String genderStr){
        switch (genderStr){
            case "Male":return Male;
            case "Female":return Female;
            case "Walmart":return Walmart;
            default:return Unknown;
        }
    }
}

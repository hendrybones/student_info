package com.pluralsight.calcengine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    String regNo;
    Gender gender;
    Date dateOfBirth;
    Date dateOfAdmission;

    public Student(String regNo, Gender gender, Date dateOfBirth, Date dateOfAdmission) {
        this.regNo = regNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return  "" + regNo +
                "," + gender +
                "," +new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) +
                "," + new SimpleDateFormat("dd-MM-yyyy").format(dateOfAdmission);
    }

}

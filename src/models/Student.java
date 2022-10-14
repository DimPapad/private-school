/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author mhtso
 */
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private float tuitionFees;
    private ArrayList<Course> studentsCourseList=new ArrayList();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public ArrayList<Course> getStudentsCourseList() {
        return studentsCourseList;
    }

    public void setStudentsCourseList(ArrayList<Course> studentsCourseList, int i) {
        this.studentsCourseList.add(studentsCourseList.get(i));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", tuitionFees=").append(tuitionFees);
        sb.append(", studentsCourseList=").append(studentsCourseList);
        sb.append('}');
        return sb.toString();
    }

    

    

}

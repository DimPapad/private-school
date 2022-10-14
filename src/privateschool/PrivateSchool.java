/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.awt.AWTEventMulticaster;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

/**
 *
 * @author mhtso
 */
public class PrivateSchool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Course> courseList = new ArrayList();
        ArrayList<Trainer> trainerList = new ArrayList();
        ArrayList<Student> studentList = new ArrayList();
        ArrayList<Assignment> assignmentList = new ArrayList();
        int iCourse = -1;
        int iTrainer = -1;
        int iStudent = -1;
        int iAssignment = -1;
        Scanner input = new Scanner(System.in);

        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
    }

    static void output(ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Student> studentList, ArrayList<Assignment> assignmentList, int iCourse, int iTrainer, int iStudent, int iAssignment, Scanner input) {
        System.out.println("");
        System.out.println("Πληκτρολόγησε τον αριθμό της εκτύπωσης που θέλεις από τις παρακάτω");
        System.out.println("1. A list of all the students");
        System.out.println("2. A list of all the trainers");
        System.out.println("3. A list of all the assignments");
        System.out.println("4. A list of all the courses");
        System.out.println("5. All the students per course");
        System.out.println("6. All the trainers per course");
        System.out.println("7. All the assignments per course");
        System.out.println("8. All the assignments per student");
        System.out.println("9. A list of students that belong to more than one courses");
        int myInput;
        do {
            myInput = input.nextInt();
            if (myInput == 1) {
                System.out.println("");
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println(studentList.get(i));
                }
            } else if (myInput == 2) {
                System.out.println("");
                for (int i = 0; i < trainerList.size(); i++) {
                    System.out.println(trainerList.get(i));
                }
            } else if (myInput == 3) {
                System.out.println("");
                for (int i = 0; i < assignmentList.size(); i++) {
                    System.out.println(assignmentList.get(i));
                }
            } else if (myInput == 4) {
                System.out.println("");
                for (int i = 0; i < courseList.size(); i++) {
                    System.out.println(courseList.get(i));
                }
            } else if (myInput == 5) {
                ArrayList<Student> studentListPerCourse = new ArrayList();
                for (int i = 0; i < courseList.size(); i++) {
                    int u = 0;
                    for (int j = 0; j < studentList.size(); j++) {
                        for (int k = 0; k < studentList.get(j).getStudentsCourseList().size(); k++) {
                            if ((courseList.get(i).getTitle().equals(studentList.get(j).getStudentsCourseList().get(k).getTitle()))
                                    && (courseList.get(i).getStream().equals(studentList.get(j).getStudentsCourseList().get(k).getStream()))
                                    && (courseList.get(i).getType().equals(studentList.get(j).getStudentsCourseList().get(k).getType()))) {
                                studentListPerCourse.add(studentList.get(j));
                                u++;
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("Μαθητές του Course με Α/Α [" + (int) (i + 1) + "], " + courseList.get(i).getTitle() + ", " + courseList.get(i).getStream() + " " + courseList.get(i).getType());
                    for (int j = 0; j < u; j++) {
                        System.out.println(studentListPerCourse.get(j));
                    }
                }
            } else if (myInput == 6) {
                ArrayList<Trainer> trainerListPerCourse = new ArrayList();
                for (int i = 0; i < courseList.size(); i++) {
                    int k = 0;
                    for (int j = 0; j < trainerList.size(); j++) {
                        if ((courseList.get(i).getTitle().equals(trainerList.get(j).getCourse().getTitle()))
                                && (courseList.get(i).getStream().equals(trainerList.get(j).getCourse().getStream()))
                                && (courseList.get(i).getType().equals(trainerList.get(j).getCourse().getType()))) {
                            trainerListPerCourse.add(trainerList.get(j));
                            k++;
                        }
                    }
                    System.out.println("");
                    System.out.println("Εκπαιδευτες του Course με Α/Α [" + (int) (i + 1) + "], " + courseList.get(i).getTitle() + ", " + courseList.get(i).getStream() + " " + courseList.get(i).getType());
                    for (int j = 0; j < k; j++) {
                        System.out.println(trainerListPerCourse.get(j));
                    }
                }
            } else if (myInput == 7) {
                ArrayList<Assignment> assignmentListPerCourse = new ArrayList();
                for (int i = 0; i < courseList.size(); i++) {
                    int k = 0;
                    for (int j = 0; j < assignmentList.size(); j++) {
                        if ((courseList.get(i).getTitle().equals(assignmentList.get(j).getCourse().getTitle()))
                                && (courseList.get(i).getStream().equals(assignmentList.get(j).getCourse().getStream()))
                                && (courseList.get(i).getType().equals(assignmentList.get(j).getCourse().getType()))) {
                            assignmentListPerCourse.add(assignmentList.get(j));
                            k++;
                        }
                    }
                    System.out.println("");
                    System.out.println("Assignments του Course με Α/Α [" + (int) (i + 1) + "], " + courseList.get(i).getTitle() + ", " + courseList.get(i).getStream() + " " + courseList.get(i).getType());
                    for (int j = 0; j < k; j++) {
                        System.out.println(assignmentListPerCourse.get(j));
                    }
                }
            } else if (myInput == 8) {
                ArrayList<Assignment> assignmentListPerStudent = new ArrayList();
                for (int i = 0; i < studentList.size(); i++) {
                    int k = 0;
                    for (int j = 0; j < assignmentList.size(); j++) {
                        if ((studentList.get(i).getFirstName().equals(assignmentList.get(j).getStudent().getFirstName())
                                && (studentList.get(i).getLastName().equals(assignmentList.get(j).getStudent().getLastName())))) {
                            assignmentListPerStudent.add(assignmentList.get(j));
                            k++;
                        }
                    }
                    System.out.println("");
                    System.out.println("Assignments του μαθητή με Α/Α [" + (int) (i + 1) + "], ονοματεπώνυμο " + studentList.get(i).getFirstName() + " " + studentList.get(i).getLastName());
                    for (int j = 0; j < k; j++) {
                        System.out.println(assignmentListPerStudent.get(j));
                    }
                }
            } else if (myInput == 9) {
                ArrayList<Student> studentListWithManyCourses = new ArrayList();
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getStudentsCourseList().size() > 1) {
                        studentListWithManyCourses.add(studentList.get(i));
                    }
                }
                System.out.println("");
                for (int j = 0; j < studentListWithManyCourses.size(); j++) {
                    System.out.println(studentListWithManyCourses.get(j));
                }
            } else {
                System.out.println("Πληκτρολόγησε έναν αριθμό από το 1 έως το 9");
            }
        } while (!((myInput == 1) || (myInput == 2) || (myInput == 3) || (myInput == 4) || (myInput == 5) || (myInput == 6) || (myInput == 7) || (myInput == 8) || (myInput == 9)));
        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
    }

    static void input(ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Student> studentList, ArrayList<Assignment> assignmentList, int iCourse, int iTrainer, int iStudent, int iAssignment, Scanner input) {
        String myInput;
        System.out.println("");
        System.out.println("Τι εγγραφή θέλετε να κάνετε;(υποχρεωτικές επιλογές: Course / Trainer / Student / Assignment)");
        myInput = input.next();
        while ((!myInput.equals("Course")) && (!myInput.equals("Trainer")) && (!myInput.equals("Student")) && (!myInput.equals("Assignment"))) {
            System.out.println("Πληκτρολογήστε μία από τις εξής επιλογές: Course / Trainer / Student / Assignment");
            myInput = input.next();
        }
        while (myInput.equals("Course")) {
            iCourse = courseInput(input, courseList, iCourse);
            questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
        }

        while (myInput.equals("Trainer")) {
            System.out.println("");
            System.out.println("Υπάρχει έτοιμο προς αντιστοίχηση Course για τον εκπαιδευτή; (Y for Yes / N for No)");
            myInput = yesOrNoValidation(input);
            if (myInput.equals("Y")) {
                System.out.println("");
                System.out.println("Πληκτρολογήστε Α/Α του Course");
                int trainersCourse = input.nextInt() - 1;
                iTrainer = trainerInput(input, iTrainer, trainerList, (Course) courseList.get(trainersCourse));
                questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            } else if (myInput.equals("N")) {
                System.out.println("");
                System.out.println("Θα χρειαστεί να κάνετε εγγραφή κάποιου Course");
                iCourse = courseInput(input, courseList, iCourse);
                iTrainer = trainerInput(input, iTrainer, trainerList, (Course) courseList.get(iCourse));
                questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            }
        }

        while (myInput.equals("Student")) {
            System.out.println("");
            System.out.println("Υπάρχει έτοιμο προς αντιστοίχηση Course για το μαθητή; (Y for Yes / N for No)");
            myInput = yesOrNoValidation(input);
            if (myInput.equals("Y")) {
                System.out.println("");
                System.out.println("Πόσα Cοurses έχει ο μαθητής;");
                int studentsNumberOfCourses = input.nextInt();
                for (int i = 0; i < studentsNumberOfCourses; i++) {
                    System.out.println("");
                    System.out.println("Πληκτρολογήστε Α/Α Course του μαθητή");
                    int studentsCourse = input.nextInt() - 1;
                    iStudent = studentInput(input, iStudent, studentList, courseList, studentsCourse);
                    questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
                }
            } else if (myInput.equals("N")) {
                System.out.println("");
                System.out.println("Θα χρειαστεί να κάνετε εγγραφή κάποιου Course");
                iCourse = courseInput(input, courseList, iCourse);
                iStudent = studentInput(input, iStudent, studentList, courseList, iCourse);
                questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            }
        }

        while (myInput.equals("Assignment")) {
            System.out.println("");
            System.out.println("Υπάρχει έτοιμο προς αντιστοίχηση Course για το Assignment; (Y for Yes / N for No)");
            myInput = yesOrNoValidation(input);
            if (myInput.equals("Y")) {
                System.out.println("");
                System.out.println("Πόσα Cοurses έχει ο μαθητής;");
                int studentsNumberOfCourses = input.nextInt();
                for (int i = 0; i < studentsNumberOfCourses; i++) {
                    System.out.println("");
                    System.out.println("Πληκτρολογήστε Α/Α Course του μαθητή");
                    int assignmentsCourse = input.nextInt() - 1;
                    System.out.println("");
                    System.out.println("Υπάρχει έτοιμος προς αντιστοίχηση Μαθητής για το Assignment; (Y for Yes / N for No)");
                    myInput = yesOrNoValidation(input);
                    if (myInput.equals("Y")) {
                        System.out.println("");
                        System.out.println("Πληκτρολογήστε Α/Α του Μαθητή");
                        int assignmentsStudent = input.nextInt() - 1;
                        iAssignment = assignmentInput(input, iAssignment, assignmentList, (Course) courseList.get(assignmentsCourse), (Student) studentList.get(assignmentsStudent));
                        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
                    } else if (myInput.equals("N")) {
                        System.out.println("");
                        System.out.println("Θα χρειαστεί να κάνετε εγγραφή κάποιου μαθητή");
                        iStudent = studentInput(input, iStudent, studentList, courseList, assignmentsCourse);
                        iAssignment = assignmentInput(input, iAssignment, assignmentList, (Course) courseList.get(assignmentsCourse), (Student) studentList.get(iStudent));
                        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
                    }
                }
            } else if (myInput.equals("N")) {
                System.out.println("");
                System.out.println("Θα χρειαστεί να κάνετε εγγραφή κάποιου Course");
                iCourse = courseInput(input, courseList, iCourse);
                System.out.println("");
                System.out.println("Θα χρειαστεί να κάνετε εγγραφή κάποιου μαθητή");
                iStudent = studentInput(input, iStudent, studentList, courseList, iCourse);
                iAssignment = assignmentInput(input, iAssignment, assignmentList, (Course) courseList.get(iCourse), (Student) studentList.get(iStudent));
                questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            }
        }
    }

    static int courseInput(Scanner input, ArrayList<Course> courseList, int iCourse) {
        iCourse++;
        courseList.add(new Course());
        System.out.println("");
        System.out.println("Πληκτρολογήστε τίτλο του Course, π.χ. 'CB8'");
        courseList.get(iCourse).setTitle(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε αντικείμενο του Course, π.χ. 'Java'");
        courseList.get(iCourse).setStream(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε τύπο του Course, π.χ. 'Part-time'");
        courseList.get(iCourse).setType(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε ημερομηνία εναρξης του Course, π.χ. '2023-09-24'");
        courseList.get(iCourse).setStartDate(LocalDate.parse(input.next()));
        System.out.println("");
        System.out.println("Πληκτρολογήστε ημερομηνία λήξης του Course, π.χ. '2023-09-24'");
        courseList.get(iCourse).setEndDate(LocalDate.parse(input.next()));
        System.out.println("");
        System.out.println("Μόλις δημιουργήσατε το " + courseList.get(iCourse));
        return iCourse;
    }

    static int trainerInput(Scanner input, int iTrainer, ArrayList<Trainer> trainerList, Course course) {
        iTrainer++;
        trainerList.add(new Trainer());
        trainerList.get(iTrainer).setCourse(course);
        System.out.println("");
        System.out.println("Πληκτρολογήστε το όνομα του εκπαιδευτή");
        trainerList.get(iTrainer).setFirstName(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε το επίθετο του εκπαιδευτή");
        trainerList.get(iTrainer).setLastName(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε το αντικείμενο του εκπαιδευτή");
        trainerList.get(iTrainer).setSubject(input.next());
        System.out.println("");
        System.out.println("Μόλις δημιουργήσατε την/τον " + trainerList.get(iTrainer));
        return iTrainer;
    }

    static int studentInput(Scanner input, int iStudent, ArrayList<Student> studentList, ArrayList<Course> courseList, int i) {
        iStudent++;
        studentList.add(new Student());
        studentList.get(iStudent).setStudentsCourseList(courseList, i);
        System.out.println("");
        System.out.println("Πληκτρολογήστε το όνομα του μαθητή");
        studentList.get(iStudent).setFirstName(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε το επίθετο του μαθητή");
        studentList.get(iStudent).setLastName(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε την ημερομηνία γέννησης του μαθητή, π.χ. '1990-05-25");
        studentList.get(iStudent).setDateOfBirth(LocalDate.parse(input.next()));
        System.out.println("");
        System.out.println("Πληκτρολογήστε τα δίδακτρα του μαθητή");
        studentList.get(iStudent).setTuitionFees(input.nextFloat());
        System.out.println("");
        System.out.println("Μόλις δημιουργήσατε την/τον " + studentList.get(iStudent));
        return iStudent;
    }

    static int assignmentInput(Scanner input, int iAssignment, ArrayList<Assignment> assignmentList, Course course, Student student) {
        iAssignment++;
        assignmentList.add(new Assignment());
        assignmentList.get(iAssignment).setCourse(course);
        assignmentList.get(iAssignment).setStudent(student);
        System.out.println("");
        System.out.println("Πληκτρολογήστε τον τίτλο του Assignment");
        assignmentList.get(iAssignment).setTitle(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε την περιγραφή του Assignment");
        assignmentList.get(iAssignment).setDescription(input.next());
        System.out.println("");
        System.out.println("Πληκτρολογήστε την ημερομηνία παράδοσης του Assignment, π.χ. '2022-05-25");
        assignmentList.get(iAssignment).setSubDateTime(LocalDate.parse(input.next()));
        System.out.println("");
        System.out.println("Πληκτρολογήστε το βαθμό προφορικής εξέτασης του Assignment");
        assignmentList.get(iAssignment).setOralMark(input.nextFloat());
        System.out.println("");
        System.out.println("Πληκτρολογήστε το βαθμό συνολικής εξέτασης του Assignment");
        assignmentList.get(iAssignment).setTotalMark(input.nextFloat());
        System.out.println("");
        System.out.println("Μόλις δημιουργήσατε το " + assignmentList.get(iAssignment));
        return iAssignment;
    }

    static void findTheAssignmentsOfTheWeek(ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Student> studentList, ArrayList<Assignment> assignmentList, int iCourse, int iTrainer, int iStudent, int iAssignment, Scanner input) {
        String myInput;
        LocalDate myDate;
        LocalDate assignmentDate;
        LocalDate myMonday;
        LocalDate myFriday;
        System.out.println("");
        System.out.println("Πληκτρολόγησε ημερομηνία, π.χ. '2021-02-24");
        myInput = input.next();
        myDate = LocalDate.parse(myInput);
        ArrayList<Student> studentListWithAssignments = new ArrayList();
        int k = 0;
        for (int i = 0; i < assignmentList.size(); i++) {
            assignmentDate = assignmentList.get(i).getSubDateTime();
            if (myDate.getDayOfWeek().equals(MONDAY)) {
                myMonday = myDate.minusDays(0);
                myFriday = myDate.plusDays(4);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(TUESDAY)) {
                myMonday = myDate.minusDays(1);
                myFriday = myDate.plusDays(3);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(WEDNESDAY)) {
                myMonday = myDate.minusDays(2);
                myFriday = myDate.plusDays(2);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(THURSDAY)) {
                myMonday = myDate.minusDays(3);
                myFriday = myDate.plusDays(1);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(FRIDAY)) {
                myMonday = myDate.minusDays(4);
                myFriday = myDate.plusDays(0);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(SATURDAY)) {
                myMonday = myDate.minusDays(5);
                myFriday = myDate.minusDays(1);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
            if (myDate.getDayOfWeek().equals(SUNDAY)) {
                myMonday = myDate.minusDays(6);
                myFriday = myDate.minusDays(2);
                if ((assignmentDate.equals(myMonday)) || ((assignmentDate.isAfter(myMonday)) && (assignmentDate.isBefore(myFriday))) || (assignmentDate.equals(myFriday))) {
                    studentListWithAssignments.add(assignmentList.get(i).getStudent());
                    k++;
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < k; i++) {
            System.out.println(studentListWithAssignments.get(i));
        }
        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);

    }

    static void syntheticData(ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Student> studentList, ArrayList<Assignment> assignmentList, int iCourse, int iTrainer, int iStudent, int iAssignment, Scanner input) {
        //AUTOMATI EISAGWGI COURSES
        for (int i = 0; i < 8; i++) {
            courseList.add(new Course());
        }

        courseList.get(0).setTitle("CB8");
        courseList.get(0).setStream("Java");
        courseList.get(0).setType("Full-time");
        courseList.get(0).setStartDate(LocalDate.of(2019, 01, 01));
        courseList.get(0).setEndDate(LocalDate.of(2019, 03, 31));
        courseList.get(1).setTitle("CB8");
        courseList.get(1).setStream("C#");
        courseList.get(1).setType("Full-time");
        courseList.get(1).setStartDate(LocalDate.of(2019, 01, 01));
        courseList.get(1).setEndDate(LocalDate.of(2019, 03, 31));
        courseList.get(2).setTitle("CB8");
        courseList.get(2).setStream("Java");
        courseList.get(2).setType("Part-time");
        courseList.get(2).setStartDate(LocalDate.of(2019, 01, 01));
        courseList.get(2).setEndDate(LocalDate.of(2019, 06, 30));
        courseList.get(3).setTitle("CB8");
        courseList.get(3).setStream("C#");
        courseList.get(3).setType("Part-time");
        courseList.get(3).setStartDate(LocalDate.of(2019, 01, 01));
        courseList.get(3).setEndDate(LocalDate.of(2019, 06, 30));
        courseList.get(4).setTitle("CB9");
        courseList.get(4).setStream("Java");
        courseList.get(4).setType("Full-time");
        courseList.get(4).setStartDate(LocalDate.of(2020, 01, 01));
        courseList.get(4).setEndDate(LocalDate.of(2020, 03, 31));
        courseList.get(5).setTitle("CB9");
        courseList.get(5).setStream("C#");
        courseList.get(5).setType("Full-time");
        courseList.get(5).setStartDate(LocalDate.of(2020, 01, 01));
        courseList.get(5).setEndDate(LocalDate.of(2020, 03, 31));
        courseList.get(6).setTitle("CB9");
        courseList.get(6).setStream("Java");
        courseList.get(6).setType("Part-time");
        courseList.get(6).setStartDate(LocalDate.of(2020, 01, 01));
        courseList.get(6).setEndDate(LocalDate.of(2020, 06, 30));
        courseList.get(7).setTitle("CB9");
        courseList.get(7).setStream("C#");
        courseList.get(7).setType("Part-time");
        courseList.get(7).setStartDate(LocalDate.of(2020, 01, 01));
        courseList.get(7).setEndDate(LocalDate.of(2020, 06, 30));

        //AUTOMATI EISAGWGI TRAINERS
        for (int i = 0; i < 16; i++) {
            trainerList.add(new Trainer());
        }
        //CB8 JAVA FULL-TIME
        trainerList.get(0).setFirstName("Ioannis");
        trainerList.get(0).setLastName("Ioannidis");
        trainerList.get(0).setSubject("Java");
        trainerList.get(0).setCourse(courseList.get(0));
        trainerList.get(1).setFirstName("Eleni");
        trainerList.get(1).setLastName("Elenaki");
        trainerList.get(1).setSubject("Java");
        trainerList.get(1).setCourse(courseList.get(0));

        //CB8 C# FULL-TIME
        trainerList.get(2).setFirstName("Ioannis");
        trainerList.get(2).setLastName("Ioannou");
        trainerList.get(2).setSubject("C#");
        trainerList.get(2).setCourse(courseList.get(1));
        trainerList.get(3).setFirstName("Eleni");
        trainerList.get(3).setLastName("Triantafylloy");
        trainerList.get(3).setSubject("C#");
        trainerList.get(3).setCourse(courseList.get(1));

        //CB8 JAVA PART-TIME
        trainerList.get(4).setFirstName("Georgios");
        trainerList.get(4).setLastName("georgiou");
        trainerList.get(4).setSubject("Java");
        trainerList.get(4).setCourse(courseList.get(2));
        trainerList.get(5).setFirstName("Maria");
        trainerList.get(5).setLastName("Andreou");
        trainerList.get(5).setSubject("Java");
        trainerList.get(5).setCourse(courseList.get(2));

        //CB8 C# PART-TIME
        trainerList.get(6).setFirstName("Argyro");
        trainerList.get(6).setLastName("Mavrinou");
        trainerList.get(6).setSubject("C#");
        trainerList.get(6).setCourse(courseList.get(3));
        trainerList.get(7).setFirstName("Ioannis");
        trainerList.get(7).setLastName("Sopenhower");
        trainerList.get(7).setSubject("C#");
        trainerList.get(7).setCourse(courseList.get(3));

        //CB9 JAVA FULL-TIME
        trainerList.get(8).setFirstName("Ioannis");
        trainerList.get(8).setLastName("Ioannidis");
        trainerList.get(8).setSubject("Java");
        trainerList.get(8).setCourse(courseList.get(4));
        trainerList.get(9).setFirstName("Eleni");
        trainerList.get(9).setLastName("Elenaki");
        trainerList.get(9).setSubject("Java");
        trainerList.get(9).setCourse(courseList.get(4));

        //CB9 C# FULL-TIME
        trainerList.get(10).setFirstName("Ioannis");
        trainerList.get(10).setLastName("Ioannou");
        trainerList.get(10).setSubject("C#");
        trainerList.get(10).setCourse(courseList.get(5));
        trainerList.get(11).setFirstName("Eleni");
        trainerList.get(11).setLastName("Triantafylloy");
        trainerList.get(11).setSubject("C#");
        trainerList.get(11).setCourse(courseList.get(5));

        //CB9 JAVA PART-TIME
        trainerList.get(12).setFirstName("Georgios");
        trainerList.get(12).setLastName("georgiou");
        trainerList.get(12).setSubject("Java");
        trainerList.get(12).setCourse(courseList.get(6));
        trainerList.get(13).setFirstName("Maria");
        trainerList.get(13).setLastName("Andreou");
        trainerList.get(13).setSubject("Java");
        trainerList.get(13).setCourse(courseList.get(6));

        //CB9 C# PART-TIME
        trainerList.get(14).setFirstName("Argyro");
        trainerList.get(14).setLastName("Mavrinou");
        trainerList.get(14).setSubject("C#");
        trainerList.get(14).setCourse(courseList.get(7));
        trainerList.get(15).setFirstName("Ioannis");
        trainerList.get(15).setLastName("Sopenhower");
        trainerList.get(15).setSubject("C#");
        trainerList.get(15).setCourse(courseList.get(7));

        //AUTOMATI EISAGWGI STUDENTS
        for (int i = 0; i < 40; i++) {
            studentList.add(new Student());
        }

        //CB8 JAVA FULL-TIME
        studentList.get(0).setFirstName("A");
        studentList.get(0).setLastName("A");
        studentList.get(0).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(0).setTuitionFees(2250);
        studentList.get(0).setStudentsCourseList(courseList, 0);
        studentList.get(0).setStudentsCourseList(courseList, 1);
        studentList.get(1).setFirstName("B");
        studentList.get(1).setLastName("B");
        studentList.get(1).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(1).setTuitionFees(2250);
        studentList.get(1).setStudentsCourseList(courseList, 0);
        studentList.get(2).setFirstName("C");
        studentList.get(2).setLastName("C");
        studentList.get(2).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(2).setTuitionFees(2250);
        studentList.get(2).setStudentsCourseList(courseList, 0);
        studentList.get(3).setFirstName("D");
        studentList.get(3).setLastName("D");
        studentList.get(3).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(3).setTuitionFees(2250);
        studentList.get(3).setStudentsCourseList(courseList, 0);
        studentList.get(4).setFirstName("E");
        studentList.get(4).setLastName("E");
        studentList.get(4).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(4).setTuitionFees(2250);
        studentList.get(4).setStudentsCourseList(courseList, 0);

        //CB8 C# FULL-TIME
        studentList.get(5).setFirstName("F");
        studentList.get(5).setLastName("F");
        studentList.get(5).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(5).setTuitionFees(2250);
        studentList.get(5).setStudentsCourseList(courseList, 1);
        studentList.get(5).setStudentsCourseList(courseList, 2);
        studentList.get(6).setFirstName("G");
        studentList.get(6).setLastName("G");
        studentList.get(6).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(6).setTuitionFees(2250);
        studentList.get(6).setStudentsCourseList(courseList, 1);
        studentList.get(7).setFirstName("H");
        studentList.get(7).setLastName("H");
        studentList.get(7).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(7).setTuitionFees(2250);
        studentList.get(7).setStudentsCourseList(courseList, 1);
        studentList.get(8).setFirstName("I");
        studentList.get(8).setLastName("I");
        studentList.get(8).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(8).setTuitionFees(2250);
        studentList.get(8).setStudentsCourseList(courseList, 1);
        studentList.get(9).setFirstName("J");
        studentList.get(9).setLastName("J");
        studentList.get(9).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(9).setTuitionFees(2250);
        studentList.get(9).setStudentsCourseList(courseList, 1);

        //CB8 JAVA PART-TIME
        studentList.get(10).setFirstName("K");
        studentList.get(10).setLastName("K");
        studentList.get(10).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(10).setTuitionFees(2250);
        studentList.get(10).setStudentsCourseList(courseList, 2);
        studentList.get(10).setStudentsCourseList(courseList, 3);
        studentList.get(11).setFirstName("L");
        studentList.get(11).setLastName("L");
        studentList.get(11).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(11).setTuitionFees(2250);
        studentList.get(11).setStudentsCourseList(courseList, 2);
        studentList.get(12).setFirstName("M");
        studentList.get(12).setLastName("M");
        studentList.get(12).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(12).setTuitionFees(2250);
        studentList.get(12).setStudentsCourseList(courseList, 2);
        studentList.get(13).setFirstName("N");
        studentList.get(13).setLastName("N");
        studentList.get(13).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(13).setTuitionFees(2250);
        studentList.get(13).setStudentsCourseList(courseList, 2);
        studentList.get(14).setFirstName("O");
        studentList.get(14).setLastName("O");
        studentList.get(14).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(14).setTuitionFees(2250);
        studentList.get(14).setStudentsCourseList(courseList, 2);

        //CB8 C# PART-TIME
        studentList.get(15).setFirstName("P");
        studentList.get(15).setLastName("P");
        studentList.get(15).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(15).setTuitionFees(2250);
        studentList.get(15).setStudentsCourseList(courseList, 3);
        studentList.get(15).setStudentsCourseList(courseList, 4);
        studentList.get(16).setFirstName("Q");
        studentList.get(16).setLastName("Q");
        studentList.get(16).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(16).setTuitionFees(2250);
        studentList.get(16).setStudentsCourseList(courseList, 3);
        studentList.get(17).setFirstName("R");
        studentList.get(17).setLastName("R");
        studentList.get(17).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(17).setTuitionFees(2250);
        studentList.get(17).setStudentsCourseList(courseList, 3);
        studentList.get(18).setFirstName("S");
        studentList.get(18).setLastName("S");
        studentList.get(18).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(18).setTuitionFees(2250);
        studentList.get(18).setStudentsCourseList(courseList, 3);
        studentList.get(19).setFirstName("T");
        studentList.get(19).setLastName("T");
        studentList.get(19).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(19).setTuitionFees(2250);
        studentList.get(19).setStudentsCourseList(courseList, 3);

        //CB9 JAVA FULL-TIME
        studentList.get(20).setFirstName("U");
        studentList.get(20).setLastName("U");
        studentList.get(20).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(20).setTuitionFees(2250);
        studentList.get(20).setStudentsCourseList(courseList, 5);
        studentList.get(20).setStudentsCourseList(courseList, 4);
        studentList.get(21).setFirstName("V");
        studentList.get(21).setLastName("V");
        studentList.get(21).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(21).setTuitionFees(2500);
        studentList.get(21).setStudentsCourseList(courseList, 4);
        studentList.get(22).setFirstName("W");
        studentList.get(22).setLastName("W");
        studentList.get(22).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(22).setTuitionFees(2500);
        studentList.get(22).setStudentsCourseList(courseList, 4);
        studentList.get(23).setFirstName("X");
        studentList.get(23).setLastName("X");
        studentList.get(23).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(23).setTuitionFees(2250);
        studentList.get(23).setStudentsCourseList(courseList, 4);
        studentList.get(24).setFirstName("Y");
        studentList.get(24).setLastName("Y");
        studentList.get(24).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(24).setTuitionFees(2250);
        studentList.get(24).setStudentsCourseList(courseList, 4);

        //CB9 C# FULL-TIME
        studentList.get(25).setFirstName("Z");
        studentList.get(25).setLastName("Z");
        studentList.get(25).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(25).setTuitionFees(2250);
        studentList.get(25).setStudentsCourseList(courseList, 6);
        studentList.get(25).setStudentsCourseList(courseList, 5);
        studentList.get(26).setFirstName("AA");
        studentList.get(26).setLastName("AA");
        studentList.get(26).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(26).setTuitionFees(2250);
        studentList.get(26).setStudentsCourseList(courseList, 5);
        studentList.get(27).setFirstName("BB");
        studentList.get(27).setLastName("BB");
        studentList.get(27).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(27).setTuitionFees(2250);
        studentList.get(27).setStudentsCourseList(courseList, 5);
        studentList.get(28).setFirstName("CC");
        studentList.get(28).setLastName("CC");
        studentList.get(28).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(28).setTuitionFees(2250);
        studentList.get(28).setStudentsCourseList(courseList, 5);
        studentList.get(29).setFirstName("DD");
        studentList.get(29).setLastName("DD");
        studentList.get(29).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(29).setTuitionFees(2250);
        studentList.get(29).setStudentsCourseList(courseList, 5);

        //CB9 JAVA PART-TIME
        studentList.get(30).setFirstName("EE");
        studentList.get(30).setLastName("EE");
        studentList.get(30).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(30).setTuitionFees(2250);
        studentList.get(30).setStudentsCourseList(courseList, 7);
        studentList.get(30).setStudentsCourseList(courseList, 6);
        studentList.get(31).setFirstName("FF");
        studentList.get(31).setLastName("FF");
        studentList.get(31).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(31).setTuitionFees(2250);
        studentList.get(31).setStudentsCourseList(courseList, 6);
        studentList.get(32).setFirstName("GG");
        studentList.get(32).setLastName("GG");
        studentList.get(32).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(32).setTuitionFees(2250);
        studentList.get(32).setStudentsCourseList(courseList, 6);
        studentList.get(33).setFirstName("HH");
        studentList.get(33).setLastName("HH");
        studentList.get(33).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(33).setTuitionFees(2250);
        studentList.get(33).setStudentsCourseList(courseList, 6);
        studentList.get(34).setFirstName("II");
        studentList.get(34).setLastName("II");
        studentList.get(34).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(34).setTuitionFees(2250);
        studentList.get(34).setStudentsCourseList(courseList, 6);

        //CB9 C# PART-TIME
        studentList.get(35).setFirstName("JJ");
        studentList.get(35).setLastName("JJ");
        studentList.get(35).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(35).setTuitionFees(2250);
        studentList.get(35).setStudentsCourseList(courseList, 1);
        studentList.get(35).setStudentsCourseList(courseList, 7);
        studentList.get(36).setFirstName("KK");
        studentList.get(36).setLastName("KK");
        studentList.get(36).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(36).setTuitionFees(2250);
        studentList.get(36).setStudentsCourseList(courseList, 7);
        studentList.get(37).setFirstName("LL");
        studentList.get(37).setLastName("LL");
        studentList.get(37).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(37).setTuitionFees(2250);
        studentList.get(37).setStudentsCourseList(courseList, 7);
        studentList.get(38).setFirstName("MM");
        studentList.get(38).setLastName("MM");
        studentList.get(38).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(38).setTuitionFees(2250);
        studentList.get(38).setStudentsCourseList(courseList, 7);
        studentList.get(39).setFirstName("NN");
        studentList.get(39).setLastName("NN");
        studentList.get(39).setDateOfBirth(LocalDate.of(1991, 05, 03));
        studentList.get(39).setTuitionFees(2250);
        studentList.get(39).setStudentsCourseList(courseList, 7);

        //AUTOMATI EISAGWGI ASSIGNMENTS
        for (int i = 0; i < 80; i++) {
            assignmentList.add(new Assignment());
        }

        //CB8 JAVA FULL-TIME
        assignmentList.get(0).setTitle("Assignment 1");
        assignmentList.get(0).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(0).setSubDateTime(LocalDate.of(2022, 05, 03));
        assignmentList.get(0).setOralMark(3);
        assignmentList.get(0).setTotalMark(10);
        assignmentList.get(0).setCourse(courseList.get(0));
        assignmentList.get(0).setStudent(studentList.get(0));
        assignmentList.get(1).setTitle("Project A");
        assignmentList.get(1).setDescription("JAVA");
        assignmentList.get(1).setSubDateTime(LocalDate.of(2022, 05, 04));
        assignmentList.get(1).setOralMark(3);
        assignmentList.get(1).setTotalMark(10);
        assignmentList.get(1).setCourse(courseList.get(0));
        assignmentList.get(1).setStudent(studentList.get(0));

        assignmentList.get(2).setTitle("Assignment 1");
        assignmentList.get(2).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(2).setSubDateTime(LocalDate.of(2022, 05, 05));
        assignmentList.get(2).setOralMark(3);
        assignmentList.get(2).setTotalMark(10);
        assignmentList.get(2).setCourse(courseList.get(0));
        assignmentList.get(2).setStudent(studentList.get(1));
        assignmentList.get(3).setTitle("Project A");
        assignmentList.get(3).setDescription("JAVA");
        assignmentList.get(3).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(3).setOralMark(3);
        assignmentList.get(3).setTotalMark(10);
        assignmentList.get(3).setCourse(courseList.get(0));
        assignmentList.get(3).setStudent(studentList.get(1));

        assignmentList.get(4).setTitle("Assignment 1");
        assignmentList.get(4).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(4).setSubDateTime(LocalDate.of(2023, 02, 01));
        assignmentList.get(4).setOralMark(3);
        assignmentList.get(4).setTotalMark(10);
        assignmentList.get(4).setCourse(courseList.get(0));
        assignmentList.get(4).setStudent(studentList.get(2));
        assignmentList.get(5).setTitle("Project A");
        assignmentList.get(5).setDescription("JAVA");
        assignmentList.get(5).setSubDateTime(LocalDate.of(2021, 3, 1));
        assignmentList.get(5).setOralMark(3);
        assignmentList.get(5).setTotalMark(10);
        assignmentList.get(5).setCourse(courseList.get(0));
        assignmentList.get(5).setStudent(studentList.get(2));

        assignmentList.get(6).setTitle("Assignment 1");
        assignmentList.get(6).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(6).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(6).setOralMark(3);
        assignmentList.get(6).setTotalMark(10);
        assignmentList.get(6).setCourse(courseList.get(0));
        assignmentList.get(6).setStudent(studentList.get(3));
        assignmentList.get(7).setTitle("Project A");
        assignmentList.get(7).setDescription("JAVA");
        assignmentList.get(7).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(7).setOralMark(3);
        assignmentList.get(7).setTotalMark(10);
        assignmentList.get(7).setCourse(courseList.get(0));
        assignmentList.get(7).setStudent(studentList.get(3));

        assignmentList.get(8).setTitle("Assignment 1");
        assignmentList.get(8).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(8).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(8).setOralMark(3);
        assignmentList.get(8).setTotalMark(10);
        assignmentList.get(8).setCourse(courseList.get(0));
        assignmentList.get(8).setStudent(studentList.get(4));
        assignmentList.get(9).setTitle("Project A");
        assignmentList.get(9).setDescription("JAVA");
        assignmentList.get(9).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(9).setOralMark(3);
        assignmentList.get(9).setTotalMark(10);
        assignmentList.get(9).setCourse(courseList.get(0));
        assignmentList.get(9).setStudent(studentList.get(4));

        //CB8 C# FULL-TIME
        assignmentList.get(10).setTitle("Assignment 1");
        assignmentList.get(10).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(10).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(10).setOralMark(3);
        assignmentList.get(10).setTotalMark(10);
        assignmentList.get(10).setCourse(courseList.get(1));
        assignmentList.get(10).setStudent(studentList.get(5));
        assignmentList.get(11).setTitle("Project A");
        assignmentList.get(11).setDescription("JAVA");
        assignmentList.get(11).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(11).setOralMark(3);
        assignmentList.get(11).setTotalMark(10);
        assignmentList.get(11).setCourse(courseList.get(1));
        assignmentList.get(11).setStudent(studentList.get(5));

        assignmentList.get(12).setTitle("Assignment 1");
        assignmentList.get(12).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(12).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(12).setOralMark(3);
        assignmentList.get(12).setTotalMark(10);
        assignmentList.get(12).setCourse(courseList.get(1));
        assignmentList.get(12).setStudent(studentList.get(6));
        assignmentList.get(13).setTitle("Project A");
        assignmentList.get(13).setDescription("JAVA");
        assignmentList.get(13).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(13).setOralMark(3);
        assignmentList.get(13).setTotalMark(10);
        assignmentList.get(13).setCourse(courseList.get(1));
        assignmentList.get(13).setStudent(studentList.get(6));

        assignmentList.get(14).setTitle("Assignment 1");
        assignmentList.get(14).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(14).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(14).setOralMark(3);
        assignmentList.get(14).setTotalMark(10);
        assignmentList.get(14).setCourse(courseList.get(1));
        assignmentList.get(14).setStudent(studentList.get(7));
        assignmentList.get(15).setTitle("Project A");
        assignmentList.get(15).setDescription("JAVA");
        assignmentList.get(15).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(15).setOralMark(3);
        assignmentList.get(15).setTotalMark(10);
        assignmentList.get(15).setCourse(courseList.get(1));
        assignmentList.get(15).setStudent(studentList.get(7));

        assignmentList.get(16).setTitle("Assignment 1");
        assignmentList.get(16).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(16).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(16).setOralMark(3);
        assignmentList.get(16).setTotalMark(10);
        assignmentList.get(16).setCourse(courseList.get(1));
        assignmentList.get(16).setStudent(studentList.get(8));
        assignmentList.get(17).setTitle("Project A");
        assignmentList.get(17).setDescription("JAVA");
        assignmentList.get(17).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(17).setOralMark(3);
        assignmentList.get(17).setTotalMark(10);
        assignmentList.get(17).setCourse(courseList.get(1));
        assignmentList.get(17).setStudent(studentList.get(8));

        assignmentList.get(18).setTitle("Assignment 1");
        assignmentList.get(18).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(18).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(18).setOralMark(3);
        assignmentList.get(18).setTotalMark(10);
        assignmentList.get(18).setCourse(courseList.get(1));
        assignmentList.get(18).setStudent(studentList.get(9));
        assignmentList.get(19).setTitle("Project A");
        assignmentList.get(19).setDescription("JAVA");
        assignmentList.get(19).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(19).setOralMark(3);
        assignmentList.get(19).setTotalMark(10);
        assignmentList.get(19).setCourse(courseList.get(1));
        assignmentList.get(19).setStudent(studentList.get(9));

        //CB8 JAVA PART-TIME
        assignmentList.get(20).setTitle("Assignment 1");
        assignmentList.get(20).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(20).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(20).setOralMark(3);
        assignmentList.get(20).setTotalMark(10);
        assignmentList.get(20).setCourse(courseList.get(2));
        assignmentList.get(20).setStudent(studentList.get(10));
        assignmentList.get(21).setTitle("Project A");
        assignmentList.get(21).setDescription("JAVA");
        assignmentList.get(21).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(21).setOralMark(3);
        assignmentList.get(21).setTotalMark(10);
        assignmentList.get(21).setCourse(courseList.get(2));
        assignmentList.get(21).setStudent(studentList.get(10));

        assignmentList.get(22).setTitle("Assignment 1");
        assignmentList.get(22).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(22).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(22).setOralMark(3);
        assignmentList.get(22).setTotalMark(10);
        assignmentList.get(22).setCourse(courseList.get(2));
        assignmentList.get(22).setStudent(studentList.get(11));
        assignmentList.get(23).setTitle("Project A");
        assignmentList.get(23).setDescription("JAVA");
        assignmentList.get(23).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(23).setOralMark(3);
        assignmentList.get(23).setTotalMark(10);
        assignmentList.get(23).setCourse(courseList.get(2));
        assignmentList.get(23).setStudent(studentList.get(11));

        assignmentList.get(24).setTitle("Assignment 1");
        assignmentList.get(24).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(24).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(24).setOralMark(3);
        assignmentList.get(24).setTotalMark(10);
        assignmentList.get(24).setCourse(courseList.get(2));
        assignmentList.get(24).setStudent(studentList.get(12));
        assignmentList.get(25).setTitle("Project A");
        assignmentList.get(25).setDescription("JAVA");
        assignmentList.get(25).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(25).setOralMark(3);
        assignmentList.get(25).setTotalMark(10);
        assignmentList.get(25).setCourse(courseList.get(2));
        assignmentList.get(25).setStudent(studentList.get(12));

        assignmentList.get(26).setTitle("Assignment 1");
        assignmentList.get(26).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(26).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(26).setOralMark(3);
        assignmentList.get(26).setTotalMark(10);
        assignmentList.get(26).setCourse(courseList.get(2));
        assignmentList.get(26).setStudent(studentList.get(13));
        assignmentList.get(27).setTitle("Project A");
        assignmentList.get(27).setDescription("JAVA");
        assignmentList.get(27).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(27).setOralMark(3);
        assignmentList.get(27).setTotalMark(10);
        assignmentList.get(27).setCourse(courseList.get(2));
        assignmentList.get(27).setStudent(studentList.get(13));

        assignmentList.get(28).setTitle("Assignment 1");
        assignmentList.get(28).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(28).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(28).setOralMark(3);
        assignmentList.get(28).setTotalMark(10);
        assignmentList.get(28).setCourse(courseList.get(2));
        assignmentList.get(28).setStudent(studentList.get(14));
        assignmentList.get(29).setTitle("Project A");
        assignmentList.get(29).setDescription("JAVA");
        assignmentList.get(29).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(29).setOralMark(3);
        assignmentList.get(29).setTotalMark(10);
        assignmentList.get(29).setCourse(courseList.get(2));
        assignmentList.get(29).setStudent(studentList.get(14));

        //CB8 C# PART-TIME
        assignmentList.get(30).setTitle("Assignment 1");
        assignmentList.get(30).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(30).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(30).setOralMark(3);
        assignmentList.get(30).setTotalMark(10);
        assignmentList.get(30).setCourse(courseList.get(3));
        assignmentList.get(30).setStudent(studentList.get(15));
        assignmentList.get(31).setTitle("Project A");
        assignmentList.get(31).setDescription("JAVA");
        assignmentList.get(31).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(31).setOralMark(3);
        assignmentList.get(31).setTotalMark(10);
        assignmentList.get(31).setCourse(courseList.get(3));
        assignmentList.get(31).setStudent(studentList.get(15));

        assignmentList.get(32).setTitle("Assignment 1");
        assignmentList.get(32).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(32).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(32).setOralMark(3);
        assignmentList.get(32).setTotalMark(10);
        assignmentList.get(32).setCourse(courseList.get(3));
        assignmentList.get(32).setStudent(studentList.get(16));
        assignmentList.get(33).setTitle("Project A");
        assignmentList.get(33).setDescription("JAVA");
        assignmentList.get(33).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(33).setOralMark(3);
        assignmentList.get(33).setTotalMark(10);
        assignmentList.get(33).setCourse(courseList.get(3));
        assignmentList.get(33).setStudent(studentList.get(16));

        assignmentList.get(34).setTitle("Assignment 1");
        assignmentList.get(34).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(34).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(34).setOralMark(3);
        assignmentList.get(34).setTotalMark(10);
        assignmentList.get(34).setCourse(courseList.get(3));
        assignmentList.get(34).setStudent(studentList.get(17));
        assignmentList.get(35).setTitle("Project A");
        assignmentList.get(35).setDescription("JAVA");
        assignmentList.get(35).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(35).setOralMark(3);
        assignmentList.get(35).setTotalMark(10);
        assignmentList.get(35).setCourse(courseList.get(3));
        assignmentList.get(35).setStudent(studentList.get(17));

        assignmentList.get(36).setTitle("Assignment 1");
        assignmentList.get(36).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(36).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(36).setOralMark(3);
        assignmentList.get(36).setTotalMark(10);
        assignmentList.get(36).setCourse(courseList.get(3));
        assignmentList.get(36).setStudent(studentList.get(18));
        assignmentList.get(37).setTitle("Project A");
        assignmentList.get(37).setDescription("JAVA");
        assignmentList.get(37).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(37).setOralMark(3);
        assignmentList.get(37).setTotalMark(10);
        assignmentList.get(37).setCourse(courseList.get(3));
        assignmentList.get(37).setStudent(studentList.get(18));

        assignmentList.get(38).setTitle("Assignment 1");
        assignmentList.get(38).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(38).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(38).setOralMark(3);
        assignmentList.get(38).setTotalMark(10);
        assignmentList.get(38).setCourse(courseList.get(3));
        assignmentList.get(38).setStudent(studentList.get(19));
        assignmentList.get(39).setTitle("Project A");
        assignmentList.get(39).setDescription("JAVA");
        assignmentList.get(39).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(39).setOralMark(3);
        assignmentList.get(39).setTotalMark(10);
        assignmentList.get(39).setCourse(courseList.get(3));
        assignmentList.get(39).setStudent(studentList.get(19));

        //CB9 JAVA FULL-TIME
        assignmentList.get(40).setTitle("Assignment 1");
        assignmentList.get(40).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(40).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(40).setOralMark(3);
        assignmentList.get(40).setTotalMark(10);
        assignmentList.get(40).setCourse(courseList.get(4));
        assignmentList.get(40).setStudent(studentList.get(20));
        assignmentList.get(41).setTitle("Project A");
        assignmentList.get(41).setDescription("JAVA");
        assignmentList.get(41).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(41).setOralMark(3);
        assignmentList.get(41).setTotalMark(10);
        assignmentList.get(41).setCourse(courseList.get(4));
        assignmentList.get(41).setStudent(studentList.get(20));

        assignmentList.get(42).setTitle("Assignment 1");
        assignmentList.get(42).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(42).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(42).setOralMark(3);
        assignmentList.get(42).setTotalMark(10);
        assignmentList.get(42).setCourse(courseList.get(4));
        assignmentList.get(42).setStudent(studentList.get(21));
        assignmentList.get(43).setTitle("Project A");
        assignmentList.get(43).setDescription("JAVA");
        assignmentList.get(43).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(43).setOralMark(3);
        assignmentList.get(43).setTotalMark(10);
        assignmentList.get(43).setCourse(courseList.get(4));
        assignmentList.get(43).setStudent(studentList.get(21));

        assignmentList.get(44).setTitle("Assignment 1");
        assignmentList.get(44).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(44).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(44).setOralMark(3);
        assignmentList.get(44).setTotalMark(10);
        assignmentList.get(44).setCourse(courseList.get(4));
        assignmentList.get(44).setStudent(studentList.get(22));
        assignmentList.get(45).setTitle("Project A");
        assignmentList.get(45).setDescription("JAVA");
        assignmentList.get(45).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(45).setOralMark(3);
        assignmentList.get(45).setTotalMark(10);
        assignmentList.get(45).setCourse(courseList.get(4));
        assignmentList.get(45).setStudent(studentList.get(22));

        assignmentList.get(46).setTitle("Assignment 1");
        assignmentList.get(46).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(46).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(46).setOralMark(3);
        assignmentList.get(46).setTotalMark(10);
        assignmentList.get(46).setCourse(courseList.get(4));
        assignmentList.get(46).setStudent(studentList.get(23));
        assignmentList.get(47).setTitle("Project A");
        assignmentList.get(47).setDescription("JAVA");
        assignmentList.get(47).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(47).setOralMark(3);
        assignmentList.get(47).setTotalMark(10);
        assignmentList.get(47).setCourse(courseList.get(4));
        assignmentList.get(47).setStudent(studentList.get(23));

        assignmentList.get(48).setTitle("Assignment 1");
        assignmentList.get(48).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(48).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(48).setOralMark(3);
        assignmentList.get(48).setTotalMark(10);
        assignmentList.get(48).setCourse(courseList.get(4));
        assignmentList.get(48).setStudent(studentList.get(24));
        assignmentList.get(49).setTitle("Project A");
        assignmentList.get(49).setDescription("JAVA");
        assignmentList.get(49).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(49).setOralMark(3);
        assignmentList.get(49).setTotalMark(10);
        assignmentList.get(49).setCourse(courseList.get(4));
        assignmentList.get(49).setStudent(studentList.get(24));

        //CB9 C# FULL-TIME
        assignmentList.get(50).setTitle("Assignment 1");
        assignmentList.get(50).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(50).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(50).setOralMark(3);
        assignmentList.get(50).setTotalMark(10);
        assignmentList.get(50).setCourse(courseList.get(5));
        assignmentList.get(50).setStudent(studentList.get(25));
        assignmentList.get(51).setTitle("Project A");
        assignmentList.get(51).setDescription("JAVA");
        assignmentList.get(51).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(51).setOralMark(3);
        assignmentList.get(51).setTotalMark(10);
        assignmentList.get(51).setCourse(courseList.get(5));
        assignmentList.get(51).setStudent(studentList.get(25));

        assignmentList.get(52).setTitle("Assignment 1");
        assignmentList.get(52).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(52).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(52).setOralMark(3);
        assignmentList.get(52).setTotalMark(10);
        assignmentList.get(52).setCourse(courseList.get(5));
        assignmentList.get(52).setStudent(studentList.get(26));
        assignmentList.get(53).setTitle("Project A");
        assignmentList.get(53).setDescription("JAVA");
        assignmentList.get(53).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(53).setOralMark(3);
        assignmentList.get(53).setTotalMark(10);
        assignmentList.get(53).setCourse(courseList.get(5));
        assignmentList.get(53).setStudent(studentList.get(26));

        assignmentList.get(54).setTitle("Assignment 1");
        assignmentList.get(54).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(54).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(54).setOralMark(3);
        assignmentList.get(54).setTotalMark(10);
        assignmentList.get(54).setCourse(courseList.get(5));
        assignmentList.get(54).setStudent(studentList.get(27));
        assignmentList.get(55).setTitle("Project A");
        assignmentList.get(55).setDescription("JAVA");
        assignmentList.get(55).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(55).setOralMark(3);
        assignmentList.get(55).setTotalMark(10);
        assignmentList.get(55).setCourse(courseList.get(5));
        assignmentList.get(55).setStudent(studentList.get(27));

        assignmentList.get(56).setTitle("Assignment 1");
        assignmentList.get(56).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(56).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(56).setOralMark(3);
        assignmentList.get(56).setTotalMark(10);
        assignmentList.get(56).setCourse(courseList.get(5));
        assignmentList.get(56).setStudent(studentList.get(28));
        assignmentList.get(57).setTitle("Project A");
        assignmentList.get(57).setDescription("JAVA");
        assignmentList.get(57).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(57).setOralMark(3);
        assignmentList.get(57).setTotalMark(10);
        assignmentList.get(57).setCourse(courseList.get(5));
        assignmentList.get(57).setStudent(studentList.get(28));

        assignmentList.get(58).setTitle("Assignment 1");
        assignmentList.get(58).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(58).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(58).setOralMark(3);
        assignmentList.get(58).setTotalMark(10);
        assignmentList.get(58).setCourse(courseList.get(5));
        assignmentList.get(58).setStudent(studentList.get(29));
        assignmentList.get(59).setTitle("Project A");
        assignmentList.get(59).setDescription("JAVA");
        assignmentList.get(59).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(59).setOralMark(3);
        assignmentList.get(59).setTotalMark(10);
        assignmentList.get(59).setCourse(courseList.get(5));
        assignmentList.get(59).setStudent(studentList.get(29));

        //CB9 JAVA PART-TIME
        assignmentList.get(60).setTitle("Assignment 1");
        assignmentList.get(60).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(60).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(60).setOralMark(3);
        assignmentList.get(60).setTotalMark(10);
        assignmentList.get(60).setCourse(courseList.get(6));
        assignmentList.get(60).setStudent(studentList.get(30));
        assignmentList.get(61).setTitle("Project A");
        assignmentList.get(61).setDescription("JAVA");
        assignmentList.get(61).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(61).setOralMark(3);
        assignmentList.get(61).setTotalMark(10);
        assignmentList.get(61).setCourse(courseList.get(6));
        assignmentList.get(61).setStudent(studentList.get(30));

        assignmentList.get(62).setTitle("Assignment 1");
        assignmentList.get(62).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(62).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(62).setOralMark(3);
        assignmentList.get(62).setTotalMark(10);
        assignmentList.get(62).setCourse(courseList.get(6));
        assignmentList.get(62).setStudent(studentList.get(31));
        assignmentList.get(63).setTitle("Project A");
        assignmentList.get(63).setDescription("JAVA");
        assignmentList.get(63).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(63).setOralMark(3);
        assignmentList.get(63).setTotalMark(10);
        assignmentList.get(63).setCourse(courseList.get(6));
        assignmentList.get(63).setStudent(studentList.get(31));

        assignmentList.get(64).setTitle("Assignment 1");
        assignmentList.get(64).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(64).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(64).setOralMark(3);
        assignmentList.get(64).setTotalMark(10);
        assignmentList.get(64).setCourse(courseList.get(6));
        assignmentList.get(64).setStudent(studentList.get(32));
        assignmentList.get(65).setTitle("Project A");
        assignmentList.get(65).setDescription("JAVA");
        assignmentList.get(65).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(65).setOralMark(3);
        assignmentList.get(65).setTotalMark(10);
        assignmentList.get(65).setCourse(courseList.get(6));
        assignmentList.get(65).setStudent(studentList.get(32));

        assignmentList.get(66).setTitle("Assignment 1");
        assignmentList.get(66).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(66).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(66).setOralMark(3);
        assignmentList.get(66).setTotalMark(10);
        assignmentList.get(66).setCourse(courseList.get(6));
        assignmentList.get(66).setStudent(studentList.get(33));
        assignmentList.get(67).setTitle("Project A");
        assignmentList.get(67).setDescription("JAVA");
        assignmentList.get(67).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(67).setOralMark(3);
        assignmentList.get(67).setTotalMark(10);
        assignmentList.get(67).setCourse(courseList.get(6));
        assignmentList.get(67).setStudent(studentList.get(33));

        assignmentList.get(68).setTitle("Assignment 1");
        assignmentList.get(68).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(68).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(68).setOralMark(3);
        assignmentList.get(68).setTotalMark(10);
        assignmentList.get(68).setCourse(courseList.get(6));
        assignmentList.get(68).setStudent(studentList.get(34));
        assignmentList.get(69).setTitle("Project A");
        assignmentList.get(69).setDescription("JAVA");
        assignmentList.get(69).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(69).setOralMark(3);
        assignmentList.get(69).setTotalMark(10);
        assignmentList.get(69).setCourse(courseList.get(6));
        assignmentList.get(69).setStudent(studentList.get(34));

        //CB9 C# PART-TIME
        assignmentList.get(70).setTitle("Assignment 1");
        assignmentList.get(70).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(70).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(70).setOralMark(3);
        assignmentList.get(70).setTotalMark(10);
        assignmentList.get(70).setCourse(courseList.get(7));
        assignmentList.get(70).setStudent(studentList.get(35));
        assignmentList.get(71).setTitle("Project A");
        assignmentList.get(71).setDescription("JAVA");
        assignmentList.get(71).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(71).setOralMark(3);
        assignmentList.get(71).setTotalMark(10);
        assignmentList.get(71).setCourse(courseList.get(7));
        assignmentList.get(71).setStudent(studentList.get(35));

        assignmentList.get(72).setTitle("Assignment 1");
        assignmentList.get(72).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(72).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(72).setOralMark(3);
        assignmentList.get(72).setTotalMark(10);
        assignmentList.get(72).setCourse(courseList.get(7));
        assignmentList.get(72).setStudent(studentList.get(36));
        assignmentList.get(73).setTitle("Project A");
        assignmentList.get(73).setDescription("JAVA");
        assignmentList.get(73).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(73).setOralMark(3);
        assignmentList.get(73).setTotalMark(10);
        assignmentList.get(73).setCourse(courseList.get(7));
        assignmentList.get(73).setStudent(studentList.get(36));

        assignmentList.get(74).setTitle("Assignment 1");
        assignmentList.get(74).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(74).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(74).setOralMark(3);
        assignmentList.get(74).setTotalMark(10);
        assignmentList.get(74).setCourse(courseList.get(7));
        assignmentList.get(74).setStudent(studentList.get(37));
        assignmentList.get(75).setTitle("Project A");
        assignmentList.get(75).setDescription("JAVA");
        assignmentList.get(75).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(75).setOralMark(3);
        assignmentList.get(75).setTotalMark(10);
        assignmentList.get(75).setCourse(courseList.get(7));
        assignmentList.get(75).setStudent(studentList.get(37));

        assignmentList.get(76).setTitle("Assignment 1");
        assignmentList.get(76).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(76).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(76).setOralMark(3);
        assignmentList.get(76).setTotalMark(10);
        assignmentList.get(76).setCourse(courseList.get(7));
        assignmentList.get(76).setStudent(studentList.get(38));
        assignmentList.get(77).setTitle("Project A");
        assignmentList.get(77).setDescription("JAVA");
        assignmentList.get(77).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(77).setOralMark(3);
        assignmentList.get(77).setTotalMark(10);
        assignmentList.get(77).setCourse(courseList.get(7));
        assignmentList.get(77).setStudent(studentList.get(38));

        assignmentList.get(78).setTitle("Assignment 1");
        assignmentList.get(78).setDescription("HTML-CSS-JAVASCRIPT");
        assignmentList.get(78).setSubDateTime(LocalDate.of(2021, 02, 01));
        assignmentList.get(78).setOralMark(3);
        assignmentList.get(78).setTotalMark(10);
        assignmentList.get(78).setCourse(courseList.get(7));
        assignmentList.get(78).setStudent(studentList.get(39));
        assignmentList.get(79).setTitle("Project A");
        assignmentList.get(79).setDescription("JAVA");
        assignmentList.get(79).setSubDateTime(LocalDate.of(2021, 03, 01));
        assignmentList.get(79).setOralMark(3);
        assignmentList.get(79).setTotalMark(10);
        assignmentList.get(79).setCourse(courseList.get(7));
        assignmentList.get(79).setStudent(studentList.get(39));

        questionForNextAction(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
    }

    static void questionForNextAction(ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Student> studentList, ArrayList<Assignment> assignmentList, int iCourse, int iTrainer, int iStudent, int iAssignment, Scanner input) {
        System.out.println("");
        System.out.println("Πληκτρολογήστε τον αριθμό της ενέργειας με την οποία θέλετε να προχωρήσετε");
        System.out.println("1. Καταχώρηση εγγραφής με δικάς σας δεδομένα");
        System.out.println("2. Καταχώρηση εγγραφής με συνθετικά δεδομένα");
        System.out.println("3. Εκτύπωση καταχωρημένων εγγραφών");
        System.out.println("4. Καταχώρηση ημερομηνίας για εύρεση μαθητών που έχουν παράδοση εργασίας την αντίστοιχη εβδομάδα");
        System.out.println("5. Τερματισμός προγράμματος");
        int myInput;
        do {
            myInput = input.nextInt();
            if (myInput == 1) {
                input(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            } else if (myInput == 2) {
                syntheticData(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            } else if (myInput == 3) {
                output(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            } else if (myInput == 4) {
                findTheAssignmentsOfTheWeek(courseList, trainerList, studentList, assignmentList, iCourse, iTrainer, iStudent, iAssignment, input);
            } else if (myInput == 5) {
                System.exit(0);
            } else {
                System.out.println("Πληκτρολογήστε έναν αριθμό από το 1 έως το 5");
            }
        } while (!((myInput == 1) || (myInput == 2) || (myInput == 3) || (myInput == 4) || (myInput == 5)));
    }

    static String yesOrNoValidation(Scanner input) {
        String myInput = input.next();
        while ((myInput.equals("")) || ((!myInput.equals("Y")) && (!myInput.equals("N")))) {
            System.out.println("Πληκτρολογήστε Y for Yes / N for No");
            myInput = input.next();
        }
        return myInput;
    }
}

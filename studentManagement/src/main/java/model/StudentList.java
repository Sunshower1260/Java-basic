/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author HELLO
 */
public class StudentList {

    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentList() {}

    public StudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudentList(Student s) {
        studentList.add(s);
    }
    
    public void studentLoad() {
        String path = "students_input.txt";
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] details = line.split(", ");
                String id = details[0];
                String name = details[1];
                String dateOfBirth = details[2];
                String gender = details[3];
                String email = details[4];
                String phoneNumber = details[5];
                String fatherName = details[6];
                String motherName = details[7];
                String address = details[8];
                Student student = new Student(id, name, dateOfBirth, gender, email, phoneNumber, fatherName, motherName, address);
                addStudentList(student);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException i) {
            System.out.println("File not found");
        }
    }
    
    public void studentWrite() {
        File file = new File("students_input.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
                for (Student s : this.studentList) {
                    String content = s.getId()+ ", " + s.getName() + ", "
                            + s.getDateOfBirth() + ", " + s.getGender() + ", "
                            + s.getEmail() + ", " + s.getPhoneNumber() +  ", "
                            + s.getFatherName() + ", " + s.getMotherName() + ", "
                            + s.getAddress();
                    fileWriter.write(content + "\n");
                }
                fileWriter.close();
        } catch(FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException i) {
            System.out.println("Error writing to file");
        }
    }
    
    public void studentRemove(Student s) {
        studentList.remove(s);
    }
    
    public void studentUpdate(Student s) {
        for (Student student: studentList) {
            if (s.getId().equals(student.getId())) {
                int index = studentList.indexOf(student);
                studentList.set(index, s);
            }
        }
    }
    
}


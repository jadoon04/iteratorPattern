/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorpatterndemo;

/**
 *
 * @author hp
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

        System.out.println("Students with names starting from 'Muhammad':");
        studentRepository.printStudentsWithNameStartingFrom("Muhammad");

        System.out.println("\nAll students:");
        studentRepository.printAllStudents();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorpatterndemo;

import java.util.Arrays;
import java.util.Comparator;

public class StudentRepository implements Container {
    public Student[] students;

    public StudentRepository() {
        students = new Student[]{
                new Student("001", "Muhammad Ali", "Male", "1234567890"),
                new Student("002", "Muhammad Ahsan", "Male", "0987654321"),
                new Student("003", "Ahmed", "Male", "1122334455"),
                new Student("004", "Aisha", "Female", "2233445566")

        };
    }

    @Override
    public Iterator getIterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < students.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return students[index++];
            }
            return null;
        }

        public boolean hasPrevious() {
            if (index > 0) {
                return true;
            }
            return false;
        }

        public Object previous() {
            if (this.hasPrevious()) {
                return students[--index];
            }
            return null;
        }

        public void moveToLast() {
            index = students.length - 1;
        }

        public void moveToFirst() {
            index = 0;
        }
    }

    public void printStudentsWithNameStartingFrom(String startingValue) {
        StudentIterator iterator = (StudentIterator) getIterator();
        iterator.moveToLast();
        while (iterator.hasPrevious()) {
            Student student = (Student) iterator.previous();
            if (student.getName().startsWith(startingValue)) {
                System.out.println(student);
            }
        }
    }

    public void printAllStudents() {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        StudentIterator iterator = (StudentIterator) getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

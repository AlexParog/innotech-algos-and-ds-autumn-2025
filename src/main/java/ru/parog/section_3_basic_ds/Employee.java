package ru.parog.section_3_basic_ds;

public class Employee implements Comparable<Employee> {

    private int grade;

    public Employee(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.grade, o.grade);
    }
}

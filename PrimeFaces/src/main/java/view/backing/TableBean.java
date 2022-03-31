/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author user
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean
{

    private List<Student> students;

    /**
     * Creates a new instance of TableBean
     */
    public TableBean()
    {
        students = new ArrayList<>();
        students.add(new Student("Zych", "Antoni", 3.26));
        students.add(new Student("Kowalski", "Jerzy", 3.35));
        students.add(new Student("Kowalska", "Karolina", 4.43));
        students.add(new Student("Adamska", "Marta", 3.34));
        students.add(new Student("Kowal", "Piotr", 5.0));
        students.add(new Student("Kowal", "Anna", 4.4));

    }

    /**
     * @return the students
     */
    public List<Student> getStudents()
    {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

}

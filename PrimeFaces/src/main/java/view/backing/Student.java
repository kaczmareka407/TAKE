/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

/**
 *
 * @author user
 */
public class Student
{
 
    private String surname;
    private String name;
    private double average;

    public Student(String surname, String name, double average)
    {
        this.surname=surname;
        this.name=name;
        this.average=average;
    }
    /**
     * @return the surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the average
     */
    public double getAverage()
    {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(float average)
    {
        this.average = average;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean
{
    private int firstNumber;
    private int secondNumber;
    private int sumNumber;
    private Date date;
    

    

    /**
     * Creates a new instance of FormBean
     */
    public FormBean()
    {
        this.firstNumber=0;
        this.secondNumber=0;
        this.sumNumber=0;
        this.date = new Date();
    }

    /**
     * @return the firstNumber
     */
    public int getFirstNumber()
    {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber)
    {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber()
    {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber)
    {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the sumNumber
     */
    public int getSumNumber()
    {
        return sumNumber;
    }

    /**
     * @param sumNumber the sumNumber to set
     */
    public void setSumNumber(int sumNumber)
    {
        this.sumNumber = sumNumber;
    }
    
    public void calculate()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.renderResponse();
        setSumNumber(getFirstNumber()+getSecondNumber());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        (String.format("%d", sumNumber)));
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
}

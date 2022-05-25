/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import sun.util.resources.Bundles;

/**
 *
 * @author user
 */
@Named(value = "loginBean")
@RequestScoped

public class LoginBean
{

    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean()
    {
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }


    
    public String login()
    {
        if ("scott".equals(getUsername()) && ("tiger").equals(getPassword()))
        {

            FacesContext fc = FacesContext.getCurrentInstance();
            Locale locale = fc.getViewRoot().getLocale();
            //FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("pl"));
            fc.addMessage(null, new FacesMessage(ResourceBundle.getBundle("ApplicationMessages", locale).getString("validation.system")));
            //fc.addMessage(null, new FacesMessage(ResourceBundle.getBundle("ApplicationMessages_pl").getString("validation.system")));

            fc.renderResponse();
            return "";
        } else if (username.equals(password))
        {
            return "success";
        } else
        {
            return "failure";
        }
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox()
    {
        return acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton()
    {
        return loginButton;
    }

    public void activateButton(ValueChangeEvent e)
    {
        if (getAcceptCheckbox().isSelected())
        {
            getLoginButton().setDisabled(false);
        } else
        {
            getLoginButton().setDisabled(true);
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox)
    {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton)
    {
        this.loginButton = loginButton;
    }

}

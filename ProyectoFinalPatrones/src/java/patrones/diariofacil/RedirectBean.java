/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author miker.sb7
 */
@ManagedBean(name = "Redirect", eager = true)
@RequestScoped
public class RedirectBean {
    
     public String redirectToAdmiHome(){
        return "AdmiHome";
    }
     
      public String redirectToUserHome(){
        return "UserHome";
    }
      public String redirectToUpdateClient(){
        return "UpdateClient";
    }
    
    public String redirectToSignup(){
        return "Signup";
    }
      public String redirectToSignUpProvider(){
        return "SignUpProvider";
    }
    public String redirectToLogin(){
        return "Login";
    }
    
    public String redirectToProducts(){
        return "Products";
    }
    
    public String redirectToAddProducts(){
        return "faces/AddProduct";
    }
    
    

}

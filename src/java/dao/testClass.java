/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CommentBean;
import beans.MessageBean;
import beans.UserBean;
import java.util.ArrayList;

/**
 *
 * @author asimk
 */
public class testClass {
    public static void main(String[] args) {
   
        
        UserBean ub = new UserBean();
        ub.setEmail("kaymakasm@gmail.com");
        ub.setPassword("Kanarya10");
        ub.girisKontrol();
        ub.setPostContent("Sa");
        ub.postGonder();
        
        
    }
    
}

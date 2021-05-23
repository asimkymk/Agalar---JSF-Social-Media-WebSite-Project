/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.UserBean;

/**
 *
 * @author asimk
 */
public class testClass {
    public static void main(String[] args) {
        UserBean ub = new UserBean();
        ub.setUserId(2);
        ub.setAra("asd");
        ub.setEmail("emremre@gmail.com");
        ub.setPassword("Kanarya10");
        ub.girisKontrol();
        System.out.println(ub.getFollowerCount());
    }
    
}

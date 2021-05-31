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
   
        
        System.out.println(UserDAO.profilBilgiGuncelle(1,"asımedasdr", "kaymakoglu", "asimkymka", "allah allah neden oluyo acaba", "2021-05-31", "imgs/profilePictures/asimkymk.jpg", "imgs/coverPictures/asimkymk.jpg"));
    }
    
}

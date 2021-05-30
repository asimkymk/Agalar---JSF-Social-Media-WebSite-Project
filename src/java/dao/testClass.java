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
   
        
        CommentBean mb = new CommentBean();
        System.out.println(mb.yorumlariCek(46).size());
    }
    
}

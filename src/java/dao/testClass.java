/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.MessageBean;
import beans.UserBean;

/**
 *
 * @author asimk
 */
public class testClass {
    public static void main(String[] args) {
        /*
        UserBean ub = new UserBean();
        ub.setUserId(2);
        ub.setAra("asd");
        ub.setEmail("emremre@gmail.com");
        ub.setPassword("Kanarya10");
        ub.girisKontrol();*/
        for(int i = 0;i<MessagesDAO.getPrivateMessages(2, 1).size();i++){
            System.out.println(MessagesDAO.getPrivateMessages(2, 1).get(i).getSenderId());
            System.out.println(MessagesDAO.getPrivateMessages(2, 1).get(i).getReceiverId());
            System.out.println(MessagesDAO.getPrivateMessages(2, 1).get(i).getContent());
        }
        System.out.println(MessagesDAO.getPrivateMessages(2, 1).size());
        
        MessageBean mb = new MessageBean();
        //System.out.println(mb.mesajiGonder(2,);
    }
    
}

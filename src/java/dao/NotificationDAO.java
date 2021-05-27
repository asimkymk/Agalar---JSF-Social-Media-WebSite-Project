/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.NotificationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DataConnect;

/**
 *
 * @author Sirac
 */
public class NotificationDAO {
    
    public static ArrayList<NotificationBean> getNotifications(int userid){
       ArrayList<NotificationBean> bildirimler = new ArrayList<NotificationBean>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from NOTIFICATIONS where USERID = ?");       
                ps.setInt(1, userid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    bildirimler.add(new NotificationBean(rs.getInt("NOTIFICATIONID"),rs.getInt("USERID"),rs.getString("CONTENT")));
                }
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
       return bildirimler;
   }
    public static boolean addNotifications(int userid, String content){
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO NOTIFICATIONS (USERID,CONTENT) VALUES (?,?)");
            ps.setInt(1, userid);
            ps.setString(2, content);
            ps.executeUpdate();
            con.close(); 
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
    private int notificationId;
    private int userId;
    private String content;

    public NotificationDAO(int notificationId, int userId, String content) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.content = content;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public static ArrayList<NotificationDAO> getNotifications(int userid){
       ArrayList<NotificationDAO> bildirimler = new ArrayList<NotificationDAO>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from NOTIFICATIONS where USERID = ?");       
                ps.setInt(1, userid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    bildirimler.add(new NotificationDAO(rs.getInt("NOTIFICATIONID"),rs.getInt("USERID"),rs.getString("CONTENT")));
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

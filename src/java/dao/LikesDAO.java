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
import util.DataConnect;

/**
 *
 * @author asimk
 */
public class LikesDAO {
    public static boolean isLiked(int userId, int postId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from LIKES where USERID = ? and POSTID = ?");
                ps.setInt(1, userId);
                ps.setInt(2, postId);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    con.close();
                    return true;
                    
                }
        } catch (SQLException ex) {

                return false;
        }
        return false;
    }
    public static boolean Like(int userId, int postId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO LIKES (USERID,POSTID) VALUES (?,?)");
                ps.setInt(1, userId);
                ps.setInt(2, postId);
                ps.executeUpdate();
                con.close();
                return true;
        } catch (SQLException ex) {

                return false;
        }
    }
    public static boolean unLike(int userId, int postId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM LIKES WHERE USERID=? AND POSTID=?");
                ps.setInt(1, userId);
                ps.setInt(2, postId);
                ps.executeUpdate();
                con.close();
                return true;
        } catch (SQLException ex) {

                return false;
        }
    }
}

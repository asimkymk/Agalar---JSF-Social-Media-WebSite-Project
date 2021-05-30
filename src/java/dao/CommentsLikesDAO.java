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
public class CommentsLikesDAO {
    public static boolean isLiked(int userId, int commentId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from COMMENTLIKES where USERID = ? and COMMENTID = ?");
                ps.setInt(1, userId);
                ps.setInt(2, commentId);

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
    public static boolean Like(int userId, int commentId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO COMMENTLIKES (USERID,COMMENTID) VALUES (?,?)");
                ps.setInt(1, userId);
                ps.setInt(2, commentId);
                ps.executeUpdate();
                con.close();
                return true;
        } catch (SQLException ex) {

                return false;
        }
    }
    public static boolean unLike(int userId, int commentId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM COMMENTLIKES WHERE USERID=? AND COMMENTID=?");
                ps.setInt(1, userId);
                ps.setInt(2, commentId);
                ps.executeUpdate();
                con.close();
                return true;
        } catch (SQLException ex) {

                return false;
        }
    }
}

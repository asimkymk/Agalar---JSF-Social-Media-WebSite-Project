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
 * @author Sirac
 */
public class FollowersDAO {
    
    public static boolean isFollowing(int followerId, int followingId){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from FOLLOWERS where FOLLOWERID = ? and FOLLOWINGID = ?");
                ps.setInt(1, followerId);
                ps.setInt(2, followingId);

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
    
    
}

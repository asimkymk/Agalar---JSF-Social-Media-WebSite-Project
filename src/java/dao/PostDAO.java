/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.PostBean;
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
public class PostDAO {
    public static ArrayList<PostBean> getPosts(){
        ArrayList<PostBean> postlar = new ArrayList<PostBean>();
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from POSTS");
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    PostBean post = new PostBean(rs.getInt("POSTID"),rs.getInt("USERID"),rs.getString("CONTENT"),rs.getInt("LIKECOUNT"),rs.getInt("COMMENTCOUNT"),rs.getString("CREATEDATE"),rs.getString("PHOTOURL"),rs.getString("VIDEOURL"));
                    postlar.add(post);
                    DataConnect.close(con);
                }            
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
        }
        return postlar;
    }
    
}

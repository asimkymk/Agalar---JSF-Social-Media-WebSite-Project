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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                while(rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0,16);
                    String bugun = String.valueOf(new Timestamp(System.currentTimeMillis()));
                    if(tarih.substring(0,10).equals(bugun.substring(0,10))){
                        if(tarih.substring(11,13).equals(bugun.substring(11,13))){
                            tarih = String.valueOf(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16))) + " dk";
                        }
                        else{
                            if(Integer.valueOf(bugun.substring(11,13)) - Integer.valueOf(tarih.substring(11,13)) == 1){
                                
                                tarih = String.valueOf(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16)) + 60) + " dk";
                            }
                            else{
                                if(Integer.valueOf(bugun.substring(14,16)) > Integer.valueOf(tarih.substring(14,16))){
                                    tarih = String.valueOf(Integer.valueOf(bugun.substring(11,13)) - Integer.valueOf(tarih.substring(11,13))) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16))) + " dk";
                                }
                                else{
                                    if(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16)) == 0){
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11,13)) - Integer.valueOf(tarih.substring(11,13))) + " saat";
                                    }
                                    else{
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11,13)) - Integer.valueOf(tarih.substring(11,13)) - 1) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16)) + 60) + " dk";
                                    }
                                }
                            }
                        }
                    }
                    postlar.add(new PostBean(rs.getInt("USERID"),rs.getInt("POSTID"),rs.getString("CONTENT"),rs.getInt("LIKECOUNT"),rs.getInt("COMMENTCOUNT"),tarih,rs.getString("PHOTOURI"),rs.getString("VIDEOURI")));
                   
                }
                DataConnect.close(con);
                 
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
        }
        
        return postlar;
    }
    
}

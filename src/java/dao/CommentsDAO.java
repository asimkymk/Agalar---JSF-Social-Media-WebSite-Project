/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CommentBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.DataConnect;

/**
 *
 * @author Sirac
 */
public class CommentsDAO {
    
    
    
    
    
   public static ArrayList<CommentBean> getComments(int postid){
       ArrayList<CommentBean> commentlar = new ArrayList<CommentBean>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from COMMENTS where POSTID = ? ORDER BY CREATEDATE DESC");       
                ps.setInt(1, postid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0,16);
                    String bugun = String.valueOf(new Timestamp(System.currentTimeMillis()));
                    if(tarih.substring(0,10).equals(bugun.substring(0,10))){
                        if(tarih.substring(11,13).equals(bugun.substring(11,13))){
                            tarih = String.valueOf(Integer.valueOf(bugun.substring(14,16)) - Integer.valueOf(tarih.substring(14,16))) + " dk";
                        }
                        else{
                           if(Integer.valueOf(bugun.substring(11,13)) - Integer.valueOf(tarih.substring(11,13)) == 1 && Integer.valueOf(bugun.substring(14,16)) < Integer.valueOf(tarih.substring(14,16))){

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
                     String photouri = rs.getString("PHOTOURI");
                    if (photouri.equals("empty")){
                        photouri = null;
                    }
                    commentlar.add(new CommentBean(rs.getInt("COMMENTID"),rs.getInt("POSTID"),rs.getInt("USERID"),rs.getString("CONTENT"),rs.getInt("LIKECOUNT"),photouri,tarih));
                }
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
        return commentlar;
   }
}

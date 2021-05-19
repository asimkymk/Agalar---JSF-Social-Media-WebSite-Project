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
import java.sql.Timestamp;
import java.util.ArrayList;
import util.DataConnect;

/**
 *
 * @author Sirac
 */
public class CommentsDAO {
    
    private int commentId;
    private int postId;
    private int userId;
    private String content;
    private int likeCount;
    private String createDate;

    public CommentsDAO(int commentId, int postId, int userId, String content, int likeCount, String createDate) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.likeCount = likeCount;
        this.createDate = createDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    
    
   public static ArrayList<CommentsDAO> getComments(int postid){
       ArrayList<CommentsDAO> commentlar = new ArrayList<CommentsDAO>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from COMMENTS where POSTID = ?");       
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
                    commentlar.add(new CommentsDAO(rs.getInt("COMMENTID"),rs.getInt("POSTID"),rs.getInt("USERID"),rs.getString("CONTENT"),rs.getInt("LIKECOUNT"),tarih));
                }
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
        return commentlar;
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.PostBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import util.DataConnect;



/**
 *
 * @author asimk
 */
public class UserDAO {
    
    public static boolean girisYap(String email, String password){
       
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    DataConnect.close(con);
                    return true;
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return false;
        }
        return false;
    }
    
    public static String kayitOl(String email, String hashtag, String firstName,String lastName,String birthDate,String sex,String password,boolean isHidden){
       
        
        try {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.YYYY");
            LocalDateTime now = LocalDateTime.now();
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from USERS where EMAIL = ? or TAG = ?");
            ps.setString(1, email);
            ps.setString(2, hashtag);

            ResultSet rs = ps.executeQuery(); 

            if (rs.next()) {
                DataConnect.close(con);
                return "Mail veya kullanıcı adına ait bir hesap zaten var. Lütfen Giriş sayfasından giriş yapınız. Şifrenizi unuttuysanız Şifremi unuttum sayfasını kullanınız.";
            }
            else{
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                Connection con1 = DataConnect.getConnection();
                PreparedStatement ps1 = con.prepareStatement("INSERT INTO USERS (TAG, EMAIL, PASSWORD, FIRSTNAME, LASTNAME,BIRTHDATE,SEX,CREATEDATE,BIO,PROFILEPICTUREURI,COVERPICTUREURI,ISHIDDEN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                
                ps1.setString(1,hashtag);
                ps1.setString(2, email);
                ps1.setString(3, password);
                ps1.setString(4, firstName);
                ps1.setString(5, lastName);
                ps1.setString(6, birthDate);
                ps1.setString(7, sex);
                ps1.setString(8,dtf.format(now));
                ps1.setString(9, "");
                ps1.setString(10, "imgs/default_pp.jpg");
                ps1.setString(11, "imgs/default_cp.jpg");
                ps1.setBoolean(12,isHidden);
                
                ps1.executeUpdate();
                DataConnect.close(con);
                return "ok";
            }
            //buraya kayıt olsun 
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return ex.getMessage();
        }
        
    }
    
    public static int getUserId(String email, String password){
        
         try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select USERID from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getInt("USERID");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return -1;
        }
        return -1;
    }
    public static String getTag(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select TAG from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("TAG");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getFirstName(int userid){
        
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FIRSTNAME from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("FIRSTNAME");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getLastName(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select LASTNAME from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("LASTNAME");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getBirthDate(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select BIRTHDATE from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("BIRTHDATE");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getSex(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select SEX from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("SEX");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getCreateDate(int userid){
        
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select CREATEDATE from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("CREATEDATE");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getBio(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select BIO from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("BIO");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static int getFollowersCount(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FOLLOWERSCOUNT from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getInt("FOLLOWERSCOUNT");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return -1;
        }
        return -1;
    }
    public static int getFollowingCount(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FOLLOWINGSID from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getInt("FOLLOWINGSID");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return -1;
        }
        return -1;
    }
    public static String getProfilePictureUri(int userid){
        
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select PROFILEPICTUREURI from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("PROFILEPICTUREURI");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static String getCoverPictureUri(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select COVERPICTUREURI from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getString("COVERPICTUREURI");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return "";
        }
        return "";
    }
    public static boolean getIsHidden(int userid){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select ISHIDDEN from USERS where USERID = ?");
                ps.setInt(1, userid);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getBoolean("ISHIDDEN");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return false;
        }
        return false;
    }
    
    public static ArrayList<PostBean> postlariFiltrele(int followerId){
        ArrayList<PostBean> postlar1 = new ArrayList<PostBean>();
        for(int i = PostDAO.getPosts().size()-1;i >=0 ;i--){
            if(FollowersDAO.isFollowing(followerId, PostDAO.getPosts().get(i).getUserId()) || PostDAO.getPosts().get(i).getUserId() == followerId){
                
                postlar1.add(PostDAO.getPosts().get(i));
            }
        }
        return postlar1;
    }
    public static String postOlustur(int userid,String content,String photoUri, String videoUri){
         try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO POSTS (USERID,CONTENT,LIKECOUNT,COMMENTCOUNT,CREATEDATE,PHOTOURI,VIDEOURI) VALUES(?,?,0,0,?,?,?)");
                ps.setInt(1, userid);
                ps.setString(2,content);
                //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
                //LocalDateTime now = LocalDateTime.now();
               //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                ps.setString(4,photoUri);
                ps.setString(5,videoUri);


                ps.executeUpdate();
                DataConnect.close(con);
                return "ok";
        } catch (SQLException ex) {
                return ex.getMessage();
        }
        
    }
}

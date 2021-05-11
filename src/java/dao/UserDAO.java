/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static String getTag(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select TAG from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getFirstName(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FIRSTNAME from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getLastName(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select LASTNAME from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getBirthDate(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select BIRTHDATE from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getSex(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select SEX from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getCreateDate(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select CREATEDATE from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getBio(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select BIO from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static int getFollowersCount(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FOLLOWERSCOUNT from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static int getFollowingCount(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select FOLLOWINGSCOUNT from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    
                    return rs.getInt("FOLLOWINGSCOUNT");
                }
        } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return -1;
        }
        return -1;
    }
    public static String getProfilePictureUri(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select PROFILEPICTUREURI from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static String getCoverPictureUri(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select COVERPICTUREURI from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    public static boolean getIsHidden(String email,String password){
        
        try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select ISHIDDEN from USERS where EMAIL = ? and PASSWORD = ?");
                ps.setString(1, email);
                ps.setString(2, password);

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
    
}

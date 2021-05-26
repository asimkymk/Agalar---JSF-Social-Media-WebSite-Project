/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.MessageBean;
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
public class MessagesDAO {
    
    
    public static ArrayList<MessageBean> getPrivateMessages(int firstid, int secondid){
       ArrayList<MessageBean> messagelar = new ArrayList<MessageBean>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select DISTINCT * from MESSAGES where (SENDERID = ? and RECEIVERID = ?) or (SENDERID = ? and RECEIVERID = ?) ORDER BY CREATEDATE");       
                ps.setInt(1, firstid);
                ps.setInt(2, secondid);
                ps.setInt(3, secondid);
                ps.setInt(4, firstid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0,16);
                    messagelar.add(new MessageBean(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                }
                
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
       return messagelar;
   }
    public static boolean mesajlarArrController(ArrayList<MessageBean>mesajlar,int id){
        try{
            
            for(int i = 0;i<mesajlar.size();i++){
                if(mesajlar.get(i).getSenderId() == id || mesajlar.get(i).getReceiverId() == id){
                    return false;
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
   public static ArrayList<MessageBean>getDistinctMessage(int userId){
       
       ArrayList<MessageBean> messagelar = new ArrayList<MessageBean>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from MESSAGES where SENDERID = ? or RECEIVERID = ? ORDER BY CREATEDATE ASC");
                ps.setInt(1,userId);
                ps.setInt(2,userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0,16);
                    if(userId == rs.getInt("SENDERID")){
                        if(mesajlarArrController(messagelar,rs.getInt("RECEIVERID"))){
                            messagelar.add(new MessageBean(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                        }
                        else{
                            
                            int i = 0;
                            for(i =0;i<messagelar.size();i++){
                                if(messagelar.get(i).getSenderId() == rs.getInt("RECEIVERID") || messagelar.get(i).getReceiverId() == rs.getInt("RECEIVERID")){
                                    messagelar.set(i, new MessageBean(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                                    break;
                                }
                            }
                            
                        }
                    }
                    if(userId == rs.getInt("RECEIVERID")){
                        if(mesajlarArrController(messagelar,rs.getInt("SENDERID"))){
                            messagelar.add(new MessageBean(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                        }
                        else{
                            
                            int i = 0;
                            for(i =0;i<messagelar.size();i++){
                                if(messagelar.get(i).getSenderId() == rs.getInt("SENDERID") || messagelar.get(i).getReceiverId() == rs.getInt("SENDERID")){
                                    messagelar.set(i, new MessageBean(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                                    break;
                                }
                            }
                            
                        }
                    }
                
                }
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
       return messagelar;
   }
   public static String mesajGonder(int senderId,int receiverId, String content){
       try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO MESSAGES (SENDERID,RECEIVERID,CONTENT,CREATEDATE) VALUES(?,?,?,?)");
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setString(3, content);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
            //LocalDateTime now = LocalDateTime.now();
            //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

            ps.executeUpdate();
            DataConnect.close(con);
            return "ok";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
   }
}

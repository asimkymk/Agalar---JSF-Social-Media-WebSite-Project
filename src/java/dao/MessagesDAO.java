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
public class MessagesDAO {
    
    private int messageId;
    private int senderId;
    private int receiverId;
    private String content;
    private String createDate;

    public MessagesDAO(int messageId, int senderId, int receiverId, String content, String createDate) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.createDate = createDate;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    
    
    public static ArrayList<MessagesDAO> getPrivateMessages(int firstid, int secondid){
       ArrayList<MessagesDAO> messagelar = new ArrayList<MessagesDAO>();
       try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from COMMENTS where SENDERID = ? and RECEIVERID = ? or SENDERID = ? and RECEIVERID = ?");       
                ps.setInt(1, firstid);
                ps.setInt(2, secondid);
                ps.setInt(3, secondid);
                ps.setInt(4, firstid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0,16);
                    messagelar.add(new MessagesDAO(rs.getInt("MESSAGEID"),rs.getInt("SENDERID"),rs.getInt("RECEIVERID"),rs.getString("CONTENT"),tarih));
                }
                con.close(); 
        } catch (SQLException ex) {
            System.out.println("Listeleme hatası");
        }
       return messagelar;
   }
}

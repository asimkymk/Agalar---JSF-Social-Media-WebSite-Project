/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.MessagesDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asimk
 */
@ManagedBean(name = "messageBean")
@SessionScoped
public class MessageBean {
    

    private int messageId;
    private int senderId;
    private int receiverId;
    private String content;
    private String createDate;
    private String contentHata;

    public String getContentHata() {
        return contentHata;
    }

    public void setContentHata(String contentHata) {
        this.contentHata = contentHata;
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
    public MessageBean() {
    }

    public MessageBean(int messageId, int senderId, int receiverId, String content, String createDate) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.createDate = createDate;
    }
    public ArrayList<MessageBean> mesajAnaSayfaArr(int userid){
        ArrayList<MessageBean> dizi =  MessagesDAO.getDistinctMessage(userid);
        
        for(int i = 0;i<dizi.size();i++){
            for(int j = 0;j<dizi.size();j++){
                
                if(dizi.get(i).createDate.compareTo(dizi.get(j).createDate)>0){
                    MessageBean temp = dizi.get(i);
                    dizi.set(i,dizi.get(j));
                    dizi.set(j,temp);
                }
            }
        }
        return dizi;
    }
    public String mesajlariGosterSayfasi(int targetid){
        this.receiverId = targetid;
        return "messages_show_message?faces-redirect=trueuid="+targetid;
        
    }
    public ArrayList<MessageBean> chatEkrani(int userid,int targetid){
        return MessagesDAO.getPrivateMessages(userid, targetid);
    }
   
    public String mesajiGonder(int senderIdpost){
        
        
        
        /*int receiverIdpost = Integer.valueOf(url.split("uid=?")[0]);*/
        String durum = MessagesDAO.mesajGonder(senderIdpost, receiverId, this.content);
        
        if (durum.equals("ok")){
            
            
            this.contentHata= "";
            
        }
        else{
            this.contentHata = durum;
        }
        this.content = "";
        return "messages_show_message?faces-redirect=trueuid="+String.valueOf(receiverId);
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asimk
 */
@ManagedBean(name = "notificationBean")
@SessionScoped
public class NotificationBean {

    /**
     * Creates a new instance of NotificationBean
     */
    private int notificationId;
    private int userId;
    private String content;
    
    public NotificationBean() {
    }

    public NotificationBean(int notificationId, int userId, String content) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.content = content;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
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
    
}

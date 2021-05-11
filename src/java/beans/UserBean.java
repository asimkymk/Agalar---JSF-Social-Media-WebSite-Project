/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UserDAO;
import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.SessionUtils;

/**
 *
 * @author asimk
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    private static final long serialVersionUID = 1094801825228386363L;
    private boolean active = false;
    private String msg;
    private int userId;
    private String tag;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String sex;
    private String createDate;
    private String bio;
    private int followerCount;
    private int followingCount;
    private String profilePictureUri;
    private String coverPictureUri;
    private boolean isHidden;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public String getProfilePictureUri() {
        return profilePictureUri;
    }

    public void setProfilePictureUri(String profilePictureUri) {
        this.profilePictureUri = profilePictureUri;
    }

    public String getCoverPictureUri() {
        return coverPictureUri;
    }

    public void setCoverPictureUri(String coverPictureUri) {
        this.coverPictureUri = coverPictureUri;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
    
    
    public UserBean() {
    }
    
    public String girisKontrol(){
        boolean girisDurum = UserDAO.girisYap(this.email,this.password);
        if(girisDurum){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("email", email);
            this.active= false;
            return "home?faces-redirect=true";
        }
        else{
            this.active=true;
            this.msg="Hatalı mail veya şifre girişi yapıldı. Lütfen bilgileri kontrol ediniz.";
            return "login?faces-redirect=true";
        }
    }
    public String cikisYap(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
        
    }
    public void hataliMailFormatiGirisi(){
        this.active = true;
        this.msg="Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz.";
        
    }
    public void hataliMailFormatiGirisiKapat(){
        this.active = false;
        this.msg="";
        
    }
    
    
}

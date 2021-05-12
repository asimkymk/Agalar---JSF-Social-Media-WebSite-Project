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

/**
 *
 * @author asimk
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    private static final long serialVersionUID = 1094801825228386363L;
    private boolean active = false;
    private boolean activeRegister = false;
    private boolean activeSucRegister = false;
    private boolean isLogged = false;
    private String msg;
    private String msgSucRegister;
    private String msgRegister = "";
    private String msgRegister1 = "";
    private String msgRegister2 = "";
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

    public boolean isActiveSucRegister() {
        return activeSucRegister;
    }

    public void setActiveSucRegister(boolean activeSucRegister) {
        this.activeSucRegister = activeSucRegister;
    }

    public String getMsgSucRegister() {
        return msgSucRegister;
    }

    public void setMsgSucRegister(String msgSucRegister) {
        this.msgSucRegister = msgSucRegister;
    }

    public boolean isActiveRegister() {
        return activeRegister;
    }

    public void setActiveRegister(boolean activeRegister) {
        this.activeRegister = activeRegister;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public String getMsgRegister() {
        return msgRegister;
    }

    public void setMsgRegister(String msgRegister) {
        this.msgRegister = msgRegister;
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
            setIsLogged(true);
            this.active= false;
            this.msg = "";
            this.activeRegister = false;
            this.msgRegister = "";
            this.tag = UserDAO.getTag(this.email,this.password);
            this.userId = UserDAO.getUserId(email, password);
            this.firstName = UserDAO.getFirstName(email, password);
            this.lastName = UserDAO.getLastName(email, password);
            this.birthDate = UserDAO.getBirthDate(email, password);
            this.sex = UserDAO.getSex(email, password);
            this.followerCount = UserDAO.getFollowersCount(email, password);
            this.followingCount = UserDAO.getFollowingCount(email, password);
            this.profilePictureUri = UserDAO.getProfilePictureUri(email, password);
            this.coverPictureUri = UserDAO.getCoverPictureUri(email, password);
            this.isHidden = UserDAO.getIsHidden(email, password);
            this.activeSucRegister = false;
            this.msgSucRegister = null;
            return "home?faces-redirect=true";
        }
        else{
            setIsLogged(false);
            this.active=true;
            this.activeSucRegister = false;
            this.msgSucRegister = null;
            this.msg="Hatalı mail veya şifre girişi yapıldı. Lütfen bilgileri kontrol ediniz.";
            
            return "login?faces-redirect=true";
        }
    }
    
    public String kayitKontrol(){
        boolean kayitDurum = UserDAO.kayitOl(this.email,this.tag,this.firstName,this.lastName,this.birthDate,this.sex,this.password,this.isHidden);
        if(kayitDurum){
            setIsLogged(false);
            this.active= false;
            this.msg = "";
            this.activeRegister = false;
            this.msgRegister = "";
            this.tag = null;
            this.userId = -1;
            this.firstName = null;
            this.lastName = null;
            this.birthDate = null;
            this.sex = null;
            this.followerCount = -1;
            this.followingCount = -1;
            this.profilePictureUri = null;
            this.coverPictureUri = null;
            this.isHidden = false;
            this.activeSucRegister = true;
            this.msgSucRegister = "Başarılı bir şekilde kayıt olundu. Giriş yapabilirsiniz.";
            return "login?faces-redirect=true";
        }
        else{
            setIsLogged(false);
            this.activeRegister=true;
            this.msgRegister="Mail veya kullanıcı adına ait bir hesap zaten var. Lütfen Giriş sayfasından giriş yapınız. Şifrenizi unuttuysanız Şifremi unuttum sayfasını kullanınız.";
            
            return "register?faces-redirect=true";
        }
    }
   

    public String cikisYap(){
        
        return "login?faces-redirect=true";
        
    }

    public String getMsgRegister1() {
        return msgRegister1;
    }

    public void setMsgRegister1(String msgRegister1) {
        this.msgRegister1 = msgRegister1;
    }

    public String getMsgRegister2() {
        return msgRegister2;
    }

    public void setMsgRegister2(String msgRegister2) {
        this.msgRegister2 = msgRegister2;
    }
    public void hataliMailFormatiGirisi(){
        this.active = true;
        this.msg="Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz.";
        
    }
    public void hataliMailFormatiGirisiRegister(){
        this.activeRegister = true;
        this.msgRegister="Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz.";
        
    }
    public void hataliBirthDateGrisiRegister(){
        this.activeRegister = true;
        this.msgRegister1 ="Doğum tarihi uygun formatta değil. (GG.AA.YYYY).";
        
    }
    public void hataliParolaUzunluguRegister(){
        this.activeRegister = true;
        this.msgRegister2 ="Parolanızın uzunluğu en az 8 en fazla 20 karakter olmalıdır.";
        
    }
    
    
}

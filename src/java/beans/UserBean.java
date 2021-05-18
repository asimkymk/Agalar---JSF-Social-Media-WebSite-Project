/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.LikesDAO;
import dao.UserDAO;
import java.io.Serializable;
import java.util.ArrayList;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.DataConnect;

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
    private String postContent;
    private String postPhotoUri="empty";
    private String postVideoUri="empty";
    private String postHata;
    
    public String getPostHata() {
        return postHata;
    }

    public void setPostHata(String postHata) {
        this.postHata = postHata;
    }
    
    public String getPostPhotoUri() {
        return postPhotoUri;
    }

    public void setPostPhotoUri(String postPhotoUri) {
        this.postPhotoUri = postPhotoUri;
    }

    public String getPostVideoUri() {
        return postVideoUri;
    }

    public void setPostVideoUri(String postVideoUri) {
        this.postVideoUri = postVideoUri;
    }
    
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    

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
            this.userId = UserDAO.getUserId(email, password);
            this.tag = UserDAO.getTag(this.userId);
            
            this.firstName = UserDAO.getFirstName(this.userId);
            this.lastName = UserDAO.getLastName(this.userId);
            this.birthDate = UserDAO.getBirthDate(this.userId);
            this.sex = UserDAO.getSex(this.userId);
            this.followerCount = UserDAO.getFollowersCount(this.userId);
            this.followingCount = UserDAO.getFollowingCount(this.userId);
            this.profilePictureUri = UserDAO.getProfilePictureUri(this.userId);
            this.coverPictureUri = UserDAO.getCoverPictureUri(this.userId);
            this.isHidden = UserDAO.getIsHidden(this.userId);
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
        String kayitDurum = UserDAO.kayitOl(this.email,this.tag,this.firstName,this.lastName,this.birthDate,this.sex,this.password,this.isHidden);
        if(kayitDurum.equals("ok")){
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
            //this.msgRegister="";
            this.msgRegister= kayitDurum;
            
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
    public ArrayList<PostBean> postlariGoster(){
        return UserDAO.postlariFiltrele(this.userId);
    }
    public String postUserPictureUri(int userid){
        return UserDAO.getProfilePictureUri(userid);
        
    }
    public String postUserFirstName(int userid){
        return UserDAO.getFirstName(userid);
        
    }
    public String postUserLastName(int userid){
        return UserDAO.getLastName(userid);
        
    }
    public String postUserTag(int userid){
        return UserDAO.getTag(userid);
        
    }
    public String postGonder(){
        
        String durum = UserDAO.postOlustur(this.userId, this.postContent, this.postPhotoUri, this.postVideoUri);
        if (durum.equals("ok")){
            
            this.postContent ="";
            this.postPhotoUri = "empty";
            this.postVideoUri = "empty";
            this.postHata = "";
        }
        else{
            this.postHata = durum;
        }
        return "home.xhtml?faces-redirect=true";
        
    }
    public String gonderiyiBegen(int postId,int activeLikeNumber){
        
        UserDAO.LikeCountArtir(this.userId, postId, activeLikeNumber);
        return "home.xhtml?faces-redirect=true";
        
    }
    public String gonderiyiBegenme(int postId,int activeLikeNumber){
        
        UserDAO.LikeCountAzalt(this.userId, postId, activeLikeNumber);
        return "home.xhtml?faces-redirect=true";
        
    }
    public int gonderiyiBegenmisMi(int postId){
        if (LikesDAO.isLiked(userId, postId)) return 1;
        else return -1;
    }
    public int gonderiyiBegenmemisMi(int postId){
        if(LikesDAO.isLiked(userId, postId))return -1;
        else return 1;
    }
    
}

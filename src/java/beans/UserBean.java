/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CommentsLikesDAO;
import dao.FollowersDAO;
import dao.LikesDAO;
import dao.NotificationDAO;
import dao.PostDAO;
import dao.SavesDAO;
import dao.UserDAO;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author asimk
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

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
    private String postPhotoUri = "empty";
    private String postHata;
    private String ara;
    private int lookId;
    private int postLookId;
    private Part doc = null;
    private Part profileDoc = null;
    private Part coverDoc = null;
    private String profileDocHata;
    private String coverDocHata;
    private final String uploadTo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    private String activePassword;
    private String newPassword;
    private String newPasswordAgain;
    private String sifreHata;
    private int SifreDurum;
    public int getLookId() {
        return lookId;
    }

    public String getActivePassword() {
        return activePassword;
    }

    public String getSifreHata() {
        return sifreHata;
    }

    public void setSifreHata(String sifreHata) {
        this.sifreHata = sifreHata;
    }

    public int getSifreDurum() {
        return SifreDurum;
    }

    public void setSifreDurum(int SifreDurum) {
        this.SifreDurum = SifreDurum;
    }

    public void setActivePassword(String activePassword) {
        this.activePassword = activePassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public String getProfileDocHata() {
        return profileDocHata;
    }

    public void setProfileDocHata(String profileDocHata) {
        this.profileDocHata = profileDocHata;
    }

    public String getCoverDocHata() {
        return coverDocHata;
    }

    public void setCoverDocHata(String coverDocHata) {
        this.coverDocHata = coverDocHata;
    }

    public int getPostLookId() {
        return postLookId;
    }

    public void setPostLookId(int postLookId) {
        this.postLookId = postLookId;
    }

    public Part getProfileDoc() {
        return profileDoc;
    }

    public void setProfileDoc(Part profileDoc) {
        this.profileDoc = profileDoc;
    }

    public Part getCoverDoc() {
        return coverDoc;
    }

    public void setCoverDoc(Part coverDoc) {
        this.coverDoc = coverDoc;
    }
    
    public String getUploadTo() {
        return uploadTo;
    }

    public void setLookId(int lookId) {
        this.lookId = lookId;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getAra() {
        return ara;
    }

    public void setAra(String ara) {
        this.ara = ara;
    }

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

    public String girisKontrol() {
        boolean girisDurum = UserDAO.girisYap(this.email, this.password);
        if (girisDurum) {
            setIsLogged(true);
            this.active = false;
            this.msg = null;
            this.activeRegister = false;
            this.msgRegister = "";
            this.userId = UserDAO.getUserId(email, password);
            this.tag = UserDAO.getTag(this.userId);
            this.bio = UserDAO.getBio(this.userId);
            this.firstName = UserDAO.getFirstName(this.userId);
            this.lastName = UserDAO.getLastName(this.userId);
            this.birthDate = UserDAO.getBirthDate(this.userId);
            this.sex = UserDAO.getSex(this.userId);
            this.followerCount = UserDAO.getFollowersCount(this.userId);
            this.followingCount = UserDAO.getFollowingCount(this.userId);
            this.profilePictureUri = UserDAO.getProfilePictureUri(this.userId);
            this.coverPictureUri = UserDAO.getCoverPictureUri(this.userId);
            this.createDate = UserDAO.getCreateDate(this.userId);
            this.isHidden = UserDAO.getIsHidden(this.userId);
            this.activeSucRegister = false;
            this.msgSucRegister = null;
            this.ara = null;
            return "home?faces-redirect=true";
        } else {
            setIsLogged(false);
            this.active = true;
            this.activeSucRegister = false;
            this.msgSucRegister = null;
            this.msg = "Hatalı mail veya şifre girişi yapıldı. Lütfen bilgileri kontrol ediniz.";

            return "login?faces-redirect=true";
        }
    }
    public String cikisYap() {
       
        
        this.isLogged = false;  
        this.active = false;
        this.msg = null;
        this.activeRegister = false;
        this.msgRegister = "";
        this.userId = 0;
        this.tag = null;
        this.bio = null;
        this.firstName = null;
        this.lastName = null;
        this.birthDate = null;
        this.sex = null;
        this.followerCount = 0;
        this.followingCount = 0;
        this.profilePictureUri = null;
        this.coverPictureUri = null;
        this.createDate = null;
        this.isHidden = false;
        this.activeSucRegister = false;
        this.msgSucRegister = null;
        return "login?faces-redirect=true";
        
    }

    public String kayitKontrol() {
        String kayitDurum = UserDAO.kayitOl(this.email, this.tag, this.firstName, this.lastName, this.birthDate, this.sex, this.password, this.isHidden);
        if (kayitDurum.equals("ok")) {
            setIsLogged(false);
            this.active = false;
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
            this.bildirimGonder(this.userId, "Hesabını başarıyla oluşturdun. Artık Agamla hesabın var.");
            return "login?faces-redirect=true";
        } else {
            setIsLogged(false);
            this.activeRegister = true;
            //this.msgRegister="";
            this.msgRegister = kayitDurum;

            return "register?faces-redirect=true";
        }
    }
    public String sifremiUnuttum() {
        String kayitDurum = UserDAO.sifreUnuttum(email, tag);
        if (!kayitDurum.equals("hata")) {
            setIsLogged(false);
            this.active = false;
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
            this.msgSucRegister = "Şifreniz bulundu. Lütfen şifrenizi değiştirmeyi unutmayın. Şifre : " + kayitDurum;
            return "login?faces-redirect=true";
        } else {
            setIsLogged(false);
            this.activeRegister = true;
            //this.msgRegister="";
            this.msgRegister = "Eşleşmeyen bilgiler girildi. Lütfen gerekli bilgileri tekrar kontrol ediniz.";

            return "forgot_password?faces-redirect=true";
        }
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

    public void hataliMailFormatiGirisi() {
        this.active = true;
        this.msg = "Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz.";

    }

    public void hataliMailFormatiGirisiRegister() {
        this.activeRegister = true;
        this.msgRegister = "Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz.";

    }

    public void hataliBirthDateGrisiRegister() {
        this.activeRegister = true;
        this.msgRegister1 = "Doğum tarihi uygun formatta değil. (GG.AA.YYYY).";

    }

    public void hataliParolaUzunluguRegister() {
        this.activeRegister = true;
        this.msgRegister2 = "Parolanızın uzunluğu en az 8 en fazla 20 karakter olmalıdır.";

    }

    public ArrayList<PostBean> postlariGoster() {
        return PostDAO.homeSayfasiPostlariGetir(this.userId);
    }

    public ArrayList<PostBean> kendipostlarimiGoster() {
        return UserDAO.postlariFiltreleUser(this.userId);
    }

    public ArrayList<PostBean> profilSayfasiPostlariGoster() {
        return UserDAO.postlariFiltreleUser(this.lookId);
    }

    public String postUserPictureUri(int userid) {
        return UserDAO.getProfilePictureUri(userid);

    }

    public String postUserCoverUri(int userid) {
        return UserDAO.getCoverPictureUri(userid);

    }

    public int postUserFollowerCount(int userid) {
        return UserDAO.getFollowersCount(userid);

    }

    public int postUserFollowingCount(int userid) {
        return UserDAO.getFollowingCount(userid);

    }

    public String postUserFirstName(int userid) {
        return UserDAO.getFirstName(userid);

    }

    public String postUserBio(int userid) {
        return UserDAO.getBio(userid);

    }

    public String postUserCreateDate(int userid) {
        return UserDAO.getCreateDate(userid);

    }

    public String postUserBirthDate(int userid) {
        return UserDAO.getBirthDate(userid);

    }
    public String postUserSex(int userid) {
        return UserDAO.getSex(userid);

    }

    public String postUserLastName(int userid) {
        return UserDAO.getLastName(userid);

    }

    public boolean postUserisHidden(int userid) {
        return UserDAO.getIsHidden(userid);

    }

    public String postUserTag(int userid) {
        return UserDAO.getTag(userid);

    }

    public String profilSayfasiGoster(int id) {
        if (id == this.userId) {
            return "profile?faces-redirect=true";
        } else {
            this.lookId = id;
            return "profiles_show_profile?faces-redirect=true";
        }

    }

  

    public String postGonder() {
        try {
             if(this.doc.getInputStream() == null || this.doc.getSubmittedFileName() == null || this.doc.getSubmittedFileName().equals("")){
                 this.postPhotoUri = "empty";
            }
            else{
                InputStream input = doc.getInputStream();
                if(doc.getSubmittedFileName().endsWith(".png") || doc.getSubmittedFileName().endsWith("gif") || doc.getSubmittedFileName().endsWith("jpeg") || doc.getSubmittedFileName().endsWith("jpg") ||doc.getSubmittedFileName().endsWith("svg")){
                    Random rand = new Random();
                    String dosyaIsmi = this.tag + "_" + String.valueOf(this.userId) + "_" + String.valueOf(rand.nextInt(9999999)) + "_"+doc.getSubmittedFileName();
                    this.postPhotoUri = uploadTo +"imgs/postPictures/" + dosyaIsmi;

                    File f = new File(this.postPhotoUri);
                    Files.copy(input, f.toPath());
                    this.postPhotoUri = uploadTo +"../../web/imgs/postPictures/" + dosyaIsmi;
                    File f1 = new File(this.postPhotoUri);
                    Files.copy(f.toPath(), f1.toPath());
                    this.postPhotoUri ="imgs/postPictures/" + dosyaIsmi;
                }
                else{
                    this.postPhotoUri = "empty";
                    this.postHata = "Dosya yüklemede sadece resim uzantıları yükleyebilirsiniz.";
                    return "home.xhtml?faces-redirect=true";
                }
                
            }
            String durum = UserDAO.postOlustur(this.userId, this.postContent, this.postPhotoUri);
            if (durum.equals("ok")) {

                this.postContent = "";
                this.postPhotoUri = "empty";
                this.postHata = "";
                this.doc = null;
            } else {
                this.postHata = durum;
            }
            return "home.xhtml?faces-redirect=true";
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return "home.xhtml?faces-redirect=true";

    }

    public String gonderiyiBegen(int postId, int targetId) {

        UserDAO.LikeCountArtir(this.userId, postId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        if (targetId != this.userId) {
            this.bildirimGonder(targetId, "@" + this.tag + ", gönderini beğendi.");
        }
        return url + "?faces-redirect=true";

    }

    public String gonderiyiBegenme(int postId) {

        UserDAO.LikeCountAzalt(this.userId, postId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";
    }

    public int gonderiyiBegenmisMi(int postId) {
        if (LikesDAO.isLiked(userId, postId)) {
            return 1;
        } else {
            return -1;
        }
    }

    public int gonderiyiBegenmemisMi(int postId) {
        if (LikesDAO.isLiked(userId, postId)) {
            return -1;
        } else {
            return 1;
        }
    }

    public ArrayList<UserBean> kullaniciAra() {
        return UserDAO.kullaniciyiAra(userId, this.ara);

    }

    public ArrayList<PostBean> postAra() {
        ArrayList<UserBean> userids = UserDAO.kullaniciyiAra(userId, this.ara);
        ArrayList<Integer> uids = new ArrayList<Integer>();
        for (int i = 0; i < userids.size(); i++) {
            if (!userids.get(i).isHidden) {
                uids.add(userids.get(i).getUserId());
            }
        }
        ArrayList<PostBean> posts = UserDAO.postuAra(this.userId, this.ara, uids);
        ArrayList<PostBean> postlar = new ArrayList<PostBean>();
        if(posts.size() == 0) return null;
        for (int i = 0; i < posts.size(); i++) {
            postlar.add(posts.get(i));
        }
        return postlar;

    }

    public String aramaYap() {

        return "search.xhtml?faces-redirect=true";
    }

    public boolean takiplesiyorMu(int searchId) {
        return FollowersDAO.isFollowing(userId, searchId);

    }

    public ArrayList<PostBean> kaydedilenPostlariListele() {
        return SavesDAO.getSavedPosts(this.userId);
    }

    public int gonderiyiKaydetmisMi(int postId) {

        if (SavesDAO.isSaved(userId, postId)) {
            return 1;
        } else {
            return -1;
        }
    }

    public int gonderiyiKaydetmemisMi(int postId) {
        if (SavesDAO.isSaved(userId, postId)) {
            return -1;
        } else {
            return 1;
        }
    }

    public String gonderiyiKaydet(int postId) {

        UserDAO.postKaydet(this.userId, postId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";
    }

    public String gonderiyiKaydetme(int postId) {

        UserDAO.postKaydetme(this.userId, postId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";
    }

    public String takipEt(int followingId, int followerCount, int targetId) {

        boolean durum = FollowersDAO.Follow(this.userId, followingId, this.followingCount, followerCount);
        if (durum) {
            this.bildirimGonder(targetId, "@" + this.tag + ", seni takip etmeye başladı.");
            this.followingCount++;
        }
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";

    }

    public String takipEtme(int followingId, int followerCount) {

        boolean durum = FollowersDAO.unFollow(this.userId, followingId, this.followingCount, followerCount);
        if (durum) {
            this.followingCount--;
        }
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";
    }

    public ArrayList<NotificationBean> bildirimleriGoster(int userid) {
        ArrayList<NotificationBean> bildirimler = NotificationDAO.getNotifications(userid);

        return bildirimler;
    }

    public void bildirimGonder(int userid, String content) {
        boolean durum = NotificationDAO.addNotifications(userid, content);
        if (durum) {
            System.out.println("bildirim gonderildi");
        }
    }
    public String postGoster(int postid){
        this.postLookId = postid;
        return "post?faces-redirect=true";
    }
     public PostBean postGosterAnaPost(){
        return PostDAO.getPost(this.postLookId);
    }
     public String yorumuBegen(int commentId, int targetId) {

        UserDAO.yorumLikeCountArtir(this.userId, commentId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        if (targetId != this.userId) {
            this.bildirimGonder(targetId, "@" + this.tag + ", yorumunu beğendi.");
        }
        return url + "?faces-redirect=true";

    }

    public String yorumuBegenme(int commentId) {

        UserDAO.yorumLikeCountAzalt(this.userId, commentId);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url + "?faces-redirect=true";
    }

    public int yorumuBegenmisMi(int commentId) {
        if (CommentsLikesDAO.isLiked(userId, commentId)) {
            return 1;
        } else {
            return -1;
        }
    }

    public int yorumuBegenmemisMi(int commentId) {
        if (CommentsLikesDAO.isLiked(userId, commentId)) {
            return -1;
        } else {
            return 1;
        }
    }
    public boolean profilFotosunuGuncelle(){
        try{
            if(this.profileDoc.getInputStream() == null || this.profileDoc.getSubmittedFileName() == null || this.profileDoc.getSubmittedFileName().equals("")){
                 return true;
            }
            else{
                InputStream input = profileDoc.getInputStream();
                if(profileDoc.getSubmittedFileName().endsWith(".png") || profileDoc.getSubmittedFileName().endsWith("gif") || profileDoc.getSubmittedFileName().endsWith("jpeg") || profileDoc.getSubmittedFileName().endsWith("jpg") ||profileDoc.getSubmittedFileName().endsWith("svg")){
                    Random rand = new Random();
                    String dosyaIsmi = this.tag + "_" + String.valueOf(this.userId) + "_" + String.valueOf(rand.nextInt(9999999)) + "_"+profileDoc.getSubmittedFileName();
                    this.profilePictureUri = uploadTo +"imgs/profilePictures/" + dosyaIsmi;

                    File f = new File(this.profilePictureUri);
                    Files.copy(input, f.toPath());
                    this.profilePictureUri = uploadTo +"../../web/imgs/profilePictures/" + dosyaIsmi;
                    File f1 = new File(this.profilePictureUri);
                    Files.copy(f.toPath(), f1.toPath());
                    this.profilePictureUri ="imgs/profilePictures/" + dosyaIsmi;
                    this.profileDocHata = null;
                    return true;
                }else{
                    this.profileDocHata = "Profil fotoğrafı dosyayası yüklerken sadece resim uzantıları yükleyebilirsiniz.";
                    return false;
                }
            }
        }
        catch(Exception e){
            this.profileDocHata = e.getMessage();
            return false;
        }
        
        
    }
    public boolean coverFotosunuGuncelle(){
        try{
            if(this.coverDoc.getInputStream() == null || this.coverDoc.getSubmittedFileName() == null || this.coverDoc.getSubmittedFileName().equals("")){
                 return true;
            }
            else{
                InputStream input = coverDoc.getInputStream();
                if(coverDoc.getSubmittedFileName().endsWith(".png") || coverDoc.getSubmittedFileName().endsWith("gif") || coverDoc.getSubmittedFileName().endsWith("jpeg") || coverDoc.getSubmittedFileName().endsWith("jpg") ||coverDoc.getSubmittedFileName().endsWith("svg")){
                    Random rand = new Random();
                    String dosyaIsmi = this.tag + "_" + String.valueOf(this.userId) + "_" + String.valueOf(rand.nextInt(9999999)) + "_"+coverDoc.getSubmittedFileName();
                    this.coverPictureUri = uploadTo +"imgs/coverPictures/" + dosyaIsmi;

                    File f = new File(this.coverPictureUri);
                    Files.copy(input, f.toPath());
                    this.coverPictureUri = uploadTo +"../../web/imgs/coverPictures/" + dosyaIsmi;
                    File f1 = new File(this.coverPictureUri);
                    Files.copy(f.toPath(), f1.toPath());
                    this.coverPictureUri ="imgs/coverPictures/" + dosyaIsmi;
                    this.coverDocHata = null;
                    return true;
                }else{
                    
                    this.coverDocHata = "Kapak fotoğrafı dosyası yüklerken sadece resim uzantıları yükleyebilirsiniz.";
                    return false;
                }
            }
        }
        catch(Exception e){
             this.coverDocHata = e.getMessage();
            return false;
        }
        
    }
    public String bilgileriGuncelle(){
        
        
        try{
           if(coverFotosunuGuncelle() && profilFotosunuGuncelle()){
               String durum = UserDAO.profilBilgiGuncelle(this.userId,this.firstName,this.lastName,this.tag,this.bio,this.birthDate,this.profilePictureUri,this.coverPictureUri,this.isHidden);
               if(durum.equals("ok")){
                   this.active = false;
                    this.msg = null;
                    this.profileDocHata = null;
                    this.coverDocHata = null;
                   return "profile?faces-redirect=true";
               }
               else{
                   this.active = false;
                    this.msg = null;
                    this.activeRegister = false;
                    this.msgRegister = "";
                    this.userId = UserDAO.getUserId(email, password);
                    this.tag = UserDAO.getTag(this.userId);
                    this.bio = UserDAO.getBio(this.userId);
                    this.firstName = UserDAO.getFirstName(this.userId);
                    this.lastName = UserDAO.getLastName(this.userId);
                    this.birthDate = UserDAO.getBirthDate(this.userId);
                    this.sex = UserDAO.getSex(this.userId);
                    this.followerCount = UserDAO.getFollowersCount(this.userId);
                    this.followingCount = UserDAO.getFollowingCount(this.userId);
                    this.profilePictureUri = UserDAO.getProfilePictureUri(this.userId);
                    this.coverPictureUri = UserDAO.getCoverPictureUri(this.userId);
                    this.createDate = UserDAO.getCreateDate(this.userId);
                    this.isHidden = UserDAO.getIsHidden(this.userId);
                    this.activeSucRegister = false;
                    this.msgSucRegister = null;
                    this.profileDocHata = "Database güncelleme hatası. Lütfen bilgileri kontrol ederek daha sonra tekrar dene!";
                   return "settings.xhtml?faces-redirect=true";
               }
           }
           else{
                this.active = false;
                    this.msg = null;
                    this.activeRegister = false;
                    this.msgRegister = "";
                    this.userId = UserDAO.getUserId(email, password);
                    this.tag = UserDAO.getTag(this.userId);
                    this.bio = UserDAO.getBio(this.userId);
                    this.firstName = UserDAO.getFirstName(this.userId);
                    this.lastName = UserDAO.getLastName(this.userId);
                    this.birthDate = UserDAO.getBirthDate(this.userId);
                    this.sex = UserDAO.getSex(this.userId);
                    this.followerCount = UserDAO.getFollowersCount(this.userId);
                    this.followingCount = UserDAO.getFollowingCount(this.userId);
                    this.profilePictureUri = UserDAO.getProfilePictureUri(this.userId);
                    this.coverPictureUri = UserDAO.getCoverPictureUri(this.userId);
                    this.createDate = UserDAO.getCreateDate(this.userId);
                    this.isHidden = UserDAO.getIsHidden(this.userId);
                    this.activeSucRegister = false;
                    this.msgSucRegister = null;
                    this.profileDocHata = "hata";
                     return "settings.xhtml?faces-redirect=true";
           }
        }
        catch(Exception e){
            return "settings.xhtml?faces-redirect=true";
        }
        
    }
    public void hataliMailFormatiGirisiSettings() {
        this.active = true;
        this.msg = "Hatalı mail formatı girdiniz. Lütfen mail adresini kontrol ediniz. (GG.AA.YYYY).";

    }
    public String sifreyiGuncelle(){
        if(activePassword.equals(this.password)){
            if(newPassword.length()<= 20 && newPassword.length()>=8){
                this.SifreDurum = -1;
                this.sifreHata = "Şifreniz 8 veya 20 karakter uzunluğu aralığında olmalıdır.";
            }
            else if(newPasswordAgain.length()<= 20 && newPasswordAgain.length()>=8){
                this.SifreDurum = -1;
                this.sifreHata = "Şifreniz 8 veya 20 karakter uzunluğu aralığında olmalıdır.";
            }
            else if(newPassword.equals(this.newPasswordAgain)){
                String durum = UserDAO.profilSifreGuncelle(userId, newPassword);
                if(durum.equals("ok")){
                    this.SifreDurum = 1;
                    this.sifreHata = "Şifreniz başarıyla güncellendi!";
                   
                }
                else{
                    this.SifreDurum = -1;
                    this.sifreHata = "Database bağlantısın bir problem oldu. Lütfen daha sonra tekrar dene!";
                }
            }
            else{
                    this.SifreDurum = -1;
                    this.sifreHata = "Yeni şifrelerin birbiriyle aynı değil.";
                }
        }
        else{
           
                    this.SifreDurum = -1;
                    this.sifreHata = "Mevcut şifreni kontrol ederek tekrar yaz.";
        }
        
         return "settings.xhtml?faces-redirect=true";
        
        
    }
}

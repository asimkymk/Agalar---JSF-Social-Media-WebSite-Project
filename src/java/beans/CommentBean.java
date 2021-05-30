/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CommentsDAO;
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
@ManagedBean(name = "commentBean")
@SessionScoped
public class CommentBean implements Serializable {

    /**
     * Creates a new instance of CommentBean
     */
    private int commentId;
    private int postId;
    private int userId;
    private String content;
    private int likeCount;
    private String photoUri = "empty";
    private Part doc;
    private final String uploadTo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    private String postHata;
    
    public String getPhotoUri() {
        return photoUri;
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public String getPostHata() {
        return postHata;
    }

    public void setPostHata(String postHata) {
        this.postHata = postHata;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }
    private String createDate;
    

    public CommentBean() {
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    

    public CommentBean(int commentId, int postId, int userId, String content, int likeCount, String photoUri, String createDate) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.likeCount = likeCount;
        this.photoUri = photoUri;
        this.createDate = createDate;
    }

  
    
    

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public ArrayList<CommentBean> yorumlariCek(int uid){
        return CommentsDAO.getComments(uid);
        
    }
    public String yorumla(int uid,int pid){
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        try {
             if(this.doc.getInputStream() == null || this.doc.getSubmittedFileName() == null || this.doc.getSubmittedFileName().equals("")){
                 this.photoUri = "empty";
            }
            else{
                InputStream input = doc.getInputStream();
                if(doc.getSubmittedFileName().endsWith(".png") || doc.getSubmittedFileName().endsWith("gif") || doc.getSubmittedFileName().endsWith("jpeg") || doc.getSubmittedFileName().endsWith("jpg") ||doc.getSubmittedFileName().endsWith("svg")){
                    Random rand = new Random();
                    String dosyaIsmi = UserDAO.getTag(uid) + "_" + String.valueOf(this.userId) + "_" + String.valueOf(rand.nextInt(9999999)) + "_"+doc.getSubmittedFileName();
                    this.photoUri = uploadTo +"imgs/commentPictures/" + dosyaIsmi;

                    File f = new File(this.photoUri);
                    Files.copy(input, f.toPath());
                    this.photoUri ="imgs/commentPictures/" + dosyaIsmi;
                }
                else{
                    this.photoUri = "empty";
                    this.postHata = "Dosya yüklemede sadece resim uzantıları yükleyebilirsiniz.";
                    return url + "?faces-redirect=true";
                }
                
            }
            String durum = UserDAO.yorumOlustur(pid,uid,this.content,this.photoUri);
            if (durum.equals("ok")) {
                UserDAO.CommentCountArtir(pid);
                this.content = null;
                this.photoUri = "empty";
                this.postHata = "";
                this.doc = null;
            } else {
                this.postHata = durum;
            }
           return url + "?faces-redirect=true";
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        
        return url + "?faces-redirect=true";
    }
}

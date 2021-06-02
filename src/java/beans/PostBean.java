/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sirac
 */
@ManagedBean
@SessionScoped
public class PostBean implements Serializable{
    private int userId;
    private int postId;
    private String content;
    private int likeCount;
    private int commentCount;
    private String createDate;
    private String photoUrl;

    public PostBean(int userId, int postId, String content, int likeCount, int commentCount, String createDate, String photoUrl) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.createDate = createDate;
        this.photoUrl = photoUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

  
    
    /**
     * Creates a new instance of PostBean
     */
    public PostBean() {
    }
    
}

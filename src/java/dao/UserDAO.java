/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.PostBean;
import beans.UserBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import util.DataConnect;

/**
 *
 * @author asimk
 */
public class UserDAO {

    public static boolean girisYap(String email, String password) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from USERS where EMAIL = ? and PASSWORD = ?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DataConnect.close(con);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return false;
        }
        return false;
    }

    public static String kayitOl(String email, String hashtag, String firstName, String lastName, String birthDate, String sex, String password, boolean isHidden) {

        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.YYYY");
            LocalDateTime now = LocalDateTime.now();
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from USERS where EMAIL = ? or TAG = ?");
            ps.setString(1, email);
            ps.setString(2, hashtag);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DataConnect.close(con);
                return "Mail veya kullanıcı adına ait bir hesap zaten var. Lütfen Giriş sayfasından giriş yapınız. Şifrenizi unuttuysanız Şifremi unuttum sayfasını kullanınız.";
            } else {
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                Connection con1 = DataConnect.getConnection();
                PreparedStatement ps1 = con.prepareStatement("INSERT INTO USERS (TAG, EMAIL, PASSWORD, FIRSTNAME, LASTNAME,BIRTHDATE,SEX,CREATEDATE,BIO,PROFILEPICTUREURI,COVERPICTUREURI,ISHIDDEN) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

                ps1.setString(1, hashtag);
                ps1.setString(2, email);
                ps1.setString(3, password);
                ps1.setString(4, firstName);
                ps1.setString(5, lastName);
                ps1.setString(6, birthDate);
                ps1.setString(7, sex);
                ps1.setString(8, dtf.format(now));
                ps1.setString(9, "");
                ps1.setString(10, "imgs/default_pp.jpg");
                ps1.setString(11, "imgs/default_cp.jpg");
                ps1.setBoolean(12, isHidden);

                ps1.executeUpdate();
                DataConnect.close(con);
                return "ok";
            }
            //buraya kayıt olsun 
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return ex.getMessage();
        }

    }
    public static String sifreUnuttum(String email, String tag) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from USERS where EMAIL = ? and TAG = ?");
            ps.setString(1, email);
            ps.setString(2, tag);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("PASSWORD");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "hata";
        }
        return "hata";
    }

    public static int getUserId(String email, String password) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select USERID from USERS where EMAIL = ? and PASSWORD = ?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("USERID");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return -1;
        }
        return -1;
    }

    public static String getTag(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select TAG from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("TAG");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getFirstName(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select FIRSTNAME from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("FIRSTNAME");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getLastName(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select LASTNAME from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("LASTNAME");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getBirthDate(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select BIRTHDATE from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("BIRTHDATE");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getSex(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select SEX from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("SEX");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getCreateDate(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select CREATEDATE from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("CREATEDATE");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getBio(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select BIO from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("BIO");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static int getFollowersCount(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select FOLLOWERSCOUNT from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("FOLLOWERSCOUNT");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return -1;
        }
        return -1;
    }

    public static int getFollowingCount(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select FOLLOWINGSCOUNT from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("FOLLOWINGSCOUNT");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return -1;
        }
        return -1;
    }

    public static String getProfilePictureUri(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select PROFILEPICTUREURI from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("PROFILEPICTUREURI");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static String getCoverPictureUri(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select COVERPICTUREURI from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("COVERPICTUREURI");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return "";
        }
        return "";
    }

    public static boolean getIsHidden(int userid) {

        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select ISHIDDEN from USERS where USERID = ?");
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getBoolean("ISHIDDEN");
            }
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return false;
        }
        return false;
    }

    public static ArrayList<PostBean> postlariFiltrele(int followerId) {
        ArrayList<PostBean> postlar = PostDAO.getPosts();
        ArrayList<PostBean> postlar1 = new ArrayList<PostBean>();
        
        for (int i = 0; i < postlar.size(); i++) {
            if (FollowersDAO.isFollowing(followerId, postlar.get(i).getUserId()) || postlar.get(i).getUserId() == followerId) {

                postlar1.add(postlar.get(i));
            }
        }
        return postlar1;
    }

    public static String postOlustur(int userid, String content, String photoUri, String videoUri) {
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO POSTS (USERID,CONTENT,LIKECOUNT,COMMENTCOUNT,CREATEDATE,PHOTOURI,VIDEOURI) VALUES(?,?,0,0,?,?,?)");
            ps.setInt(1, userid);
            ps.setString(2, content);
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
            //LocalDateTime now = LocalDateTime.now();
            //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setString(4, photoUri);
            ps.setString(5, videoUri);

            ps.executeUpdate();
            DataConnect.close(con);
            return "ok";
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }
    

    public static boolean LikeCountArtir(int userId, int postId, int activeLikeCount) {

        if (!LikesDAO.isLiked(userId, postId)) {
            boolean durum = LikesDAO.Like(userId, postId);
            if (durum) {
                try {
                    Connection con = DataConnect.getConnection();
                    PreparedStatement ps = con.prepareStatement("UPDATE POSTS SET LIKECOUNT = ? where POSTID = ?");
                    ps.setInt(1, ++activeLikeCount);
                    ps.setInt(2, postId);
                    ps.executeUpdate();
                    con.close();
                    return true;
                } catch (SQLException ex) {

                    return false;
                }

            }
            return false;
        }
        return false;
    }

    public static boolean LikeCountAzalt(int userId, int postId, int activeLikeCount) {
        if (LikesDAO.isLiked(userId, postId)) {
            boolean durum = LikesDAO.unLike(userId, postId);
            if (durum) {
                try {
                    Connection con = DataConnect.getConnection();
                    PreparedStatement ps = con.prepareStatement("UPDATE POSTS SET LIKECOUNT = ? WHERE POSTID = ?");
                    ps.setInt(1, --activeLikeCount);
                    ps.setInt(2, postId);
                    ps.executeUpdate();
                    con.close();
                    return true;
                } catch (SQLException ex) {

                    return false;
                }

            }
            return false;
        }
        return false;
    }
    public static boolean CommentCountArtir( int postId) {

        
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE POSTS SET COMMENTCOUNT = COMMENTCOUNT + 1 where POSTID = ?");
            ps.setInt(1, postId);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {

            return false;
        }
    }

   
    
    //DUZELT
    public static boolean yorumLikeCountArtir(int userId, int commentId) {

        if (!CommentsLikesDAO.isLiked(userId, commentId)) {
            boolean durum = CommentsLikesDAO.Like(userId, commentId);
            if (durum) {
                try {
                    Connection con = DataConnect.getConnection();
                    PreparedStatement ps = con.prepareStatement("UPDATE COMMENTS SET LIKECOUNT = LIKECOUNT + 1 where COMMENTID = ?");
                    ps.setInt(1, commentId);
                    ps.executeUpdate();
                    con.close();
                    return true;
                } catch (SQLException ex) {

                    return false;
                }

            }
            return false;
        }
        return false;
    }

    public static boolean yorumLikeCountAzalt(int userId, int commentId) {
        if (CommentsLikesDAO.isLiked(userId, commentId)) {
            boolean durum = CommentsLikesDAO.unLike(userId, commentId);
            if (durum) {
                try {
                    Connection con = DataConnect.getConnection();
                    PreparedStatement ps = con.prepareStatement("UPDATE COMMENTS SET LIKECOUNT = LIKECOUNT - 1 WHERE COMMENTID = ?");
                    ps.setInt(1, commentId);
                    ps.executeUpdate();
                    con.close();
                    return true;
                } catch (SQLException ex) {

                    return false;
                }

            }
            return false;
        }
        return false;
    }
    public static String yorumOlustur(int postId, int userid, String content, String photoUri) {
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO COMMENTS (POSTID,USERID,CONTENT,LIKECOUNT,CREATEDATE,PHOTOURI) VALUES(?,?,?,0,?,?)");
            ps.setInt(1, postId);
            ps.setInt(2, userid);
            ps.setString(3,content);
            
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
            //LocalDateTime now = LocalDateTime.now();
            //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5, photoUri);

            ps.executeUpdate();
            DataConnect.close(con);
            return "ok";
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }

    public static boolean mesajlasmisMı(int firstid, int secondid) {
        if (FollowersDAO.isFollowing(firstid, secondid)) {
            if (MessagesDAO.getPrivateMessages(firstid, secondid).size() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static ArrayList<UserBean> kullaniciyiAra(int userId, String search) {

        ArrayList<UserBean> bulunanlar = null;
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("Select DISTINCT * from USERS where TAG LIKE ? OR FIRSTNAME LIKE ?");
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            bulunanlar = new ArrayList<UserBean>();
            while (rs.next()) {
                if (userId != rs.getInt("USERID")) {
                    UserBean ub = new UserBean();
                    ub.setTag(rs.getString("TAG"));
                    ub.setUserId(rs.getInt("USERID"));
                    ub.setBirthDate(rs.getString("BIRTHDATE"));
                    ub.setBio(rs.getString("BIO"));
                    ub.setFirstName(rs.getString("FIRSTNAME"));
                    ub.setLastName(rs.getString("LASTNAME"));
                    ub.setCoverPictureUri(rs.getString("COVERPICTUREURI"));
                    ub.setProfilePictureUri(rs.getString("PROFILEPICTUREURI"));
                    ub.setCreateDate(rs.getString("CREATEDATE"));
                    ub.setEmail(rs.getString("EMAIL"));
                    ub.setFollowerCount(rs.getInt("FOLLOWERSCOUNT"));
                    ub.setFollowingCount(rs.getInt("FOLLOWINGSCOUNT"));
                    ub.setPassword(rs.getString("PASSWORD"));
                    ub.setSex(rs.getString("SEX"));
                    ub.setIsHidden(rs.getBoolean("ISHIDDEN"));
                    bulunanlar.add(ub);
                }

            }
            con.close();
            return bulunanlar;
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return bulunanlar;
        }
    }

    public static ArrayList<PostBean> postuAra(int userId, String search, ArrayList<Integer> postSahipleri) {

        ArrayList<PostBean> bulunanlar = new ArrayList<PostBean>();
        try {
            Connection con = DataConnect.getConnection();
            for (int i = 0; i < postSahipleri.size(); i++) {
                PreparedStatement ps = con.prepareStatement("Select DISTINCT * from POSTS where CONTENT LIKE ? OR USERID= ? ORDER BY CREATEDATE DESC");
                ps.setString(1, "%" + search + "%");
                ps.setInt(2, postSahipleri.get(i));

                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0, 16);
                    String bugun = String.valueOf(new Timestamp(System.currentTimeMillis()));
                    if (tarih.substring(0, 10).equals(bugun.substring(0, 10))) {
                        if (tarih.substring(11, 13).equals(bugun.substring(11, 13))) {
                            tarih = String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16))) + " dk";
                        } else {
                            if (Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13)) == 1 && Integer.valueOf(bugun.substring(14, 16)) < Integer.valueOf(tarih.substring(14, 16))) {

                                tarih = String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) + 60) + " dk";

                            } else {
                                if (Integer.valueOf(bugun.substring(14, 16)) > Integer.valueOf(tarih.substring(14, 16))) {
                                    tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13))) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16))) + " dk";
                                } else {
                                    if (Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) == 0) {
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13))) + " saat";
                                    } else {
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13)) - 1) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) + 60) + " dk";
                                    }
                                }
                            }
                        }
                    }
                    String photouri = rs.getString("PHOTOURI");
                    if (photouri.equals("empty")) {
                        photouri = null;
                    }
                    bulunanlar.add(new PostBean(rs.getInt("USERID"), rs.getInt("POSTID"), rs.getString("CONTENT"), rs.getInt("LIKECOUNT"), rs.getInt("COMMENTCOUNT"), tarih, photouri, rs.getString("VIDEOURI")));

                }
            }
            DataConnect.close(con);
        } catch (SQLException ex) {
            System.out.println("Giriş hatası");
            return bulunanlar;
        }
        

        if (postSahipleri.size() == 0 || postSahipleri == null) {
            try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Select DISTINCT * from POSTS,USERS where POSTS.CONTENT LIKE ?  AND USERS.USERID = POSTS.USERID  AND USERS.ISHIDDEN = False ORDER BY CREATEDATE DESC");
                ps.setString(1, "%" + search + "%");
                ResultSet rs = ps.executeQuery();
                bulunanlar = new ArrayList<PostBean>();
                while (rs.next()) {
                    String tarih = rs.getString("CREATEDATE");
                    tarih = tarih.substring(0, 16);
                    String bugun = String.valueOf(new Timestamp(System.currentTimeMillis()));
                    if (tarih.substring(0, 10).equals(bugun.substring(0, 10))) {
                        if (tarih.substring(11, 13).equals(bugun.substring(11, 13))) {
                            tarih = String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16))) + " dk";
                        } else {
                            if (Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13)) == 1 && Integer.valueOf(bugun.substring(14, 16)) < Integer.valueOf(tarih.substring(14, 16))) {

                                tarih = String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) + 60) + " dk";

                            } else {
                                if (Integer.valueOf(bugun.substring(14, 16)) > Integer.valueOf(tarih.substring(14, 16))) {
                                    tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13))) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16))) + " dk";
                                } else {
                                    if (Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) == 0) {
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13))) + " saat";
                                    } else {
                                        tarih = String.valueOf(Integer.valueOf(bugun.substring(11, 13)) - Integer.valueOf(tarih.substring(11, 13)) - 1) + " saat " + String.valueOf(Integer.valueOf(bugun.substring(14, 16)) - Integer.valueOf(tarih.substring(14, 16)) + 60) + " dk";
                                    }
                                }
                            }
                        }
                    }
                    String photouri = rs.getString("PHOTOURI");
                    if (photouri.equals("empty")) {
                        photouri = null;
                    }
                    bulunanlar.add(new PostBean(rs.getInt("USERID"), rs.getInt("POSTID"), rs.getString("CONTENT"), rs.getInt("LIKECOUNT"), rs.getInt("COMMENTCOUNT"), tarih, photouri, rs.getString("VIDEOURI")));

                }

                DataConnect.close(con);
            } catch (SQLException ex) {
                System.out.println("Giriş hatası");
                return bulunanlar;

            }
        }
        return bulunanlar;
    }
    public static boolean postKaydet(int userId ,int postId) {

        if (!SavesDAO.isSaved(userId, postId)) {
            boolean durum = SavesDAO.Save(userId, postId);
            return durum;
        }
        return false;
    }

    public static boolean postKaydetme(int userId, int postId) {
        if (SavesDAO.isSaved(userId, postId)) {
            boolean durum = SavesDAO.unSave(userId, postId);
            
            return durum;
        }
        return false;
    }
    public static ArrayList<PostBean> postlariFiltreleUser(int userId){
        ArrayList<PostBean> postlar = PostDAO.getPosts();
        ArrayList<PostBean> postlar1 = new ArrayList<PostBean>();
        for (int i =  0; i < postlar.size(); i++) {
            if (postlar.get(i).getUserId() == userId) {

                postlar1.add(postlar.get(i));
            }
        }
        return postlar1;
    }
    public static String profilBilgiGuncelle(int userId, String firstName, String lastName,String tag,String bio,String birthDate,String profilePictureUri,String coverPictureUri){
        
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, TAG = ?, BIO = ?, BIRTHDATE = ?, PROFILEPICTUREURI = ?, COVERPICTUREURI = ? WHERE USERID = ?");
            ps.setString(1,firstName);
            ps.setString(2, lastName);
            ps.setString(3,tag);
            ps.setString(4,bio);
            ps.setString(5,birthDate);
            ps.setString(6, profilePictureUri);
            ps.setString(7,coverPictureUri);
            ps.setInt(8,userId);
            ps.executeUpdate();
            con.close();
            return "ok";
        } catch (SQLException ex) {

            return "error";
        }

    }
    public static String profilSifreGuncelle(int userId,String password,boolean isHidden){
        
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE USERS SET PASSWORD = ?, ISHIDDEN = ? WHERE USERID = ?");
            ps.setString(1,password);
            ps.setBoolean(2, isHidden);
            ps.setInt(3,userId);
            ps.executeUpdate();
            con.close();
            return "ok";
        } catch (SQLException ex) {

            return "error";
        }
    }

}

    



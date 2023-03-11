package com.etc.plant.entity;

/**
 * 评论表
 * @author lz
 */
public class Comment {
    /**
     * 评论id
     */
    private int comment_id;
    /**
     *用户id
     */
    private int user_id;
    /**
     *商品id
     */
    private int plant_id;
    /**
     *评论内容
     */
    private String comment;
    /**
     *评论星级
     */
    private String comment_pic;

    public Comment() {
    }

    public Comment(int user_id, int plant_id, String comment, String comment_pic) {
        this.user_id = user_id;
        this.plant_id = plant_id;
        this.comment = comment;
        this.comment_pic = comment_pic;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(int plant_id) {
        this.plant_id = plant_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment_pic() {
        return comment_pic;
    }

    public void setComment_pic(String comment_pic) {
        this.comment_pic = comment_pic;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", plant_id=" + plant_id +
                ", comment='" + comment + '\'' +
                ", comment_pic='" + comment_pic + '\'' +
                '}';
    }
}

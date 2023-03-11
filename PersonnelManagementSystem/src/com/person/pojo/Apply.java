package com.person.pojo;

import java.util.Date;

/**
 * @author lz
 * @date 2022/6/24
 */
public class Apply {
    private Integer aId;
    private Date nowDate;
    private Integer checkId;
    private String commentC;
    private String commentZ;
    private String commentD;
    private Date beginDate;
    private Date endDate;
    private int count;

    @Override
    public String toString() {
        return "Apply{" +
                "aId=" + aId +
                ", nowDate=" + nowDate +
                ", checkId=" + checkId +
                ", commentC='" + commentC + '\'' +
                ", commentZ='" + commentZ + '\'' +
                ", commentD='" + commentD + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", count=" + count +
                '}';
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCommentC() {
        return commentC;
    }

    public void setCommentC(String commentC) {
        this.commentC = commentC;
    }

    public String getCommentZ() {
        return commentZ;
    }

    public void setCommentZ(String commentZ) {
        this.commentZ = commentZ;
    }

    public String getCommentD() {
        return commentD;
    }

    public void setCommentD(String commentD) {
        this.commentD = commentD;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Apply() {

    }

    public Apply(Integer aId, Date nowDate, Integer checkId, String commentC, String commentZ, String commentD, Date beginDate, Date endDate, int count) {
        this.aId = aId;
        this.nowDate = nowDate;
        this.checkId = checkId;
        this.commentC = commentC;
        this.commentZ = commentZ;
        this.commentD = commentD;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.count = count;
    }
}

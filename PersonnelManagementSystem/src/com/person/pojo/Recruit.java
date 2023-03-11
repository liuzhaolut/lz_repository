package com.person.pojo;

/**
 * @author 高丽芳
 * 招聘管理 - 实体类
 */
public class Recruit {

    private Integer reId;
    private String reName;
    private Integer reCount;
    private Double reSal;
    private String reRequirt;


    public Recruit() {
    }

    public Recruit(Integer reId, String reName, Integer reCount, Double reSal, String reRequirt) {
        this.reId = reId;
        this.reName = reName;
        this.reCount = reCount;
        this.reSal = reSal;
        this.reRequirt = reRequirt;
    }

    public Recruit(int reId, String reName, int reCount, double reSal) {
    }


    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public Integer getReCount() {
        return reCount;
    }

    public void setReCount(Integer reCount) {
        this.reCount = reCount;
    }

    public Double getReSal() {
        return reSal;
    }

    public void setReSal(Double reSal) {
        this.reSal = reSal;
    }

    public String getReRequirt() {
        return reRequirt;
    }

    public void setReRequirt(String reRequirt) {
        this.reRequirt = reRequirt;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "reId=" + reId +
                ", reName='" + reName + '\'' +
                ", reCount=" + reCount +
                ", reSal=" + reSal +
                ", reRequirt='" + reRequirt + '\'' +
                '}';
    }
}

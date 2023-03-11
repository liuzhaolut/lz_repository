package com.dy.bean;

/**
 * 商品分类
 * @author lz
 */
public class GoodClass {
//    id
    private int id;
//    父分类id
    private int parentId;
//    分类名称
    private String classname;

    public GoodClass() {
    }

    public GoodClass(int id, int parentId, String classname) {
        this.id = id;
        this.parentId = parentId;
        this.classname = classname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "GoodClass{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", classname='" + classname + '\'' +
                '}';
    }
}

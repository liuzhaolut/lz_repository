package com.etc.plant.entity;

/**
 * 收藏夹
 * @author lz
 */
public class Collection {
    /**
     * id
     */
    private int collection_id;

    /**
     *用户id
     */
    private int user_id;

    /**
     *商品id
     */
    private int plant_id;

    /**
     *商品颜色
     */
    private String colour;

    /**
     *尺寸
     */
    private String size;

    public Collection(){

    }
    public Collection(int collection_id, int user_id, int plant_id, String colour, String size) {
        this.collection_id = collection_id;
        this.user_id = user_id;
        this.plant_id = plant_id;
        this.colour = colour;
        this.size = size;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

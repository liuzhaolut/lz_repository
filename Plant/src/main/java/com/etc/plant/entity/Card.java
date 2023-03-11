package com.etc.plant.entity;

/**
 * 银行卡
 * @author lz
 */
public class Card {
    /**
     * id
     */
    private int card_id;
    /**
     * 用户id
     */
    private int user_id;
    /**
     * 银行卡号
     */
    private String card_number;
    /**
     * 金额
     */
    private double money;

    public Card() {
    }

    public Card(Integer card_id, int user_id, String card_number) {
        this.card_id = card_id;
        this.user_id = user_id;
        this.card_number = card_number;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", user_id=" + user_id +
                ", card_number='" + card_number + '\'' +
                '}';
    }
}

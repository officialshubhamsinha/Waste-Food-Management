package com.example.WasteFoodManagement;

public class DonorList {

    String foodName;
    String number;
    String quantity;
    String userName;
    Double x;
    Double y;


    public DonorList() {
    }

    @Override
    public String toString() {
        return "Donor{" +
                "foodName='" + foodName + '\'' +
                ", number='" + number + '\'' +
                ", quantity='" + quantity + '\'' +
                ", userName='" + userName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {this.foodName = foodName;}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQuantity() {return quantity;}

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getX() {return x;}

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {return y;}

    public void setY(Double y) {
        this.y = y;
    }
}

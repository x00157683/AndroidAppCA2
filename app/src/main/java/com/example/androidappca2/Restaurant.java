package com.example.androidappca2;

public class Restaurant {

    private String name; //name
    private String rating; // location
    private String type;
    private String restaurantId;
    private String tables;

    public Restaurant(String name, String rating, String type, String restaurantId) {
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.restaurantId = restaurantId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String toString()
    {
        return name + "\n" +  rating + "\n" + type ;
    }

}

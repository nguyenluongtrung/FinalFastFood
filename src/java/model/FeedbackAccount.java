package model;

public class FeedbackAccount {

    private int reviewID;
    private int userID;
    private String msg;
    private String reply;
    private String date;
    private int productID;
    private boolean gender;
    private String name;

    public FeedbackAccount() {

    }

    public FeedbackAccount(int reviewID, int userID, String msg, String reply, String date, int productID, boolean gender, String name) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.msg = msg;
        this.reply = reply;
        this.date = date;
        this.productID = productID;
        this.gender = gender;
        this.name = name;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FeedbackAccount{" + "reviewID=" + reviewID + ", userID=" + userID + ", msg=" + msg + ", reply=" + reply + ", date=" + date + ", productID=" + productID + ", gender=" + gender + ", name=" + name + '}';
    }

}

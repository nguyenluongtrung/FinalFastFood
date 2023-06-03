
package model;


public class FeedBack {
    private int reviewID;
    private String msg;
    private String reply;
    private String date;
    private int userID;
    private int productID;

    public FeedBack() {
    }

    public FeedBack(int reviewID, String msg, String reply, String date, int userID, int productID) {
        this.reviewID = reviewID;
        this.msg = msg;
        this.reply = reply;
        this.date = date;
        this.userID = userID;
        this.productID = productID;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "reviewID=" + reviewID + ", msg=" + msg + ", reply=" + reply + ", date=" + date + ", userID=" + userID + ", productID=" + productID + '}';
    }

    
}
 
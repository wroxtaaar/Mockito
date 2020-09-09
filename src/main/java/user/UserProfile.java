package user;

import java.util.ArrayList;
import java.util.List;

import location.Review;

public class UserProfile {
    // this value is used to create userId value
    private static int count = 0;

    private int userId;
    private String userName;
    private int contributions;
    private String bio;

    public UserProfile(String userName, int contributions, String bio) {
        this.userId = count++;
        this.userName = userName;
        this.contributions = contributions;
        this.bio = bio;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }    

    
}
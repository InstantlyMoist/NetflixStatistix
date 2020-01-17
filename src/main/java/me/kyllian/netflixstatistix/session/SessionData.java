package me.kyllian.netflixstatistix.session;

public class SessionData {

    private int userID;
    private int selectedProfileID;

    public int getSelectedProfileID() {
        return selectedProfileID;
    }

    public void setSelectedProfileID(int selectedProfileID) {
        this.selectedProfileID = selectedProfileID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

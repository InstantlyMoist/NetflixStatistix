package me.kyllian.netflixstatistix.session;

public class SessionData {

    /*
    This class is used to store some data about the session once someone logs in.
    This means we can later access more data by using the saved userID.
     */

    private int userID;
    private int selectedProfileID;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

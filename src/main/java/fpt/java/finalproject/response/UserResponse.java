package fpt.java.finalproject.response;

import fpt.java.finalproject.models.User;

public class UserResponse extends Response {

    private User authUser;

    public UserResponse() {
    }

    public void setNewResponse(UserResponse res) {
        this.setMessage(res.getMessage());
        this.setTitle(res.getTitle());
    }

    public User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(User authUser) {
        this.authUser = authUser;
    }

}

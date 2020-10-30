package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.User;

public class UserResponse extends Response {
    
    private User user;
    private List<User> userList;
    private boolean isEdit;

    public UserResponse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "UserResponse [eList=" + userList + ", user=" + user + ", isEdit=" + isEdit + "]";
	}

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}

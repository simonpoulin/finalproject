package fpt.java.finalproject.response;

public class UserObjectResponse<E> extends UserResponse {

    private E object;
    private boolean isEdit;

    public UserObjectResponse() {
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

}

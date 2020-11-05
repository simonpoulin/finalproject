package fpt.java.finalproject.response;

public class ObjectResponse<E> extends Response {

    private E object;
    private boolean isEdit;

    public ObjectResponse() {
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

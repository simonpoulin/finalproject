package fpt.java.finalproject.response;

public class Response {
    private String title, message;
    private boolean isError;

    public Response() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isError() {
        return isError;
    }

    public void setError(Boolean isError) {
        this.isError = isError;
    }

}

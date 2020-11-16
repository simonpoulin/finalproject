package fpt.java.finalproject.response;

public class Response {
    private String title, message;
    private boolean isError;

    public Response() {
    }

    public void setNewResponse(Response res) {
        this.setIsError(res.getIsError());
        this.setMessage(res.getMessage());
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

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

}

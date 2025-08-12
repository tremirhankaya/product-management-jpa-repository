package com.emirhan.product_crud_jpa_repo.exception;

public class ProductErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public ProductErrorResponse() {}
    public ProductErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
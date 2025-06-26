package model;

public class Books {
    private int bookId;
    private String title;
    private String author;
    private boolean status;
    private String dueDate;

    public Books(int bookId,String title, String author, boolean status , String dueDate ){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.status=status;
        this.dueDate=dueDate;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status=" + (status ? "Available" : "Not Available") + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}

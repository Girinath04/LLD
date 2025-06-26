package service;

import model.Books;

import java.util.Collection;
import java.util.HashMap;

public class LibraryService {
    private final HashMap<Integer, Books> booksMap = new HashMap<>();

    public boolean addBooks(Books book){
        if(booksMap.containsKey(book.getBookId())){ return false;}
        booksMap.put(book.getBookId(),book);
        return true;
    }

    public Collection<Books> getBooksMap() {
        return booksMap.values();
    }

    public Books getBookId(int bookId){
        return booksMap.get(bookId);
    }

    public boolean updateLibrary(int bookId, String title, String author, boolean status){
        Books book = booksMap.get(bookId);
        if(book == null ) {
            return false;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setStatus(status);

        return true;
    }

    public boolean deleteBook(int bookId){
        return booksMap.remove(bookId) != null;
    }

    public boolean updateDueDate(int bookId, String dueDate, boolean status){
        Books book = booksMap.get(bookId);
        if(book == null ){
            return false;
        }

        book.setDueDate(dueDate);
        book.setStatus(status);
         return true;
    }

    public boolean updateBookTitle(int bookId, String bookTitle){
        Books book = booksMap.get(bookId);
        if(book == null ){
            return false;
        }
        book.setTitle(bookTitle);
        return true;

    }





}

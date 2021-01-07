package com.library.management.repos;

import com.library.management.models.Book;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class LibraryManager {

    private Set<Book> bookList = null;


    public boolean addBook(List<Book> books) {
        if (null == bookList) {
            bookList = new TreeSet<>(books);
            return true;
        } else {
            return bookList.addAll(books);
        }
    }

    public List<Book> getAllBooks() {
        if (null != bookList) {
            return new ArrayList<>(bookList);
        } else {
            return new ArrayList<>();
        }
    }

    public boolean removeBook(String bookName){
        if (null == bookList) {
            return false;
        } else {
            return bookList.removeIf(book -> book.getName().equalsIgnoreCase(bookName.trim()));
        }
    }

    public List<Book> getBookListSortByPrice(boolean isAscending) {
        if(null == bookList){
            return new ArrayList<>();
        }
        Comparator<Book> bookComparator = null;
        if (isAscending) {
            bookComparator = (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice());
        } else {
            bookComparator = (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice());
        }
        List<Book> sortedBooks = new ArrayList<>(bookList);
        sortedBooks.sort(bookComparator);
        return sortedBooks;
    }

    public List<Book> getBookListSortByName(boolean isAscending) {
        if(null == bookList){
            return new ArrayList<>();
        }
        Comparator<Book> bookComparator = null;
        if (isAscending) {
            bookComparator = (b1, b2) -> b1.getName().compareTo(b2.getName());
        } else {
            bookComparator = (b1, b2) -> b2.getName().compareTo(b1.getName());
        }
        List<Book> sortedBooks = new ArrayList<>(bookList);
        sortedBooks.sort(bookComparator);
        return sortedBooks;
    }

    public List<Book> searchBooks(String parameter, boolean isName){
        if(null == bookList){
            return new ArrayList<>();
        }
        List<Book> query = new ArrayList<>(bookList);
        if (isName) {
            return bookList.stream().filter(book -> book.getName().equalsIgnoreCase(parameter)).collect(Collectors.toList());
        } else {
            return bookList.stream().filter(book -> book.getAuthor().equalsIgnoreCase(parameter)).collect(Collectors.toList());
        }

    }
}

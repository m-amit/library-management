package com.library.management.service;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.SearchReq;
import com.library.management.models.SortingReq;

import java.util.List;

public interface UserOperationService {

    List<Book> fetchAllBooks() throws LMSException;

    List<Book> sortBooks(SortingReq sortingReq) throws LMSException;

    List<Book> searchBook(SearchReq searchReq) throws  LMSException;

}

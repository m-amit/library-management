package com.library.management.service.impl;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.SearchReq;
import com.library.management.models.SortingReq;
import com.library.management.repos.LibraryManager;
import com.library.management.service.UserOperationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOperationServiceImpl implements UserOperationService {

    private LibraryManager libraryManager;

    public UserOperationServiceImpl(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public List<Book> fetchAllBooks() throws LMSException {
        return libraryManager.getAllBooks();
    }

    @Override
    public List<Book> sortBooks(SortingReq sortingReq) throws LMSException {
        if ("price".equalsIgnoreCase(sortingReq.getSortBy())) {
            return libraryManager.getBookListSortByPrice("ascending".equalsIgnoreCase(sortingReq.getSortMethod()));
        } else {
            return libraryManager.getBookListSortByName("ascending".equalsIgnoreCase(sortingReq.getSortMethod()));
        }
    }

    @Override
    public List<Book> searchBook(SearchReq searchReq) throws LMSException {
        if (searchReq.getFilterBy().contains("name") && null != searchReq.getName()) {
            return libraryManager.searchBooks(searchReq.getName(), true);
        } else if (searchReq.getFilterBy().contains("author") && null != searchReq.getAuthor()) {
            return libraryManager.searchBooks(searchReq.getAuthor(), false);
        } else {
            return new ArrayList<>();
        }
    }
}

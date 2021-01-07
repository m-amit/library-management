package com.library.management.service.impl;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.Response;
import com.library.management.repos.LibraryManager;
import com.library.management.service.AdminOperationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOperationServiceImpl implements AdminOperationService {

    private LibraryManager libraryManager;

    public AdminOperationServiceImpl(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    @Override
    public Response addBooks(List<Book> books) throws LMSException {
        boolean isAddedToLib = libraryManager.addBook(books);
        if (isAddedToLib) {
            return new Response("Success", null);
        } else {
            return new Response("Already Added Please try adding some diff book", null);
        }
    }

    @Override
    public Response removeBook(String name) throws LMSException {
        boolean isRemoved = libraryManager.removeBook(name);
        if (isRemoved) {
            return new Response("Success", name);
        } else {
            return new Response("Failed", null);
        }
    }
}

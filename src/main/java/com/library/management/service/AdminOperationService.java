package com.library.management.service;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.Response;

import java.util.List;

public interface AdminOperationService {

    Response addBooks(List<Book> books) throws LMSException;

    Response removeBook(String name) throws LMSException;
}

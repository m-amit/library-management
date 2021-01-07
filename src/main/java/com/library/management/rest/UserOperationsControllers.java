package com.library.management.rest;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.SearchReq;
import com.library.management.models.SortingReq;
import com.library.management.service.UserOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lms/user/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserOperationsControllers {

    private static final Logger logger = LoggerFactory.getLogger(AdminOperationsController.class);

    private UserOperationService userOperationService;

    public UserOperationsControllers(UserOperationService userOperationService){
        this.userOperationService = userOperationService;
    }

    @GetMapping("all-books")
    public List<Book> fetchAllBooks() {
        logger.info("Entering AdminOperationsController :: fetchAllBooks");
        List<Book> response = null;
        try {
            response = userOperationService.fetchAllBooks();
        } catch (LMSException e) {
            logger.error("Error in AdminOperationsController :: fetchAllBooks -> {}", e.getStatus(), e);
        }
        logger.info("Exiting AdminOperationsController :: fetchAllBooks");
        return response;
    }

    @PostMapping(value = "sort-books")
    public List<Book> sortBooks(@RequestBody SortingReq sortingReq) {
        logger.info("Entering AdminOperationsController :: sortBooks");
        List<Book> response = null;
        try {
            response = userOperationService.sortBooks(sortingReq);
        } catch (LMSException e) {
            logger.error("Error in AdminOperationsController :: sortBooks -> {}", e.getStatus(), e);
        }
        logger.info("Exiting AdminOperationsController :: sortBooks");
        return response;
    }

    @PostMapping("search-books")
    public List<Book> searchBook(@RequestBody SearchReq searchReq) {
        logger.info("Entering AdminOperationsController :: searchBook");
        List<Book> response = null;
        try {
            response = userOperationService.searchBook(searchReq);
        } catch (LMSException e) {
            logger.error("Error in AdminOperationsController :: searchBook -> {}", e.getStatus(), e);
        }
        logger.info("Exiting AdminOperationsController :: searchBook");
        return response;
    }

}

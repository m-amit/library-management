package com.library.management.rest;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.service.UserOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lms/user/")
public class UserOperationsControllers {

    private static final Logger logger = LoggerFactory.getLogger(AdminOperationsController.class);

    private UserOperationService userOperationService;

    @Autowired
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

}

package com.library.management.rest;

import com.library.management.exception.LMSException;
import com.library.management.models.Book;
import com.library.management.models.Response;
import com.library.management.service.AdminOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lms/admin/")
public class AdminOperationsController {

    private static final Logger logger = LoggerFactory.getLogger(AdminOperationsController.class);

    private AdminOperationService adminOperationService;

    @Autowired
    public AdminOperationsController(AdminOperationService adminOperationService){
        this.adminOperationService = adminOperationService;
    }

    @PostMapping("add")
    public Response addBooks(@RequestBody List<Book> books) {
        logger.info("Entering AdminOperationsController :: {}{}", "addBooks method Req payload ->", books);
        Response response = null;
        try {
            response = adminOperationService.addBooks(books);
        } catch (LMSException e) {
            logger.error("Error in AdminOperationsController :: addBooks -> {}", e.getStatus(), e);
            response = new Response(e.getStatus(), null);
        }
        logger.info("Exiting AdminOperationsController :: {}", "addBooks method");
        return response;
    }

    @PostMapping("remove")
    public Response removeBook(@RequestBody  Book book) {
        logger.info("Entering AdminOperationsController :: {}{}", "removeBook method Req payload ->", book);
        Response response = null;
        try {
            response = adminOperationService.removeBook(book);
        } catch (LMSException e) {
            logger.error("Error in AdminOperationsController :: removeBook -> {}", e.getStatus(), e);
            response = new Response(e.getStatus(), null);
        }
        logger.info("Exiting AdminOperationsController :: {}", "removeBook method");
        return response;
    }
}

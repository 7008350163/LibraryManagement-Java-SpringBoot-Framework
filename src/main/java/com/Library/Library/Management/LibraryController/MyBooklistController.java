package com.Library.Library.Management.LibraryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Library.Library.Management.LibraryServices.MyBooklistService;

@Controller
public class MyBooklistController {
   
    @Autowired
    private MyBooklistService myBookservice;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myBookservice.deleteById(id);
        return "redirect :/all_books";
    }

}

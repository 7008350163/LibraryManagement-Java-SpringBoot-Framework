package com.Library.Library.Management.LibraryController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Library.Library.Management.LibraryEntities.Book;
import com.Library.Library.Management.LibraryEntities.MyBooklist;
import com.Library.Library.Management.LibraryServices.BookService;
import com.Library.Library.Management.LibraryServices.MyBooklistService;

@Controller
public class LibraryController {
    
    @Autowired
    private BookService service;

    @Autowired
    private MyBooklistService myBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
     @GetMapping("/all_books")
    public ModelAndView getAllBook(){
        List<Book>list=service.getAllBook();
        return new ModelAndView("AllbookList","book",list);

    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/all_books";
        
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBooklist>list =myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
        public String getMyList(@PathVariable("id") int id){
            Book b=service.getBookById(id);
            MyBooklist mb =new MyBooklist(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
            myBookService.saveMyBooks(mb);
            return "redirect:/my_books";
        }

     @RequestMapping("/editBook/{id}")
     public String editBook(@PathVariable("id")int id,Model model){
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
     }
     @RequestMapping("/deleteBook/{id}")
     public String deleteBook(@PathVariable("id")int id){
        myBookService.deleteById(id);
        return "redirect:/all_books";
     }
}

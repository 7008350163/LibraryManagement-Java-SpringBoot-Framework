package com.Library.Library.Management.LibraryServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Library.Management.LibraryEntities.MyBooklist;
import com.Library.Library.Management.LibraryRepository.MyBookRepository;

@Service
public class MyBooklistService {
    
    @Autowired
    private MyBookRepository mybook;

    public void saveMyBooks(MyBooklist book){
        mybook.save(book);
    }
   
    public List<MyBooklist> getAllMyBooks() {
        return mybook.findAll();
    }
    public void deleteById(int id){
        mybook.deleteById(id);
    }
}

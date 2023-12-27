package com.Library.Library.Management.LibraryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Library.Management.LibraryEntities.MyBooklist;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooklist,Integer>{
    
}

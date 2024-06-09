package com.naveen.url_bookmarks.controller;

import com.naveen.url_bookmarks.data.BookmarkEntity;
import com.naveen.url_bookmarks.exchange.SavePostResponse;
import com.naveen.url_bookmarks.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;


    @GetMapping("/")
    public List<BookmarkEntity> getPosts() {
        return bookmarkService.getLatest100Urls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookmarkEntity> getPost(@PathVariable(name = "id") long id) {
        BookmarkEntity response = bookmarkService.getBookmarks(id);
        if(response==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(response);
        }

    }

    @PostMapping("/")
    public ResponseEntity<?> savePost(@RequestBody BookmarkEntity bookmark) {
        SavePostResponse response = bookmarkService.addBookmark(bookmark);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll(){
        bookmarkService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

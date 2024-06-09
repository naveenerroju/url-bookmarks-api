package com.naveen.url_bookmarks.service;


import com.naveen.url_bookmarks.data.BookmarkEntity;
import com.naveen.url_bookmarks.exchange.SavePostResponse;
import com.naveen.url_bookmarks.repository.BookmarkRepository;
import com.naveen.url_bookmarks.validator.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository repository;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;


    public SavePostResponse addBookmark(BookmarkEntity bookmarkEntity){

        if(!URLValidator.isValidURL(bookmarkEntity.getUrl())){
            return null;
        }

        if(isEmptyRequest(bookmarkEntity) || isDuplicateURL(bookmarkEntity)){
            return null;
        }

        BookmarkEntity entity = BookmarkEntity.builder()
                .id(sequenceGenerator.generateSequence(BookmarkEntity.SEQUENCE_NAME))
                .name(bookmarkEntity.getName())
                .url(bookmarkEntity.getUrl())
                .caption(bookmarkEntity.getCaption())
                .dateOfPosting(LocalDate.now())
                .build();
        BookmarkEntity postId = repository.save(entity);

        return new SavePostResponse(postId.getId().toString());
    }

    public BookmarkEntity getBookmarks(long id){
        Optional<BookmarkEntity> response = repository.findById(id);
        if(response.isEmpty()){
            return null;
        } else {
            return response.get();
        }
    }

    /**
     * Retrieves the latest 100 urls from the database.
     *
     * @return a list of the latest 100 BookmarkEntity objects.
     */
    public List<BookmarkEntity> getLatest100Urls() {
        List<BookmarkEntity> response = repository.findAll();
        Collections.reverse(response);
        if(response.size()>100){
            response = response.subList(0, 100);
        }

        return response;
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public boolean isDuplicateURL(BookmarkEntity bookmark) {
        Optional<BookmarkEntity> existingBookmark = repository.findByNameAndUrlAndCaption(bookmark.getName(), bookmark.getUrl(), bookmark.getCaption());
        if(existingBookmark.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isEmptyRequest(BookmarkEntity bookmark){
        String caption = bookmark.getCaption();
        String name = bookmark.getName();
        String url = bookmark.getUrl();

        if(bookmark==null
                || caption==null || caption.isBlank()
                || name==null || name.isBlank()
                || url==null || url.isBlank()) {
            return true;
        } else {
            return false;
        }
    }

}

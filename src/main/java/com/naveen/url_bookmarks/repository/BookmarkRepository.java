package com.naveen.url_bookmarks.repository;


import com.naveen.url_bookmarks.data.BookmarkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookmarkRepository extends MongoRepository<BookmarkEntity, Long> {

    Optional<BookmarkEntity> findById(long id);
    Optional<BookmarkEntity> findByNameAndUrlAndCaption(String name, String url, String caption);
    List<BookmarkEntity> findAll();

}

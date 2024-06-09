package com.naveen.url_bookmarks.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "restaurants")
public class BookmarkEntity {

    @Transient
    public static final String SEQUENCE_NAME = "meme_sequence";

    @Id
    private Long id;
    private String name;
    private String url;
    private String caption;
    private LocalDate dateOfPosting;
}


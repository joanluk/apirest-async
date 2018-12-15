package org.emaginalabs.model;


import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Builder
public class Book {

    private final String isbn;
    private final String title;
    private final List<String> authors;


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }
}

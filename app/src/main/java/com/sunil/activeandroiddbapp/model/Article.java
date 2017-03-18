package com.sunil.activeandroiddbapp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by sunil on 18-03-2017.
 */

@Table(name = "Article", id = "article_id")
public class Article extends Model{

    // This is the unique id given by the server
    @Column(name = "id")
    private long id;

    // This is a regular field
    @Column(name = "Title")
    public String title;

    @Column(name = "Description")
    public String description;

    @Column(name = "Author")
    public String author;

    // Make sure to have a default constructor for every ActiveAndroid model

    public Article(){
        super();
    }

    public Article (String title, String description, String author){
        super();
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

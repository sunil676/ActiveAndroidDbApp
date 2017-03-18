package com.sunil.activeandroiddbapp.manager;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.sunil.activeandroiddbapp.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 18-03-2017.
 */

public class ArticleManager {

    public static void addArticle(Article article){
        article.save();
    }

    public static List<Article> getAllArticle(){
        List<Article> articles = new ArrayList<>();
        articles =  new Select().from(Article.class).execute();
        return articles;
    }

    public static List<Article> getArticle(Article article){
        List<Article> articles = new ArrayList<>();
        articles =  new Select().from(Article.class)
                  .where("article_id = ?", article.getId())
                  .orderBy("Title ASC")
                  .execute();
        return articles;
    }

    public static void deleteArticle(Article article){
        new Delete().from(Article.class).where("article_id = ?", article.getId()).execute();
    }
}

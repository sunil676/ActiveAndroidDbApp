package com.sunil.activeandroiddbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.sunil.activeandroiddbapp.adapter.ArticleAdapter;
import com.sunil.activeandroiddbapp.manager.ArticleManager;
import com.sunil.activeandroiddbapp.model.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.addArticle)
    Button addArticle;

    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Article> list = getArticles();
        if (list != null) {
            articleAdapter = new ArticleAdapter(this, list);
            recyclerView.setAdapter(articleAdapter);
        }else{
            Toast.makeText(MainActivity.this, "No article found.", Toast.LENGTH_LONG).show();
        }
    }

    private  List<Article> getArticles(){
        List<Article> articleList = ArticleManager.getAllArticle();
        return articleList;
    }

    @OnClick(R.id.addArticle)
    public void addArticle(){
        Intent intent = new Intent(MainActivity.this, AddNewArticleActivity.class);
        startActivity(intent);

    }

}

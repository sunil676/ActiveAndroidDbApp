package com.sunil.activeandroiddbapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sunil.activeandroiddbapp.manager.ArticleManager;
import com.sunil.activeandroiddbapp.model.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sunil on 18-03-2017.
 */

public class AddNewArticleActivity extends AppCompatActivity {

    @BindView(R.id.articleName)
    EditText articleName;
    @BindView(R.id.articleDesc)
    EditText articleDesc;
    @BindView(R.id.addButton)
    Button addButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acticle);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.addButton)
    public void addNewArticle(){
        String articleTitle = articleName.getText().toString();
        String articleDescription = articleDesc.getText().toString();
        if (articleTitle.isEmpty() && articleDescription.isEmpty()){
            Toast.makeText(AddNewArticleActivity.this, "Please enter details.", Toast.LENGTH_LONG).show();
        }else{
            Article article = new Article();
            article.title= articleTitle;
            article.description =articleDescription;
            article.author ="Sunil";
            ArticleManager.addArticle(article);

            finish();
        }

    }
}

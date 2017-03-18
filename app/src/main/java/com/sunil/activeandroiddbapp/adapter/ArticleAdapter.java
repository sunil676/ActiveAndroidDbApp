package com.sunil.activeandroiddbapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunil.activeandroiddbapp.R;
import com.sunil.activeandroiddbapp.manager.ArticleManager;
import com.sunil.activeandroiddbapp.model.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 18-03-2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Article> itemModels;
    private Context context;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.itemModels = articles;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_item_layout, viewGroup, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Article model = itemModels.get(position);
        initializeViews(model, holder, position);
    }


    private void initializeViews(final Article model, final RecyclerView.ViewHolder holder, final int position) {
        ((ItemViewHolder)holder).title.setText(model.getTitle());
        ((ItemViewHolder)holder).description.setText(model.getDescription());
        ((ItemViewHolder)holder).author.setText(model.getAuthor());
        ((ItemViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArticleManager.deleteArticle(model);
                itemModels.remove(model);
                notifyItemRemoved(position);
            }
        });
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.delete)
        ImageView delete;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


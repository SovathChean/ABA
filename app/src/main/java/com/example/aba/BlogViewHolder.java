package com.example.aba;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogViewHolder extends RecyclerView.ViewHolder {
   private TextView title, body, author;
    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        body = (TextView) itemView.findViewById(R.id.body);
        author = (TextView) itemView.findViewById(R.id.author);
    }

    public void bind (Blog blog)
    {
        title.setText(blog.getTitle());
        body.setText(blog.getBody());
        author.setText(blog.getAuthor());
    }
}

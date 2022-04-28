package org.example;

import java.util.ArrayList;

public class Post {
    private String content;
    private String author;
    private String date;
    private int id;

    private boolean isPublished;
    public static ArrayList<Post> mInstances = new ArrayList<>();
    public Post(String content, String author, String date, int id) {
        this.content = content;
        this.author = author;
        this.date = date;
        this.id = id;
        this.mInstances.add(this);
    }

    //Delete a post
    public static void delete(int id) {
//      Find the post with the id
        Post post = findById(id);
        mInstances.remove(post);
    }

    //Find a post by id
    public static Post findById(int id) {
        for (Post post : mInstances) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }
    public String getContent() {
        return content;
    }
    public static ArrayList<Post> getPosts() {
        return mInstances;
    }


    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

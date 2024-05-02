package com.example.day12_1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "author")
@Transactional
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    Long authorId;
    String authorName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    //creates author id column in book table
    //becoz author_id already present in author table
    
    List<Book> b=new ArrayList<>();
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public List<Book> getB() {
        return b;
    }
    public void setB(List<Book> b) {
        this.b = b;
    }
    
    
}

package com.fastcampus.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted = false")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Blog blog;

    @ManyToOne
    private Member member;

    @OneToMany
    private List<Comment> comments;

    @ColumnDefault("false")
    private boolean deleted;

}

package com.fastcampus.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne
    private Member member;

    @OneToMany
    private List<Post> postList;




}

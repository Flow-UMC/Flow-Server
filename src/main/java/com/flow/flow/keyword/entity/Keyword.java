package com.flow.flow.keyword.entity;

import com.flow.flow.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Keyword {

    @Id @GeneratedValue
    private Long keywordId;

    private String keyword;

    // category id

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}

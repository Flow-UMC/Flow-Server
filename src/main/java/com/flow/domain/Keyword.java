package com.flow.domain;

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
    @JoinColumn(name = "user_id")
    private User user;
}

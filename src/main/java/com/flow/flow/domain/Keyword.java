package com.flow.flow.domain;

import com.flow.flow.domain.User;
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

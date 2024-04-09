package com.snp.feedservice.jpa.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@Entity
@Table(name = "feed")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer id;

    @Column(name = "member_idx", nullable = false)
    private Integer memberIdx;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "regist_date", nullable = false)
    private LocalDateTime registDate;

}
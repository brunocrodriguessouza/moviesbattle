package com.letscode.moviesbattle.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private Double score;

    @Column(nullable = false, length = 50)
    private Double rating;

    @Column(nullable = false, length = 50)
    private Long votes;
}

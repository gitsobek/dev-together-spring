package io.infi.devtogetherapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}

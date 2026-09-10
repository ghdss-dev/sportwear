package br.com.sportwear.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdDate;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Category() {

    }

    public Category(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    public void prePersist() {

        createdDate = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {

        updatedAt = Instant.now();
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;

        return getId().equals(category.getId()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}

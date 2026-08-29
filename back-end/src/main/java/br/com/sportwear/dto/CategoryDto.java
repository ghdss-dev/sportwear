package br.com.sportwear.dto;



import br.com.sportwear.entities.Category;

import java.io.Serializable;



public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public CategoryDto(Category entity) {

        this.id = entity.getId();
        this.name = entity.getName();

    }

    public Long getId() {
        return id;
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
}

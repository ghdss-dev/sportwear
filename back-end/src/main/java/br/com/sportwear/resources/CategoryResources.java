package br.com.sportwear.resources;

import br.com.sportwear.dto.CategoryDto;
import br.com.sportwear.entities.Category;
import br.com.sportwear.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResources {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {

        List<CategoryDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}

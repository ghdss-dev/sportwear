package br.com.sportwear.service;

import br.com.sportwear.dto.CategoryDto;
import br.com.sportwear.entities.Category;
import br.com.sportwear.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)

    public List<CategoryDto> findAll() {

        List<Category> list = categoryRepository.findAll();

        // Usando Stream + Collectors.toList()
        List<CategoryDto> listDto = list.stream()

                .map(CategoryDto::new)
                .collect(Collectors.toList());

        return listDto;
    }
}


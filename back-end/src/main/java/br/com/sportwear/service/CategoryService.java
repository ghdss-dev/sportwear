package br.com.sportwear.service;

import br.com.sportwear.dto.CategoryDto;
import br.com.sportwear.entities.Category;
import br.com.sportwear.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDto> findAllPaged(PageRequest pageRequest) {

        Page<Category> list = repository.findAll(pageRequest);

        return list.map(x -> new CategoryDto(x));

    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {

        Category entity = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return new CategoryDto(entity);
    }

    @Transactional
    public CategoryDto insert(CategoryDto dto) {

        Category entity = new Category();

        entity.setName(dto.getName());

        entity = repository.save(entity);

        return new CategoryDto(entity);
    }

    @Transactional
    public CategoryDto update(Long id, CategoryDto dto) {

        try {

            Category entity = repository.getOne(id);

            entity.setName(dto.getName());
            entity = repository.save(entity);

            return new CategoryDto(entity);

        } catch (EntityNotFoundException e) {

            throw new EntityNotFoundException("id not found " + id);
        }

    }

    public void delete(Long id) {

       try {

           repository.deleteById(id);

       } catch (EmptyResultDataAccessException e) {

           throw new EntityNotFoundException("id not found " + id);

       } catch (DataIntegrityViolationException e) {

           throw new DataIntegrityViolationException("Integrity violation");
       }
    }
}


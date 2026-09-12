package br.com.sportwear.service;

import br.com.sportwear.dto.CategoryDto;
import br.com.sportwear.dto.ProductDto;
import br.com.sportwear.entities.Category;
import br.com.sportwear.entities.Product;
import br.com.sportwear.repository.CategoryRepository;
import br.com.sportwear.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDto> findAllPaged(PageRequest pageRequest) {

        Page<Product> list = repository.findAll(pageRequest);

        return list.map(product ->
                new ProductDto(product, product.getCategories())
        );
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {

        Product entity = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));

        return new ProductDto(entity, entity.getCategories());
    }

    @Transactional
    public ProductDto insert(ProductDto dto) {

        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        entity.setDate(dto.getDate());

        if (dto.getCategories() != null) {

            for (CategoryDto categoryDto : dto.getCategories()) {

                Category category = categoryRepository
                        .findById(categoryDto.getId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Categoria não encontrada: "
                                                + categoryDto.getId()
                                )
                        );

                entity.getCategories().add(category);
            }
        }

        entity = repository.save(entity);

        return new ProductDto(
                entity,
                entity.getCategories()
        );
    }

    @Transactional
    public ProductDto update(Long id, ProductDto dto) {

        try {

            Product entity = repository.getReferenceById(id);

            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setPrice(dto.getPrice());
            entity.setImgUrl(dto.getImgUrl());
            entity.setDate(dto.getDate());

            entity.getCategories().clear();

            if (dto.getCategories() != null) {

                for (CategoryDto categoryDto : dto.getCategories()) {

                    Category category = categoryRepository
                            .findById(categoryDto.getId())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Categoria não encontrada: "
                                                    + categoryDto.getId()
                                    )
                            );

                    entity.getCategories().add(category);
                }
            }

            entity = repository.save(entity);

            return new ProductDto(
                    entity,
                    entity.getCategories()
            );

        } catch (EntityNotFoundException e) {

            throw new EntityNotFoundException(
                    "Produto não encontrado: " + id
            );
        }
    }

    @Transactional
    public void delete(Long id) {

        try {

            repository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {

            throw new EntityNotFoundException(
                    "Produto não encontrado: " + id
            );

        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityViolationException(
                    "Violação de integridade"
            );
        }
    }
}
package com.krasnyukov.kyrsovoiProject.dao;

import com.krasnyukov.kyrsovoiProject.models.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index() {
        return jdbcTemplate.query("SELECT * FROM product", new BeanPropertyRowMapper<Product>(Product.class));
    }

    public Product show(int id) {
        return jdbcTemplate.query("SELECT * FROM product WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Product.class))
                .stream().findAny().orElse(null);
    }

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO product(name, category, price, description, producingCountry) VALUES(?, ?, ?, ?, ?)",
                product.getName(), product.getCategory(), product.getPrice(), product.getDescription(), product.getProducingCountry());
    }

    public void update(int id, Product product) {

    }
}

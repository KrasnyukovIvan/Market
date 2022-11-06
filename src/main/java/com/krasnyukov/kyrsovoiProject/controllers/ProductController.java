package com.krasnyukov.kyrsovoiProject.controllers;

import com.krasnyukov.kyrsovoiProject.dao.ProductDAO;
import com.krasnyukov.kyrsovoiProject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market")
public class ProductController {

    private final ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("product", productDAO.index());
        return "market/productsList";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "market/product";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "market/createProduct";
    }

    @PostMapping()
    public String saveNewProduct(@ModelAttribute("product") Product product, BindingResult bindingResult) {
        System.out.println(product.getName());
        productDAO.save(product);
        return "redirect:/market";
    }

}

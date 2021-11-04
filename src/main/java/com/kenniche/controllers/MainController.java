package com.kenniche.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenniche.models.Category;
import com.kenniche.models.CategoryProduct;
import com.kenniche.models.Product;
import com.kenniche.services.CategoryService;
import com.kenniche.services.ProductService;


@Controller
public class MainController {
	private final ProductService prodServ;
	private final CategoryService catServ;
	
	public MainController(ProductService prodServ, CategoryService catServ) {
		this.prodServ = prodServ;
		this.catServ = catServ;
	}
	
	@GetMapping("/products/new")
	public String product(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allProducts", prodServ.getAll());
			return "newProduct.jsp";
		}
		prodServ.create(newProduct);
		return "redirect:/products/new";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("newCategory") Category newCategory, BindingResult result, Model model) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String create(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allCategories", catServ.getAll());
			return "newCategory.jsp";
		}
		catServ.create(newCategory);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct( @PathVariable("id") Long id, @ModelAttribute("addCategory") Category addCategory, BindingResult result, Model model) {
		model.addAttribute("product", prodServ.findProduct(id));
		ArrayList<Category> categories = catServ.getAll();
		model.addAttribute("categories", categories);
		return "showProducts.jsp";
	}

	@PostMapping("/products/{id}")
	public String addCategory(@RequestParam(value="category_id") Long category_id, @RequestParam(value="product_id") Long product_id) {
		Category category = catServ.findCategory(category_id);
		Product product = prodServ.findProduct(product_id);
		CategoryProduct catprod = new CategoryProduct(category, product);
		catServ.saveRelationship(catprod);
		return "redirect:/products/{id}";
	}
	
	
	@GetMapping("/categories/{id}")
	public String showCategory( @PathVariable("id") Long id, @ModelAttribute("addProduct") Product addProduct, BindingResult result, Model model) {
		model.addAttribute("category", catServ.findCategory(id));
		ArrayList<Product> products = prodServ.getAll();
		model.addAttribute("products", products);
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@RequestParam(value="product_id") Long product_id, @RequestParam(value="category_id") Long category_id) {
		Product product = prodServ.findProduct(product_id);
		Category category = catServ.findCategory(category_id);
		CategoryProduct catprod = new CategoryProduct(category, product);
		catServ.saveRelationship(catprod);
		return "redirect:/categories/{id}";
	}
}
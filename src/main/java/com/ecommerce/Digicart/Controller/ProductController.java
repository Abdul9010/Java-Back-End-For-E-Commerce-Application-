package com.ecommerce.Digicart.Controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Digicart.Model.Product;
import com.ecommerce.Digicart.Service.ProductService;
@CrossOrigin
@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestBody Product product){
		boolean result = productService.add(product);
		System.out.println("i am in product controller");
		if(result == true) {
		Response response = new Response();
			response.setMessage("Product added Successfully");
	
			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		}
		else {
			Response response = new Response();
			response.setMessage("Product adding failed");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/delete")
	public ResponseEntity<Object> delete(@RequestBody Product delete){
		boolean result = productService.delete(delete);
		if(result == true) {
			Response response = new Response();
			response.setMessage("Product Deleted Successfully");
			return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		}
		else {
			Response response = new Response();
			response.setMessage("Product deleting is failed");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<Object> list(){
		List<Product> products = productService.list();
		return new ResponseEntity<Object>(products,HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Product product){
		boolean result = productService.update(product);
		if(result == true) {
			Response response = new Response();
			response.setMessage("Product updated successfully");
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
		else {
			Response response = new Response();
			response.setMessage("Product updated Failed");
			return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
			
		}
		
	}
}

package com.ecommerce.Digicart.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Digicart.Model.UserModel;
import com.ecommerce.Digicart.Service.UserService;
import com.ecommerce.Digicart.Utils.Payment;
import com.ecommerce.Digicart.Utils.Response;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/health")
	public String healthcheck() {
		System.out.println("health check");
		return "app is running in usercontroller";
	}
	
	@CrossOrigin
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserModel user) {
		System.out.println(user.getUsername());
		boolean result = userService.register(user);
		Response response = null;
		if (result == true) {
			response = new Response();
			response.setMessage("Registered Successfully");
			response.setOperationstatus("success");
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			response = new Response();
			response.setMessage("Registration Failure");
			response.setOperationstatus("Failed");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserModel user) {
		boolean result = userService.login(user);
		Response response = null;
		if (result == true) {
			response = new Response();
			response.setMessage("Logged in  Successfully");
			response.setOperationstatus("log in success");
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			response = new Response();
			response.setMessage("Login  Failure");
			response.setOperationstatus("Login Failed");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin
	@PostMapping("/createOrder")
	public ResponseEntity<Object> createOrder(@RequestBody Payment payment) throws RazorpayException {
		RazorpayClient client = new RazorpayClient("rzp_test_KU9aICdRhwsPEG", "J5Dx2m5AtLacxczlPsxQwtbJ");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount", payment.getAmount());
		jsonObject.put("currency", payment.getCurrency());

		Order order = client.orders.create(jsonObject);
		Response response = new Response();
		response.setMessage(order.get("id"));
		response.setOperationstatus("order created");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
}

package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="SECURITY-SERVICE",path = "/auth")
public interface UserClient {
	@GetMapping("/existsById/{id}")
	public boolean existsById(@PathVariable("id") int userId);
	

}

package com.guo.cloud.controller;

import com.guo.cloud.entities.CommonResult;
import com.guo.cloud.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author guo
 * @date 2020/8/14
 */
@RestController
@Slf4j
public class ManageController {

	public static final String USER_URL = "http://localhost:8001";

	@Resource
	private RestTemplate restTemplate;

	@PostMapping("/manage/user/add")
	public CommonResult add(User user){
		String url = USER_URL + "/user/add";
		log.info(user.getName());
		return restTemplate.postForObject(url, user, CommonResult.class);
	}

	@GetMapping("/manage/user/get/{id}")
	public CommonResult<User> getById(@PathVariable("id") int id) {
		String url = USER_URL + "/user/get/" + id;
		return restTemplate.getForObject(url, CommonResult.class);
	}

	@GetMapping("/manage/user/list")
	public CommonResult<List<User>> list() {
		String url = USER_URL + "/user/list";
		return restTemplate.getForObject(url, CommonResult.class);
	}

}

package com.example.demoproject;

import com.example.demoproject.model.entity.User;
import com.example.demoproject.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoProjectApplicationTests {

	@Test
	public void testGeneJwt(){


		User user = new User();
		user.setId(12344);
		user.setName("test");
		user.setHeadImg("jpg");

		String token = JWTUtils.geneJsonWebToken(user);

		System.out.println(token);

		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Claims claims = JWTUtils.checkJWT(token);


		System.out.println(claims.get("name"));

	}


}

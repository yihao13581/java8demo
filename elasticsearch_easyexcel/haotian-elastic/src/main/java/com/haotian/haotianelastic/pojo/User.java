package com.haotian.haotianelastic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @CLassName User
 * @Description: TODO
 * @date: 2021/1/14 14:10
 * @Version 1.0
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private int age;
}

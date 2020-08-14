package com.guo.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guo
 * @date 2020/8/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String name;
}

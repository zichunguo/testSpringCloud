package com.guo.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guo
 * @date 2020/8/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private Long id;
	private Long userId;
	private Integer total;
	private Integer used;
	private Integer residue;
}

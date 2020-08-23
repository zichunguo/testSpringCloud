package com.guo.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guo
 * @date 2020/8/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	private Long id;
	private Long productId;
	private Integer total;
	private Integer used;
	private Integer residue;
}

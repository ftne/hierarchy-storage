package com.ftne.hstorage.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "additional-products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
	@Id
	private String id;

	private int treeId;

	private int level;

	private List<String> productCodes;

	private String code;

	private String parentCode;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

}

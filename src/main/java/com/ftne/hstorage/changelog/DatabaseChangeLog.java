package com.ftne.hstorage.changelog;

import com.ftne.hstorage.entity.Node;
import com.ftne.hstorage.repository.AddProductsRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
	// TODO: split it
	@ChangeSet(order = "001", id = "initial_test_data", author = "akubrakov")
	public void initDb(AddProductsRepository repository) {
		List<Node> list = new ArrayList<>();
		// categories
		list.add(Node.builder()
				.code("CAT_1")
				.level(0)
				.treeId(1000).build()
		);
		list.add(Node.builder()
				.code("CAT_2")
				.level(0)
				.treeId(1001).build()
		);
		// types
		list.add(Node.builder()
				.code("TYPE_1.1")
				.treeId(1000)
				.parentCode("CAT_1")
				.level(1).build()
		);
		list.add(Node.builder()
				.code("TYPE_1.2")
				.treeId(1000)
				.parentCode("CAT_1")
				.level(1).build()
		);
		list.add(Node.builder()
				.code("TYPE_2.1")
				.treeId(1001)
				.parentCode("CAT_2")
				.level(1).build()
		);
		// views
		list.add(Node.builder()
				.code("KIND_1.1.1")
				.treeId(1000)
				.parentCode("TYPE_1.1")
				.level(2).build()
		);
		list.add(Node.builder()
				.code("KIND_1.1.2")
				.treeId(1000)
				.parentCode("TYPE_1.1")
				.level(2).build()
		);
		list.add(Node.builder()
				.code("KIND_1.2.1")
				.treeId(1000)
				.parentCode("TYPE_1.2")
				.level(2).build()
		);
		// add-products 1000
		list.add(Node.builder()
				.code("AP_1.1.1.1")
				.productCodes(Arrays.asList("PROD1", "PROD2"))
				.treeId(1000)
				.parentCode("KIND_1.1.1")
				.startDate(LocalDateTime.of(2021,1, 1, 0, 0))
				.endDate(LocalDateTime.of(2021,12, 31, 23, 59, 59))
				.level(3).build()
		);
		list.add(Node.builder()
				.code("AP_1.1.2.2")
				.productCodes(Arrays.asList("PROD1", "PROD2", "PROD3"))
				.treeId(1000)
				.parentCode("KIND_1.1.2")
				.startDate(LocalDateTime.of(2021, 1, 1, 0, 0))
				.endDate(LocalDateTime.of(2021, 12, 31, 23, 59, 59))
				.level(3).build()
		);
		list.add(Node.builder()
				.code("AP_1.1.2.1")
				.productCodes(Arrays.asList("PROD3", "PROD2"))
				.treeId(1000)
				.parentCode("KIND_1.1.2")
				.startDate(LocalDateTime.of(2021,1, 1, 0, 0))
				.endDate(LocalDateTime.of(2021,12, 31, 23, 59, 59))
				.level(3).build()
		);
		// add-products 1001
		list.add(Node.builder()
				.code("AP_2.1.1")
				.productCodes(Arrays.asList("PROD4", "PROD1"))
				.treeId(1001)
				.parentCode("TYPE_2.1")
				.startDate(LocalDateTime.of(2021,1, 1, 0, 0))
				.endDate(LocalDateTime.of(2021,12, 31, 23, 59, 59))
				.level(2).build()
		);
		list.add(Node.builder()
				.code("AP_2.1.2")
				.productCodes(Arrays.asList("PROD2", "PROD3","PROD4", "PROD1"))
				.treeId(1001)
				.parentCode("TYPE_2.1")
				.startDate(LocalDateTime.of(2021,1, 1, 0, 0))
				.endDate(LocalDateTime.of(2021,12, 31, 23, 59, 59))
				.level(2).build()
		);
		// next version of previous
		list.add(Node.builder()
				.code("AP_2.1.2")
				.productCodes(Arrays.asList("PROD2", "PROD3","PROD4", "PROD1"))
				.treeId(1001)
				.parentCode("TYPE_2.1")
				.startDate(LocalDateTime.of(2022,1, 1, 0, 0))
				.endDate(LocalDateTime.of(2022,12, 31, 23, 59, 59))
				.level(2).build()
		);

		repository.insert(list);
	}
}

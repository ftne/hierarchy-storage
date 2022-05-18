package com.ftne.hstorage.service;

import com.ftne.hstorage.entity.Node;
import com.ftne.hstorage.repository.AddProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AddProductsService {

	private final AddProductsRepository repository;

	public List<Node> getAddProductsByProductCode(String productCode) {
		return Collections.emptyList()
				// repository.findByProductCode(productCode).orElse(Collections.emptyList())
				;
	}

	public List<Node> getAddProductsByTreeId(int treeId, int startLvl) {
		return repository.findByTreeIdAndLevelGreaterThanEqual(treeId, startLvl)
				.orElse(Collections.emptyList());
	}
}

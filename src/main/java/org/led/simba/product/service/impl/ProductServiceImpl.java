package org.led.simba.product.service.impl;

import java.util.List;

import org.led.simba.product.ProductItem;
import org.led.simba.product.ProductItemException;
import org.led.simba.product.repository.ProductRepository;
import org.led.simba.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Nghia on 11-09-2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean isExist(ProductItem productItem) {
		if (StringUtils.isEmpty(productItem.getId()) || productItem.notDefineType()) {
			return false;
		}
		return productRepository.isExist(productItem);
	}

	@Override
	public ProductItem create(ProductItem productItem) {
		if (productItem.notDefineType()) {
			// throw exception
		}
//		if (StringUtils.isEmpty(productItem.getId()) || productItem.getId() == 0) {
			return productRepository.create(productItem);
//		} else {
//			return this.update(productItem);
//		}
	}

	@Override
	public ProductItem update(ProductItem productItem) {
		if (StringUtils.isEmpty(productItem.getId()) || productItem.notDefineType()) {
			throw new ProductItemException("Product Item contain invalid value: id or type is not definded. ",
					ProductItemException.NOT_EXIST);
		}
		return productRepository.update(productItem);
	}

	@Override
	public List<ProductItem> list() {
		return productRepository.list();

	}

}

package org.led.simba.product.repository.impl;

import org.apache.commons.lang3.StringUtils;
import org.core.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.led.simba.product.ProductConstant;
import org.led.simba.product.ProductItem;
import org.led.simba.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nghia on 27-09-2016.
 */
@Repository
public class ProductRepositoryImpl extends BaseRepository<ProductItem> implements ProductRepository {
	@Override
	public ProductItem create(ProductItem productItem) {
		return super.create(productItem);
	}

	@Override
	public boolean isExist(ProductItem productItem) {
		if (StringUtils.isEmpty(productItem.getModelNumber())) {
			return false;
		}
		// TODO: kiem tra exist hay chua thi theo tung loai se kiem tra khac
		// nhau,
		// co le nen check theo type. LEDTYPE = 5050 thi exist. :))
		System.out.println("axxxxxxx");
		StringBuilder sql = new StringBuilder();
		sql.append("Select md_no from " 	+ ProductConstant.PRD_TABLE + " where " + ProductConstant.PRD_TABLE
				+ "." + "md_no = " + productItem.getModelNumber());

		SQLQuery sqlquery = getCurrentActiveSession().createSQLQuery(sql.toString());
		sqlquery.addEntity(ProductItem.class);
		return !sqlquery.list().isEmpty();
	}

	@Override
	public ProductItem update(ProductItem productItem) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductItem> list() {
		String sql = "select * from " + ProductConstant.PRD_TABLE;
		SQLQuery sqlquery = getCurrentActiveSession().createSQLQuery(sql.toString());
		sqlquery.addEntity(ProductItem.class);
		
		return sqlquery.list();
	}

}

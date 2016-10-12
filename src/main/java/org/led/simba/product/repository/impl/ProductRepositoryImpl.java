package org.led.simba.product.repository.impl;

import java.util.List;

import org.core.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.led.simba.product.ProductConstant;
import org.led.simba.product.ProductItem;
import org.led.simba.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

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
		// TODO: kiem tra exist hay chua thi theo tung loai se kiem tra khac
		// nhau,
		// co le nen check theo type. LEDTYPE = 5050 thi exist. :))
		StringBuilder sql = new StringBuilder();
		sql.append("Select [column_name] from " + ProductConstant.PRD_TABLE + " where " + ProductConstant.PRD_TABLE
				+ "." + "ten truong = " + "data so sanh");

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

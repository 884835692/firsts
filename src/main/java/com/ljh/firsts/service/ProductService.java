package com.ljh.firsts.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljh.firsts.model.Product;
import com.ljh.firsts.utils.CommonQueryBean;

public interface ProductService {
	 List<Product> listShowProduct();

	    /**
	     * 根据productId查询商品信息.
	     */
	    Product findByProductId(Integer productId);
	    Product  selectByPrimaryKey ( @Param("id") Long id );
	    int deleteByPrimaryKey ( @Param("id") Long id );
	    int insert( Product record );
	    int updateByPrimaryKeySelective( Product record );
	    List<Product> list4Page (@Param("record") Product record, @Param("commonQueryParam") CommonQueryBean query);
	    long count ( Product record);
	    List<Product> list ( Product record);
	    int updateItem(Product record);
	    
	    List<Product> listByOrderNo(String orderNo );
}

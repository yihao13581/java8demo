package com.itmayiedu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @CLassName OrderDao
 * @Description: TODO
 * @date: 2019/12/30 17:37
 * @Version 1.0
 */
@Mapper
public interface OrderDao {
	@Update("update order_info set isPay=#{isPay} ,payId=#{aliPayId} where orderNumber=#{orderNumber};")
	public int updateOrder(@Param("isPay") Long isPay, @Param("aliPayId") String aliPayId, @Param("orderNumber") String orderNumber);

}

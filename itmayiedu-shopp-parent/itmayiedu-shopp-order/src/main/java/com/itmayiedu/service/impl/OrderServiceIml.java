package com.itmayiedu.service.impl;

import com.itmayiedu.api.order.OrderService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName OrderServiceIml
 * @Description: TODO
 * @date: 2019/12/30 17:39
 * @Version 1.0
 */
@RestController
public class OrderServiceIml extends BaseApiService implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Transactional
	@Override
	public ResponseBase updateOrderIdInfo(Long isPay, String aliPayId, String orderNumber) {
		int updateOrder=orderDao.updateOrder(isPay,aliPayId,orderNumber);
		if(updateOrder<=0){
			return setResultError("系统错误");
		}
		return setResultSuccess();
	}
}

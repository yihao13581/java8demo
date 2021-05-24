package com.itmayiedu.api.order;

import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.java2d.pipe.RegionSpanIterator;

/**
 * @CLassName OrderService
 * @Description: TODO
 * @date: 2019/12/30 17:25
 * @Version 1.0
 */
@RequestMapping("/order")
public interface OrderService {
	@RequestMapping("/updateOrderIdInfo")
	ResponseBase updateOrderIdInfo(@RequestParam("isPay") Long isPay, @RequestParam("payId") String aliPayId,
								   @RequestParam("orderNumber") String orderNumber);

}

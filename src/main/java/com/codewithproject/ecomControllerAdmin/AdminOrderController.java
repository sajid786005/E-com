package com.codewithproject.ecomControllerAdmin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomServices.AdminOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AdminOrderController {
	
	@Autowired
	private  AdminOrderService adminOdreService;
	
	 @GetMapping("/placedOder")
	public ResponseEntity<List<OrderDto>> getAllPlaceOder(){
		return ResponseEntity.ok(adminOdreService.getAllPlacedOrder());
		
	}
      @GetMapping("/order/{orderId}/{status}")
	public ResponseEntity<?> changeOrderStatus(@PathVariable Long order, @PathVariable String status){
    	  OrderDto orderDto = adminOdreService.changOrderStatus(order, status);
    	  if(orderDto == null)
    	  return new ResponseEntity<>(body,"Something went wrong!", HttpStatus.BAD_REQUEST);
    	  return ResponseEntity.status(HttpStatus.OK).body(orderDto);
      }
      
      @GetMapping("/order/analytics")
      public ResponseEntity<List<OrderDto>> getAllplaceOrder(){
    	  return ResponseEntity.ok(adminOdreService.getAllPlacedOrder());
    	  
      }
}

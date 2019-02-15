package com.jambit.coffeeorder.spring.service.api;

import com.jambit.coffeeorder.spring.service.entity.GetOrderDTO;
import com.jambit.coffeeorder.spring.service.entity.PostOrderDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT})
public class OrderController {

    private List<GetOrderDTO> orders = new ArrayList<>();

    @GetMapping(
            value = "/orders",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetOrderDTO>> getOrders() {
        return ResponseEntity.ok(orders);
    }

    @PostMapping(
            value = "/orders",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetOrderDTO> postOrder(@RequestBody PostOrderDTO postOrderDTO) {
        GetOrderDTO order = createOrder(postOrderDTO);
        orders.add(order);
        return ResponseEntity.ok(order);
    }

    private GetOrderDTO createOrder(PostOrderDTO postOrderDTO) {
        GetOrderDTO getOrderDTO = new GetOrderDTO();
        getOrderDTO.setBusinessId(postOrderDTO.getBusinessId());
        getOrderDTO.setQuantity(postOrderDTO.getQuantity());
        getOrderDTO.setTotalPrice(postOrderDTO.getQuantity() * getPrice(postOrderDTO.getBusinessId()));
        return getOrderDTO;
    }

    private Double getPrice(String businessId) {
        switch (businessId) {
            case "ESPRESSO":
                return 1.5;
            case "CAPPUCCINO":
                return 2.8;
            case "ESPRESSO_DOPPIO":
                return 2.2;
            default:
                return 2.9;
        }
    }
}

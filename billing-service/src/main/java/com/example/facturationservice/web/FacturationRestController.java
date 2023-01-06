package com.example.facturationservice.web;

import com.example.facturationservice.entities.Bill;
import com.example.facturationservice.feignclients.CustomerRestClient;
import com.example.facturationservice.feignclients.ProductItemRestClient;
import com.example.facturationservice.models.Customer;
import com.example.facturationservice.models.Product;
import com.example.facturationservice.repositories.BillRepository;
import com.example.facturationservice.repositories.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/controller")
public class FacturationRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private ProductItemRestClient productItemRestClient;
    private CustomerRestClient customerRestClient;

    public FacturationRestController(BillRepository billRepository,
                                     ProductItemRepository productItemRepository,
                                     ProductItemRestClient productItemRestClient,
                                     CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productItemRestClient = productItemRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill= billRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product=productItemRestClient.findProductById(productItem.getProductID());
            productItem.setProduct(product);
            productItem.setProductName(product.getName());
        });

        return bill;
    }
}

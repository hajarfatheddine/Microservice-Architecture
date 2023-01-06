# Microservice-Architecture

This repository contains five microservices in total. Three functional microservices and 2 technical microservices.
- **Functional microservices:**
    - eureka-discovery
    - gateway service
- **Technical microservices:**
    - customer-service
    - inventory-service
    - billing-service
    
## 1. Eureka discovery
It is a registration service that allows services to find and communicate with each other without hard-coding the hostname and port.
It contains all the addresses of the microservices.
Use the following URL to access eureka discovery : <https://localhost:8761>

![image](https://user-images.githubusercontent.com/84817425/209443317-550e9346-cb2c-481e-aeb9-bfe69d3d7d6e.png)

## 2. Gateway service
It is a proxy that uses an API with non-blocking I/O.
It receives external requests, and for each request received, it calls the right microservice.

## 3. Customer service
This microservice concerns everything that is customer management.
You can consult the list of all the customers and all the detailed information of each customer.

### - List of all customers:
To access the customers list through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers>

![image](https://user-images.githubusercontent.com/84817425/209443429-477202b4-418d-4ee8-9479-143871996367.png)

### - Customer details:
To access the customer's details through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443508-97545d2c-a738-4c5e-b6fb-50684b8906b3.png)

## 4. Inventory service
This microservice concerns everything that is product management.
You can consult the list of all the products and all the detailed information of each product.

### - List of all products:
To access the products list through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products>

![image](https://user-images.githubusercontent.com/84817425/209443552-685410c6-c40c-4b19-877c-4266c1910350.png)

### - Product details:
To access the product's details through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products/{productId}>

![image](https://user-images.githubusercontent.com/84817425/209443566-4873fc5c-0ef0-4bcb-bd32-73723e93929e.png)

## 5. Billing service
This microservice concerns everything that is billing.
You can consult the list of all the bills that exist, the details of each bill and the bills of a specific customer.

### - List of all bills:
To access the bills list through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills>

![image](https://user-images.githubusercontent.com/84817425/209443599-e43bb401-8696-491f-a5ca-bbd767ba51a2.png)

### - Bill details:
To access a specific bill infos through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443611-f0586a9f-02a9-40cd-a19f-759344eecaf1.png)

### - Bills of a specific customer:
To access the bills of a specific customer through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/customerBills/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443752-1c8b4a38-9e9f-4027-957f-1ed68dc6331b.png)

### - Full details of a specific bill:
To access the full details of specific bill through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/fullBill/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443771-088eeea2-e8ab-4f2c-b43e-6f2a973acbad.png)

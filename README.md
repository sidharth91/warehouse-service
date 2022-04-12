# warehouse-service
##Learning project

This project contain four API 

please check the swagger url

http://localhost:8080/swagger-ui/index.html


###API Documentation 
######--------------------------------------

####/upload/v1/products
This API used to initially uploads the product json file

####/upload/v1/articles
This API used to initially upload the inventory json file

####/v1/products
List all the available products by checking the inventory 

####/v1/product/sell
Update the inventory by selling a product


###Project Insight
#####------------------------------

- Have not used DB to store data all the data has been stored in memory
- have not considered atomocity and consistency of the update API
- defined only one Exception which can grow to more
- Added logger to service methods which can be more 
- Not added logback.xml file to define the log format







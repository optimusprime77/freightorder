# Freight Order API
Implements an API to fetch and post Freight Orders.


* To Build the Application , please run the following commands:

        cd FreightApplication
        mvn package

* To Run the Application, please run the following commands:

        java -jar target/FreightApplication-0.0.1-SNAPSHOT.jar
        
* To test the Create Order API, please use the following commands:

        curl --include \
                --header "Content-Type: application/json" \
                --request POST \
                --data '{
                        	"customerId" : "1",	
                        	"freightOrders" : [
                        		{
                        			"source":"Oslo",
                        			"destination":"Trondheim",
                        			"freight":"64.5"
                        		},
                        		{
                        			"source":"Stavanger",
                        			"destination":"Lofoten",
                        			"freight":"116"
                        		}
                        	]
                        }' \
                http://localhost:8080/createFreightOrder
                
* To test the Create Order API for non-existing Customer, please use the following command:
 Note: Customer ID is changed. 
 
                curl --include \
                --header "Content-Type: application/json" \
                --request POST \
                --data '{
                        	"customerId" : "255",	
                        	"freightOrders" : [
                        		{
                        			"source":"Oslo",
                        			"destination":"Trondheim",
                        			"freight":"64.5"
                        		},
                        		{
                        			"source":"Stavanger",
                        			"destination":"Lofoten",
                        			"freight":"116"
                        		}
                        	]
                        }' \
                http://localhost:8080/createFreightOrder

* To test the Fetch Order API, please use the following command:

            curl --include \
            --header "Content-Type: application/json" \
            --header "customerId: 1" \
            --request GET \
            http://localhost:8080/getFreightOrderInfo
            
Note: 
1. Please post some data in the Orders table before fetching data using the Fetch Order API.
2. Only one test Customer is added to the DB for test Purposes with CustomerId:1.     
            


# math-api
This app has 5 endpoints. OpenApi/swagger-ui integrated. Services developer by Java Spring Boot framework and deployed on Heroku. You can see swagger and openApi urls below.


## Live Service Swagger URL
Click on the link to see Swagger-UI pages. https://github-math-api.herokuapp.com/swagger-ui/index.html

## Live Open-API URL 

Click on the link to see openApi service details. https://github-math-api.herokuapp.com/v3/api-docs

## Endpoints
### 1- /min
URL https://github-math-api.herokuapp.com/min Method: POST Return the min number(s) in given list. Accept a number list in Json format and a  quantifier as request parameter.
#### example
curl --location --request POST 'https://github-math-api.herokuapp.com/min?quantifier=2' \
--header 'Content-Type: application/json' \
--data-raw '[4,0,475,77,87,8,787,87,8,-1]'
##### output  
[
    -1,
    0
]

### 2- /max
URL https://github-math-api.herokuapp.com/max Method: POST Return the max number(s) in given list. Accept a number list in Json format and a  quantifier as request parameter.
#### example
curl --location --request POST 'https://github-math-api.herokuapp.com/max?quantifier=3' \
--header 'Content-Type: application/json' \
--data-raw '[
   4,65,65,1,56,15,89,156,4895,1564,58,56,9,6,9,6,98,6414,984,655,9,1,8,5,484
]'
##### output 
[
    1564,
    4895,
    6414
]

### 3- /avg
URL https://github-math-api.herokuapp.com/median Method: POST Return median of given list. Accept a number list in Json format.

#### example
curl --location --request POST 'https://github-math-api.herokuapp.com/avg' \
--header 'Content-Type: application/json' \
--data-raw '[
    4,41,75,7,758,78,7,4,2,5,899,57,4
]'
##### output 
149.30769230769232

### 4- /median
URL https://github-math-api.herokuapp.com/median Method: POST Return median of given list. Accept a number list in Json format.

#### example
curl --location --request POST 'https://github-math-api.herokuapp.com/median' \
--header 'Content-Type: application/json' \
--data-raw '[
   2,3,2,5
]'
##### output 
2.5

### 5- /percentile
URL https://github-math-api.herokuapp.com/percentile Method: POST Return the percentil for given qth percentil and return the list element. Accept a number list in Json format and qthPercentile parameter between 1-100

#### example
curl --location --request POST 'https://github-math-api.herokuapp.com/percentile?qthPercentile=25' \
--header 'Content-Type: application/json' \
--data-raw '[
    4,41,75,7,758,78,7,4,2,5,899,57,4
]'
##### output 
4

#### example-2
curl --location --request POST 'https://github-math-api.herokuapp.com/percentile?qthPercentile=80' \
--header 'Content-Type: application/json' \
--data-raw '[
    4,41,75,7,758,78,7,4,2,5,899,57,4
]'

##### output 
78

### JUnit Test
Junit test included for each service.


Running application:

Start InfluxDB container:
  `docker-compose up -d // in folder where is docker-compose.yml located`
  
How to stop and down container:
	`docker-compose stop && docker-compose down`
	
InfluxDB administration is http://localhost:8086/

Create your org, bucket and generate access token - set these properties to application.properties.

Start Spring Boot application.

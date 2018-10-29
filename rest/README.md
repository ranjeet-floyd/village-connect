# Dropwizard connect

## Running The Application

How to start the application.

1. Run `mvn package` to build your application
1. Start application with `java -jar target/connect.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

## Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`

## How to run Mysql
	docker run -p 3306:3306  --name=docker-mysql -v /Users/ranjeet.kumar/rakuten/install/local-mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=mysql -d mysql/mysql-server 

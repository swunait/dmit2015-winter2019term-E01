#!/bin/sh
mvn clean package && docker build -t northwind/northwind-javaee8-jsf-sectionE01 .
docker rm -f northwind-javaee8-jsf-sectionE01 || true && docker run -d -p 8080:8080 -p 4848:4848 --name northwind-javaee8-jsf-sectionE01 northwind/northwind-javaee8-jsf-sectionE01
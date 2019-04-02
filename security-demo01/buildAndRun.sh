#!/bin/sh
mvn clean package && docker build -t dmit2015/security-demo01 .
docker rm -f security-demo01 || true && docker run -d -p 8080:8080 -p 4848:4848 --name security-demo01 dmit2015/security-demo01
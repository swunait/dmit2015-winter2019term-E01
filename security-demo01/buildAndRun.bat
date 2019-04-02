@echo off
call mvn clean package
call docker build -t dmit2015/security-demo01 .
call docker rm -f security-demo01
call docker run -d -p 8080:8080 -p 4848:4848 --name security-demo01 dmit2015/security-demo01
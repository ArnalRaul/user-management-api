FROM openjdk:8
ADD target/user-management-0.0.1.jar user-management-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "user-management-0.0.1.jar"] 
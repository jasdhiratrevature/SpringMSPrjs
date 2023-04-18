version: "3"
services:
  consumer:
    image: employee-consumer
    networks:
      - consumer-producer
    depends_on:
      - producer

  producer:
    image: employee-producer
    ports:
      - "8080:8080"
    networks:
      - consumer-producer

networks:
  consumer-producer:

    health-svc:
      image: jasdhirinrevature/health-svc
      ports:
        - "8081:8081"
      networks:
        - consumer-producer

    api-gw:
      image: jasdhirinrevature/spring-api-gw
      ports:
        - "8888:8888"
      networks:
        - consumer-producer

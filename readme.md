# How to run this application
### setup the kafka in docker
```shell script
docker-compose down
docker-compose up -d
```

### start our application
We create a topic named test with 3 partitions and 1 replicas.
When access the url `http://localhost:8080/kafka`, it will send the sequences from 0 to 99 to kafka.
Meanwhile, a consumer in huhx group subscribed the test topic, and it will consume the message.
We can see the console log to know what is the order did the client consume.

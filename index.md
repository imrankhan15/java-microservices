## Passenger Application 

This application has two microservices.  Passenger and Corona Checker.

Workflow:

1. Passenger make a check request to corona checker. 

2. If checked false, the coronachecker sends a message to passenger. 


3. Passenger then send a message of success to rabbit mq query pool. 

4. Then the notification takes this message from rabbit mq pool.

here are some partial demonstration videos:

1. Load Balancing:

It describes - if there is multiple corona checker application and only one passenger how the load is distributed between corona checker application.


https://youtu.be/oWp9M8b-puM 


2. Zipkin:

It describes - the timespan of multiple Microservices when making a Passenger registration. Zipkin tool is used for this visualization.

https://youtu.be/xP-6NXMPMw8 


3. Rabbit mq:

when the passenger gets response from corona checker. It then send a message to rabbitmq pool. The notification microservice collect this message from rabbitmq. Rabbit mq is used for fault tolerance.


https://youtu.be/5pjMrwFRaY8 


4. hosting to docker hub:

microservices are converted to jar file and packaged with jib and then hosted in the docker hub. Later they can be used using single docker compose file.


https://youtu.be/ClTcLGG6D64 


** the project idea is learned using www.amigoscode.com

Passenger Application:

It has two microservices Passenger and Corona Checker.

Workflow:


1. Passenger make a check request to corona checker. 

2. If checked false, the coronachecker sends a message to passenger. 

3. Passenger then send a message of success to rabbit mq query pool. 

4. Then the notification takes this message from rabbit mq pool.

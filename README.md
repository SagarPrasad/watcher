```
Pending:

Conditional checks and separate client module
Domain Builder (Done) and Validators 
Kafka / Postgres Batch Updates - reduce commits

JPA save is doing select / insert - avoid that. 
EndPoints Expose - Read should happen from the read replica DB. / fallback on Master DB (CQRS)

Integration for flyway - Done
Postgres integration - Done

//Future Enhancement - Can it be changed to webflux/reactive framework to support high TPS. ?

Profile - based
Compressed Data

Ref:
https://blog.avenuecode.com/processing-messages-with-spring-cloud-stream-and-kafka#:~:text=Spring%20Cloud%20Stream%20is%20a,business%20logic%20onto%20message%20brokers.

Multiple module with client sdk / domain / versioning / tenants etc

```
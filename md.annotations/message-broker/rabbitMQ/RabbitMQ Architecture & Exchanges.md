### **RabbitMQ Message Broker**
- It's a Erlang based message broker working on a Publish/Subscriber pattern, perfect for complex processes.
- The *producer* sends a request for the *Exchange*, who decides if where/who to forward the message. The messages are put in a  *Queue* and stored until the *Consumer* retrieves and process the message.
- Is a multi-tenant system, primarily utilizing *virtual hosts (vhosts)* to provide logical separation for tenants. 
- P.S.: Diagrams can be visually created in [RabbitMQ Simulator](https://tryrabbitmq.com/)
 
![[SimpleMessageBrokerExample.png]]

### **RabbitMQ Architecture**
- ***Producer***: An application that sends messages to RabbitMQ
- ***Exchange***: Receives messages from producers and routes them to queues based on rules (e.g., direct, topic, fanout)
- ***Binding***: Rules that connect exchanges to queues, determining how messages are routed.
- ***Queue***: A buffer that storages messages until a consumer retrieves them.
- ***Consumer***: An application that connects to queues and process messages.

- P.S.: Many _producers_ can send messages that go to one queue, and many _consumers_ can try to receive data from one _queue_.

![[RabbitArchitecture.png]]
##### **Exchange Types**
###### ***DIRECT***: Routes messages to queues based on an exact match between the message *routing key*and the *binding key* (If both are null or empty still routes).
- 
###### ***FANOUT***: Routes messages to all bound queues, ignoring routing keys (pub/sub).
- 

###### ***TOPIC***: Routes messages based on wildcard matching between the routing key and the pattern in the binding key.
- Messages sent to a `topic` exchange can't have an arbitrary `routing_key` - it must be a list of words, delimited by dots.
- The logic behind the `topic` exchange is similar to a `direct` one - a message sent with a particular routing key will be delivered to all the queues that are bound with a matching binding key. However there are two important special cases for binding keys:
	- `*` (star) can substitute for exactly one word.
	- `#` (hash) can substitute for zero or more words.

![[TopicExample.png]]

###### *HEADERS*: Uses message header attributes for routing instead of routing keys (hardly ever used).
##### **Queue Types**
- ***Classic Queues***: Traditional queues supporting prioritizes, TTL , and DLX (Dead Letter Exchange) features.
- ***Quorum Queues***: Modern queue type designed for high availability and data safety.
- ***Streams***: A specialized, high performance, append-only log (Based on KAFKA).
- ***Lazy Queues***: Moves messages to disk to support long queues.

##### **Message Durability & Acknowledgments**
- By default the messages are stored in the memory buffer, not persistent.
- Ensures message reliability through *durability* (surviving broker restarts) and *acknowledgments* (ensure processing). 
- Key mechanisms include, declaring queues/messages as persistent, using publisher confirms for producer-to-broker safety, and consumer acknowledgments to prevent message loss if a worker dies.

- **Message Durability**
	- *Durable Queues*: Queues must be declared as **durable: true**
	- *Persistent Messages*: Messages must be published with a delivery mode of 2 (persistent).
	- *Limitations*: Persistent messages are written to disk, but there is a short window where a message might be accepted but not yet persisted.

- **Message Acknowledgments (Ack/Nack)**
	- Acknowledgments ensure messages are not lost if a consumer dies before fishing the process, also checks the request and returns *Ack* if the process went well, and *Nack/Reject* if something went wrong in the process.
	- *Manual Ack*: Receives the message, process it, if the process went well its *Acknowledged* back to the exchange
	- *Nack*: If rejected, the message returns to the exchange and is routed again based on the rule for it.
		- Example of rules: 
			- Route message again for the same consumer.
			- Route the rejected message to another consumer.
			- If rejected 3 times in a row the message is deleted.

	- *AutoAck*: If the message could not be processed for any reason, *AutoAck* delete it before it process the message again.
		- *The problem*: For instance, if your database was down for a few seconds at the time of the process and could not complete it, or the process finished but contained an error, by the time your system is back, *AutoAck* already deleted the message.
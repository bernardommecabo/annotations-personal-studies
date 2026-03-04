### ***Hello World***
- At first we generate two projects, one for the publisher and one for the consumer. In this example we are going to create two new directories named *Send* and *Receive*:
- Then we need to add the *client dependency*, we can use NuGet or the following prompt:

	#### **Sending**
	- We'll call our message publisher (sender) `Send.cs` and our message consumer (receiver) `Receive.cs`. The publisher will connect to *RabbitMQ*, send a single message, then exit.
	
	- First, we have to create a connection to the server. The connection abstracts the socket connection, and takes care of protocol version negotiation and authentication and so on for us.
		- Here we connect to a RabbitMQ node on the local machine - hence the _localhost_. If we wanted to connect to a node on a different machine we'd simply specify its hostname or IP address here.
		- Next we create a channel, which is where most of the API for getting things done resides.
	
	- To send, we must declare a queue for us to send to; Then we can publish a message to the queue.
	- Declaring a queue is idempotent - it will only be created if it doesn't exist already.

	#### **Receiving**
	- As for the consumer, it is listening for messages from RabbitMQ. So unlike the publisher which publishes a single message, we'll keep the consumer running continuously to listen for messages and print them out.
	- Setting up is the same as the publisher; we open a connection and a channel, and declare the queue from which we're going to consume. Note this matches up with the queue that `Send` publishes to.

### ***Work Queues***
- In this tutorial we'll create a *Work Queue* that will be used to distribute time-consuming tasks among multiple workers.
- The main ideia behind, is to avoid doing a resource-intensive task immediately and having to wait for it to complete. Instead we schedule the task to be done later.
- We encapsulate the task as a message and send it to a queue. A worker process running in the background will pop the tasks and eventually execute the job. When you run many workers the tasks will be shared between them.

- This concept is especially useful in web applications where it's impossible to handle a complex task during a short HTTP request window.

	#### **Preparation**
	- We don't have a real-world task, like images to be resized or pdf files to be rendered, so let's fake it by just pretending we're busy - by using the `Task.Delay()` function.
	- We'll take the number of dots in the string as its complexity; every dot will account for one second of "work". For example, a fake task described by `Hello...` will take three seconds.
	
	- We'll call our message publisher (sender) `NewTask.cs` and our message consumer (receiver) `Worker.cs`. The publisher will connect to *RabbitMQ*, send multiple tasks as messages, and the workers will process the tasks and then acknowledge.
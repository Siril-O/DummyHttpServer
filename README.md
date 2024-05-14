## How to Run server:
1. clone project `git clone https://github.com/Siril-O/DummyHttpServer.git`
2. Open cloned dir `DummyHttpServer`
3. Run `sbt` wait till it wiil initialize
4. Run `run`
Server should start

## How to check if server is running locally:
Open separate terminal window and run `curl -X POST  localhost:9090/my-redirect`

## How to bind localhost to purlic url
https://cptcrunchy.medium.com/how-to-setup-a-temporary-public-url-for-localhost-ngrok-6634c1d21522

After ngrok setup
1. Ensure Dummy server is running
2. open terminal and run `ngrok http 9090`

## To change dummy response 
1. Edit https://github.com/Siril-O/DummyHttpServer/blob/main/src/main/scala/Main.scala
2. restart server

Simple tutuorial for akkk http
https://www.baeldung.com/scala/akka-http

## Simple AMQ 7 JMS Client 

This project should help you kick the tires on setting up an AMQ 7 client application. The objective is to start with something that works out of the box and use the **broker.xml** and sample Java client application to make changes and build on top. 

### Few things to consider 

1. The client application can be tested locally thanks to the **artemis-maven-plugin**, however it expects the **ARTEMIS_HOME** environment variable be set to path where the **AMQ 7** is installed
2. The broker configuration file can be found at `src/main/resources/activemq/server0/broker.xml` relative to this file
3. To test the broker configuration with default settings, run the following command(s):

   ```sh 
   # To run the test by starting up AMQ 7 server with the provided broker.xml file
   mvn verify
   
   # To run the test by starting up AMQ 7 server with the provided broker.xml file
   # and at the same time disable anonymous access
   mvn verify -DallowAnonymous=false
   
   # To run the test with an AMQ 7 already running (elsewhere)
   mvn verify -DnoServer
   ```

   More customizations to the **artemis-maven-plugin** can be learnt [here](https://activemq.apache.org/artemis/docs/latest/maven-plugin.html)


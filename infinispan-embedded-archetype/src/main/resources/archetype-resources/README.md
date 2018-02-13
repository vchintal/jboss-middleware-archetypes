## Simple JDG (embedded) Console App 

This console based application shows how to instantiate a simple **JBoss Data Grid**(JDG) cache in **embedded** mode.
    
## Running the App

A JDG cache can be instantiated in two ways:
1. Programmatically 
2. Declaratively 

#### Programmatic way
Define a new cache configuration and pass it to the **DefaultCacheManager** as shown below:

```java
Configuration configuration = new ConfigurationBuilder()
        .clustering()
        .cacheMode(CacheMode.LOCAL)
        .build();
...
EmbeddedCacheManager cacheManager = new DefaultCacheManager(configuration);
...
```
#### Declarative way
Define an XML file **infinispan.xml** as provided to you in resources folder and pass it to the **DefaultCacheManager** as shown below. Notice how you have to define the cache-configuration and then instantiate a cache using that defined configuration.

```xml
<infinispan xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="urn:infinispan:config:8.4 http://www.infinispan.org/schemas/infinispan-config-8.4.xsd"
    xmlns="urn:infinispan:config:8.4">
    <jgroups>
        <stack-file name="external-file" path="jgroups-tcp.xml" />
    </jgroups>
    <cache-container>
        <transport stack="external-file" />
        <local-cache name="localCache" />
        <distributed-cache name="distCache" owners="2"
            mode="SYNC" />
        <replicated-cache name="replCache" mode="SYNC" />
    </cache-container>
</infinispan>
```

```java
...
EmbeddedCacheManager cacheManager = new DefaultCacheManager("infinispan.xml");
...
```

### Executing the app

After you have perused the source file thoroughly, execute the project at command prompt using the following command:

```sh 
mvn clean compile exec:exec
```

### Output

You should see the following output on the node:

```sh
10:13:01.850 [main] INFO  org.everythingjboss.jdg.embedded.JDGConsoleApp - The size of the cache is : 2, mode of the cache is : LOCAL
```
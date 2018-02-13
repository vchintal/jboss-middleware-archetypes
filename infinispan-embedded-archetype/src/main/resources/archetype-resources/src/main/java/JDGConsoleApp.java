#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

public class JDGConsoleApp {

    private static final Logger logger = LogManager.getLogger(JDGConsoleApp.class);

    public static void main(String[] args) throws IOException {
        
        System.setProperty("java.net.preferIPv4Stack", "true");

        // Build Configuration for DefaultCacheManager via Fluent API
        Configuration configuration = new ConfigurationBuilder()
                .clustering()
                .cacheMode(CacheMode.LOCAL)
                .build();
        
        // Use the Configuration to instantiate CacheManager
        //EmbeddedCacheManager cacheManager = new DefaultCacheManager(configuration);
        
        // Another way to create a CacheManager is by passing the infinispan.xml
        // in your classpath (src/main/resources)
        EmbeddedCacheManager cacheManager = new DefaultCacheManager("infinispan.xml");
        
        // Get the cache instance
        Cache<String, String> cache = cacheManager.getCache("localCache");

        // Perform the cache operations
        cache.put("1", "One");
        cache.put("2", "Two");
        
        // Log few stats of the cache
        logger.info("The size of the cache is : {}, mode of the cache is : {} ", cache.size(),
                cache.getCacheConfiguration().clustering().cacheMode());

        // Stop the CacheManager instance
        cacheManager.stop();
    }
}

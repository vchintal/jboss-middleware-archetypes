#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDGRemoteClientConsoleApp {

    private static final Logger logger = LoggerFactory.getLogger(JDGRemoteClientConsoleApp.class);

    public static void main(String[] args) {
        Configuration configuration = new ConfigurationBuilder().build();
        RemoteCacheManager cacheManager = new RemoteCacheManager(configuration);

        // Get a cache instance using cacheManager
        RemoteCache<String, Integer> remoteCache = cacheManager.getCache();

        // Perform some cache operations
        remoteCache.put("1", 1);

        // Log any stats onto the console
        logger.info("The size of the cache : {}",remoteCache.size());

        // Stop the cache manager
        cacheManager.stop();
    }
}

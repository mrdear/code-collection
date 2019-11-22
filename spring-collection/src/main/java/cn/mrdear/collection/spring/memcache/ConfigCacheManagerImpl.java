package cn.mrdear.collection.spring.memcache;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cn.mrdear.collection.spring.memcache.refresh.CacheRefreshCmd;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 缓存管理器
 * @author Quding Ding
 * @since 2019/11/19
 */
@Component
public class ConfigCacheManagerImpl implements ConfigCacheManager, ApplicationListener<ContextRefreshedEvent> {


    private static Map<CacheType, ConfigRegisterFactory> CACHE_MAP;



    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCache(CacheType type, String key) {
        ConfigRegisterFactory factory = CACHE_MAP.get(type);
        return (T) factory.getCache(key);
    }


    @Override
    public void refresh(List<CacheRefreshCmd> cmds) {
        if (null == cmds || cmds.isEmpty()) {
            return;
        }
        for (CacheRefreshCmd cmd : cmds) {
            ConfigRegisterFactory factory = CACHE_MAP.get(cmd.getCacheType());
            factory.refresh(cmd);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        Map<String, ConfigRegisterFactory> factoryMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, ConfigRegisterFactory.class,
            false, true);

        // 替换, 有重复,这里会报错
        CACHE_MAP = factoryMap.values()
            .stream()
            .collect(Collectors.toMap(ConfigRegisterFactory::support, Function.identity()));
    }

}

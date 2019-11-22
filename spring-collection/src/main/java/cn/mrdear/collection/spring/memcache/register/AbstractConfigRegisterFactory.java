package cn.mrdear.collection.spring.memcache.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import cn.mrdear.collection.spring.memcache.ConfigRegisterFactory;
import cn.mrdear.collection.spring.memcache.refresh.CacheRefreshCmd;

/**
 * 依赖于Spring容器事件的缓存
 * @author Quding Ding
 * @since 2019/11/22
 */
public abstract class AbstractConfigRegisterFactory<T> implements ConfigRegisterFactory<T>,
    ApplicationListener<ContextRefreshedEvent> {


    /**
     * 刷新缓存,系统启动后,则刷新一次
     * @param context 上下文信息
     */
    abstract void initCache(ApplicationContext context);


    @Override
    public void refresh(CacheRefreshCmd cmd) {
        // Spring bean不需要主动刷新
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initCache(contextRefreshedEvent.getApplicationContext());
    }


}

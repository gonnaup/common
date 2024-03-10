package org.gonnaup.common.framework.crawler;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 资源下载器接口，用于下载资源
 *
 * @author gonnaup
 * @version created at 2024/3/10 下午6:51
 */
public interface SourceDownLoader<T> extends Iterator<T>, AutoCloseable {

    /**
     * 执行下载任务使用的的执行器
     *
     * @return {@link ExecutorService}
     */
    default ExecutorService usedExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 资源是否完成爬取
     *
     * @return true-已完成爬取， false-未完成爬取
     */
    @Override
    boolean hasNext();

    /**
     * 下一个爬取已下载的资源
     *
     * @return
     */
    @Override
    T next();


    @Override
    default void close() {
        //结束销毁执行器
        if (!usedExecutor().isShutdown()) {
            usedExecutor().shutdown();
        }
    }
}

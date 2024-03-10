package org.gonnaup.common.framework.crawler;

/**
 * 数据处理器
 *
 * @author gonnaup
 * @version created at 2024/3/10 下午7:08
 */
public interface SourceHandler<T> {

    /**
     * 处理数据，如数据持久化或数据转发等
     *
     * @param data 数据
     * @return 数据
     */
    T handler(T data);
}

package org.gonnaup.common.framework.crawler;

/**
 * 资源解析器
 *
 * @author gonnaup
 * @version created at 2024/3/10 下午7:03
 */
public interface SourceParser<T, R> {

    /**
     * 将资源<code>T</code>解析成<code>R</code>
     *
     * @param source
     * @return 根据需求转换后的数据对象
     */
    R parse(T source);

}

package org.gonnaup.common.framework.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * 爬虫引擎
 *
 * @author gonnaup
 * @version created at 2024/3/10 下午7:10
 */
public class CrawlerEngine<T, R> {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);
    //下载器
    private final SourceDownLoader<T> sourceDownLoader;
    //解析器
    private final SourceParser<T, R> sourceParser;
    //数据处理器
    private final SourceHandler<R> sourceHandler;

    public CrawlerEngine(SourceDownLoader<T> sourceDownLoader, SourceParser<T, R> sourceParser, SourceHandler<R> sourceHandler) {
        Objects.requireNonNull(sourceDownLoader);
        Objects.requireNonNull(sourceParser);
        Objects.requireNonNull(sourceHandler);
        this.sourceDownLoader = sourceDownLoader;
        this.sourceParser = sourceParser;
        this.sourceHandler = sourceHandler;
    }


    public final void engineStart() {
        logger.info("CrawlerEngine start...");
        //引擎初始化
        init();
        //爬取开始
        sourceDownLoader.forEachRemaining(t -> sourceHandler.handler(sourceParser.parse(t)));
        //结束爬取，销毁资源
        destroy();
        logger.info("CrawlerEngin shutdown...");
    }

    /**
     * 初始化方法
     */
    protected void init() {
    }

    /**
     * 爬取结束资源销毁方法
     */
    protected void destroy() {
        this.sourceDownLoader.close();
    }

}

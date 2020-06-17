package com.qibill.thread;

import org.apache.http.conn.HttpClientConnectionManager;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * 单独的线程完成连接池中的无效链接
 * @author qibill
 * @date 2019/7/17 17:23
 **/
@Component
public class IdleConnectionEvictor extends Thread {

    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        //启动时开启线程
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    @PreDestroy
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}
package com.bpzj.task1.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import static com.bpzj.task1.test.MillionTestTwo.addStringRepeatTimes;

public class ThreadInsertTest {
    private int nThread;
    private CountDownLatch startGate;
    private CountDownLatch endGate;


    public static void main(String[] args) {
        int nThread = 20;
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThread);

        new ThreadInsertTest(nThread,startGate,endGate).start();
    }

    public void start() {
        for (int i=0;i<nThread;i++) {
            Thread thread = new Thread(new insert());
            thread.start();
        }
        long startTime = System.currentTimeMillis();
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入2亿条数据用时: " + (endTime- startTime) + "ms");
    }


    public ThreadInsertTest(int nThread, CountDownLatch startGate, CountDownLatch endGate) {
        this.nThread = nThread;
        this.startGate = startGate;
        this.endGate = endGate;
    }

    class insert implements Runnable {
        public void run() {
            try {
                startGate.await();
                StringBuffer sql = new StringBuffer("INSERT INTO student VALUES(null, NOW(), NOW(),'曲艳行','3169119846',1," +
                        "'11月18日-22日','燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')");
                String add = ",(null, NOW(), NOW(),'曲艳行','3169119846',1,'11月18日-22日','燕山大学',2641,'www.jnshu.com','老大最帅','王鹏举','知乎')";
                String sqlAdded = addStringRepeatTimes(sql, add, 4999);
                Connection connection = null;
                PreparedStatement ps = null;
                try  {
                    ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
                    connection = pooledDataSource.getConnection();
                    ps = connection.prepareStatement(sqlAdded);
                    long start = System.currentTimeMillis();
                    for (int i = 0; i < 2000; i++) {
                        ps.executeUpdate();
//                        ps.close();
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("单个线程插入数据所需时间：" + (end - start) + "ms");

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
                    // 先关闭Statement
                    if (ps != null)
                        try {
                            ps.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    // 后关闭Connection
                    if ( connection != null)
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }
        }

    }
}


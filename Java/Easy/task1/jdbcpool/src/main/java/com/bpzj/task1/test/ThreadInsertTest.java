package com.bpzj.task1.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.CountDownLatch;

public class ThreadInsertTest {
    private int nThread;
    private CountDownLatch startGate;
    private CountDownLatch endGate;


    public static void main(String[] args) {
        int nThread = 10;
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

                PreparedStatement ps = null;
                String sql = "INSERT INTO user (user_name,password,sex) VALUE ('username','password',1)";
                ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
                Connection connection = pooledDataSource.getConnection();

                try () {

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?characterEncoding=utf8&useSSL=true&useServerPrepStmts=false&rewriteBatchedStatements=true", "yourusername", "yourpassword");
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql);
                    long start = System.currentTimeMillis();

                    for (int i = 0; i < 20000000; i++) {
                        ps.addBatch(sql);
                        if (i % 100000 == 0) {
                            ps.executeBatch(); //每十万条数据提交一次，以防内存溢出
                            conn.commit();
                        }
                    }
                    ps.executeBatch(); //最后再提交一次，若插入数据不是整数也没有关系
                    conn.commit();
                    long end = System.currentTimeMillis();
                    System.out.println("单个线程插入数据所需时间：" + (end - start) + "ms");

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (conn != null) {
                            conn.close();
                        }
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


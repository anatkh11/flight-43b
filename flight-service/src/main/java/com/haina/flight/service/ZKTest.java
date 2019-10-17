package com.haina.flight.service;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZKTest implements Watcher{
    static ZooKeeper zooKeeper;
    public static void main(String[] args) {
        Watcher watcher = new ZKTest();

        try {
             zooKeeper = new ZooKeeper("10.0.100.266",2181,watcher);
          /* String s = zooKeeper.create("/43b","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println(s);*/
           Stat stat = new Stat();
           byte[] data = zooKeeper.getData("/43b",watcher,stat);
            System.out.println( new String(data));

            Stat exists = zooKeeper.exists("/43b",true);
            System.out.println(exists);
            while(true){

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void process(WatchedEvent event) {

        if (event.getState() == Event.KeeperState.SyncConnected){
            if (event.getType() == Event.EventType.None && null == event.getPath()){
                System.out.println("连接上了服务器");
            } else if (event.getType() == Event.EventType.NodeChildrenChanged){
                //字节点发生变化的状态
                System.out.println("节点发生了变化");
            } else if (event.getType() == Event.EventType.NodeDataChanged){
                System.out.println("节点的值发生了变化");
                System.out.println("改变的path是:" + event.getPath());
                try {
                    zooKeeper.exists(event.getPath(),true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

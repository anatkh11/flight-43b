package com.haina.flight.service.impl;

import com.haina.flight.constants.FlightConstants;
import com.haina.flight.model.Flight;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class WatchServiceImpl implements Watcher{
    @Resource
    private ZooKeeper zooKeeper;
    @PostConstruct
    public void init(){
       // FlightConstants的test43b变量赋值
        //并给节点注册监听器
        Stat stat = new Stat();
        try {
            byte[] data = zooKeeper.getData("/test43b",true,stat);
            FlightConstants.test43b = new String(data);
            byte[] data2 = zooKeeper.getData("/flightSwitch" ,true,stat);
            FlightConstants.flightSwitch = Boolean.valueOf(new String(data2));
            byte[] data3 = zooKeeper.getData("/count",true,stat);
            FlightConstants.count = Integer.valueOf(new String(data3));
            /*byte[] data2= zooKeeper.getData("/flightSwitch",true,stat);
            FlightConstants.flightSwitch =new  Boolean(String.valueOf(data2));
            byte[] data3 = zooKeeper.getData("/count",true,stat);
            FlightConstants.count= new Integer(data3);*/
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        //监听节点变化，收到通知后，更新数据
        //重新给接电脑添加监听器
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
                    String path = event.getPath();
                    Stat stat = new Stat();
                    byte[] data = zooKeeper.getData(event.getPath(),true,stat);
                    String str = new String(data);
                    if(path.equals("/test43b")){
                        FlightConstants.test43b = str;
                    }else if(path.equals("/flightSwitch")){
                        FlightConstants.flightSwitch = Boolean.valueOf(str);
                    }else {
                        FlightConstants.count = Integer.valueOf(str);
                    }




                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

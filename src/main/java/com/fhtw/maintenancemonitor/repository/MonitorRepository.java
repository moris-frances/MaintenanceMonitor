package com.fhtw.maintenancemonitor.repository;

import com.fhtw.maintenancemonitor.pojo.Monitor;
import org.springframework.stereotype.Repository;



@Repository
public class MonitorRepository {
    private Monitor monitor;

    public Monitor getMonitor() {
        return monitor;
    }


}

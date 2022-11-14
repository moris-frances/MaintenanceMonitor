package com.fhtw.maintenancemonitor.service;

import com.fhtw.maintenancemonitor.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository MonitorRepository;
}

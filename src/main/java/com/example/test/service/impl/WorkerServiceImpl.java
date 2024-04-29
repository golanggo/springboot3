package com.example.test.service.impl;

import com.example.test.mapper.WorkerMapper;
import com.example.test.model.Worker;
import com.example.test.service.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    final private WorkerMapper workerMapper;

    public WorkerServiceImpl(WorkerMapper workerMapper) {
        this.workerMapper = workerMapper;
    }

    @Override
    public boolean register(String mobile) {
        return false;
    }

    @Override
    public boolean CheckAccount(String mobile, String password) {
        Worker worker = workerMapper.find(mobile, password);
        System.out.println(worker);
        return worker != null;
    }
}

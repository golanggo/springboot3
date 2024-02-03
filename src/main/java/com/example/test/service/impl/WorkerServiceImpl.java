package com.example.test.service.impl;

import com.example.test.service.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Override
    public boolean register(String mobile) {
        return false;
    }

    @Override
    public boolean CheckAccount(String mobile, String password) {
        return false;
    }
}

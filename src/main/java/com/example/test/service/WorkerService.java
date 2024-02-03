package com.example.test.service;

import com.example.test.model.Worker;

public interface WorkerService {
    boolean register(String mobile);

    boolean CheckAccount(String mobile, String password);
}

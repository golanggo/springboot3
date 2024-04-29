package com.example.test.mapper;

import com.example.test.model.Worker;

public interface WorkerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Integer id);

    Worker find(String mobile, String password);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}
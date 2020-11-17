package com.example.shiyouge.service;

import com.example.shiyouge.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollectService {
    @Autowired
    CollectMapper collectMapper;
}

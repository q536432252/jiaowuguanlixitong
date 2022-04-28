package com.lin.service.implTest;

import com.lin.service.SomeService;
import org.springframework.stereotype.Service;


@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(int name, int age) {
        System.out.println("某些业务方法doSome()");
    }
}

package org.curd.converts;

import org.curd.aspect.TargetDataSource;
import org.springframework.stereotype.Component;

@Component
@TargetDataSource
public class HelloTest {

    public void test(){
        System.out.println("hello world");
    }
}

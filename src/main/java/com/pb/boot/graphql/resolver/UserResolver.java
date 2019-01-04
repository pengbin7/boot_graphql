package com.pb.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pb.boot.model.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public class UserResolver implements GraphQLResolver<UserVo> {


    public String result(UserVo userVo) {
        return userVo.getPassword()+"Hello World";
    }
}

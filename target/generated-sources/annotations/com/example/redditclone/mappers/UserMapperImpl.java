package com.example.redditclone.mappers;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.models.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T00:22:40+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapRegisterRequestToUser(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( registerRequest.getUsername() );
        user.setEmail( registerRequest.getEmail() );

        user.setCreatedAt( java.time.Instant.now() );

        return user;
    }
}

package com.example.redditclone.mappers;

import com.example.redditclone.dtos.RegisterRequest;
import com.example.redditclone.models.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-12T17:50:36+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapRegisterRequestToUser(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( registerRequest.getEmail() );
        user.setUsername( registerRequest.getUsername() );

        user.setCreatedAt( java.time.Instant.now() );

        return user;
    }
}

package com.igrejaibc.sgi.mapper;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginMapper {
    private boolean loginRealizado;
    private String message;
}

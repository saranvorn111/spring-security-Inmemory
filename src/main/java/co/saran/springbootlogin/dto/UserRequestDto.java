package co.saran.springbootlogin.dto;

import lombok.Builder;

@Builder
public record UserRequestDto (String username,
                              String password,
                              String email) {
}

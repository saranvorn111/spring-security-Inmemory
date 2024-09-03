package co.saran.springbootlogin.dto;

import lombok.Builder;

@Builder
public record UserResponse(String username, String email) {
}

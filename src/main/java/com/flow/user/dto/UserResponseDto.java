package com.flow.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private int userId;
    private int budget;
    private int budgetStartDay;
    private boolean isFingerprintOn;

    @Builder
    public UserResponseDto(int userId, int budget, int budgetStartDay, boolean isFingerprintOn) {
        this.userId = userId;
        this.budget = budget;
        this.budgetStartDay = budgetStartDay;
        this.isFingerprintOn = isFingerprintOn;
    }
}

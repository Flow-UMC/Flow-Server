package com.flow.user.service;

import com.flow.config.BaseException;
import com.flow.user.domain.Budget;
import com.flow.user.domain.User;
import com.flow.user.dto.UserResponseDto;
import com.flow.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.flow.config.BaseResponseStatus.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(int userId) throws BaseException {
        User user = userRepository.findById(userId).orElseThrow(() -> new BaseException(INVALID_USER_ID));
        Budget budget = user.getBudget();
        return new UserResponseDto(user.getId(), budget.getPrice(), budget.getStartDay(), user.isFingerprintOn());
    }
}

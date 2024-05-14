package com.codewithproject.ecomAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codewithproject.ecomDto.SignupRequest;
import com.codewithproject.ecomDto.UserDto;
import com.codewithproject.ecomEntity.Order;
import com.codewithproject.ecomEntity.User;
import com.codewithproject.ecomEnums.OrderStatus;
import com.codewithproject.ecomEnums.UserRole;
import com.codewithproject.ecomRepository.OrderRepository;
import com.codewithproject.ecomRepository.UserRepository;

import jakarta.security.auth.message.AuthException;
import lombok.Data;

@Service
@Data
public class AuthServiceImpl implements AuthService {
	
	  @Autowired
    private final UserRepository userRepository;
	  
	  @Autowired
    private final OrderRepository orderRepository; 

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, OrderRepository orderRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository; 
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDto createUser(SignupRequest signupRequest) throws AuthException {
        try {
            User user = new User();
            user.setEmail(signupRequest.getEmail());
            user.setFullName(signupRequest.getName());
            user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            user.setRole(UserRole.CUSTOMER);
            User createdUser = userRepository.save(user);


            Order order = new Order(); 
            order.setAmount(0L);
            order.setTotalAmount(0L); 
            order.setUser(createdUser);
            order.setOrderStatus(OrderStatus.PENDING); 
            orderRepository.save(order);

            UserDto userDto = new UserDto();
            userDto.setId(createdUser.getId());
            return userDto;
        } catch (Exception e) {
            // Log the exception
            throw new AuthException("Error occurred while creating user", e);
        }
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    public void createAdminAccount() throws Exception {
        try {
            User adminAccount = userRepository.findByRole(UserRole.ADMIN);
            if (adminAccount == null) {
                User user = new User();
                user.setEmail("admin@test.com");
                user.setFullName("admin");
                user.setRole(UserRole.ADMIN);
                user.setPassword(passwordEncoder.encode("admin"));
                userRepository.save(user);
            }
        } catch (Exception e) {
            // Log the exception
            throw new Exception("Error occurred while creating admin account", e);
        }
    }
}

package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.service.dto.UserDTO;
import com.mycompany.myapp.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing User.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Save a user.
     *
     * @param userDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    /**
     * Get all the users.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return userRepository.findAll(pageable)
            .map(userMapper::toDto);
    }


    /**
     * Get one user by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id)
            .map(userMapper::toDto);
    }

    /**
     * Delete the user by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }
}

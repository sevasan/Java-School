package ru.tsystems.eCare.service.interfaces;

import ru.tsystems.eCare.entity.User;

import java.util.List;

/**
 * Created by sevasan on 2/28/2015.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public User findUserByPhoneNumber(String phoneNumber);
    public List<String> getAllUsersShort();
}

package com.bastet.bastetmanagement.core.security.services.impl;

import com.bastet.bastetmanagement.core.security.services.CacheService;
import com.bastet.bastetmanagement.models.User;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.bastet.bastetmanagement.core.security.SecurityConstants.JWT_EXPIRATION;

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    private final LoadingCache<String, User> loggedInUsersCache;

    /**
     * Instantiates a new Cache service.
     */
    public CacheServiceImpl() {
        super();

        loggedInUsersCache = CacheBuilder.newBuilder().
                expireAfterWrite(JWT_EXPIRATION, TimeUnit.MILLISECONDS).build(new CacheLoader<>() {
            public User load(String key) {
                return null;
            }
        });
    }

    @Override
    public void saveLoggedInUser(String key, User user) {
        log.info("Adding logged in user's information to the cache.");
        loggedInUsersCache.put(key, user);
    }

    @Override
    public User getLoggedInUser(String key) {
        try {
            log.info("Getting logged in user from cache.");
            return loggedInUsersCache.get(key);
        } catch (Exception e) {
            log.error("Couldn't find the value from the cache.");
            return null;
        }
    }

    @Override
    public void clearLoggedInUsersSession(String key) {
        loggedInUsersCache.invalidate(key);
    }
}

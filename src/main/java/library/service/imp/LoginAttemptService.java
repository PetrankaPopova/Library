package library.service.imp;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

import static java.util.concurrent.TimeUnit.MINUTES;

//Edited
@Service
public class LoginAttemptService {

    private final LoadingCache<String, Integer> loginAttemptCache;

    public LoginAttemptService() {
        this.loginAttemptCache = CacheBuilder.newBuilder()
                .expireAfterWrite(15, MINUTES)
                .maximumSize(100)
                .build(new CacheLoader<>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    public void evictUserFromLoginAttemptCache(String username) {
        this.loginAttemptCache.invalidate(username);
    }

    public void addUserToAttemptCache(String username) {
        int atmps = 0;
        try {
            atmps = this.loginAttemptCache.get(username) + 1;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        this.loginAttemptCache.put(username, atmps);
    }

    public boolean hasExceededMaxAttempts(String username) {
        try {
            return this.loginAttemptCache.get(username) >= 5;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}

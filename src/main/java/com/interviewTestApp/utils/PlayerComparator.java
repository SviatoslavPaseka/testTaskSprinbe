package com.interviewTestApp.utils;

import com.interviewTestApp.api.entities.requests.PlayerCreateData;
import com.interviewTestApp.api.entities.responses.PlayerCreateRs;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class PlayerComparator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static boolean isEqual(PlayerCreateData data, PlayerCreateRs response) {
        try {
            return BeanUtils.describe(data).entrySet().stream()
                    .filter(e -> !e.getKey().equals("password"))  // Ignore password
                    .filter(e -> !e.getKey().equals("id"))  // Ignore id
                    .allMatch(e -> {
                        try {
                            return Objects.equals(e.getValue(), BeanUtils.getProperty(response, e.getKey()));
                        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                            LOGGER.warn("{}", e);
                            return false;
                        }
                    });
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.warn("", e);
            return false;
        }

    }

}

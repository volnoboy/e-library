package com.library;

import com.library.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;

/**
 * User: Ievgen Usenko
 * Date: 8/28/14
 */

public class ApplicationLauncher {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}

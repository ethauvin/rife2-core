/*
 * Copyright 2001-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife;

import rife.tools.FileUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Singleton class that provides access to the current core version as a string.
 *
 * @author Geert Bevin (gbevin[remove] at uwyn dot com)
 * @since 1.7
 */
public class CoreVersion {
    private String version_;

    CoreVersion() {
        URL resource = getClass().getClassLoader().getResource("CORE_VERSION");

        try {
            if (resource == null) {
                version_ = null;
            } else {
                var connection = resource.openConnection();
                connection.setUseCaches(false);
                try (var input_stream = connection.getInputStream()) {
                    version_ = FileUtils.readString(input_stream);
                }
            }
        } catch (IOException e) {
            version_ = null;
        }

        if (version_ != null) {
            version_ = version_.trim();
        }
        if (null == version_) {
            version_ = "unknown version";
        }
    }

    private String getVersionString() {
        return version_;
    }

    public static String getVersion() {
        return CoreVersionSingleton.INSTANCE.getVersionString();
    }
}


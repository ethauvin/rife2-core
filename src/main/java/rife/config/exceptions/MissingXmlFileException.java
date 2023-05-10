/*
 * Copyright 2001-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.config.exceptions;

import java.io.Serial;

public class MissingXmlFileException extends ConfigErrorException {
    @Serial
    private static final long serialVersionUID = 3832381866285443663L;

    public MissingXmlFileException() {
        super("The XML path is missing.");
    }
}

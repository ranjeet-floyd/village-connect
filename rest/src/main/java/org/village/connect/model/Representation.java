package org.village.connect.model;

import lombok.Data;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * Represent response json
 * @author ranjeet.kumar
 *
 * @param <T>
 */
@Data
public class Representation<T> {

    @Nonnegative
    private final int code;
    
    @Nonnull
    private final T data;
    

}

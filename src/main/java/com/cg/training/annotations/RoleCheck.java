package com.cg.training.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to specify the required role for accessing or performing actions on the annotated class.
 * <p>
 * - The retention policy is {@code RUNTIME}, meaning the annotation is available at runtime for reflection-based processing. <br>
 * - The annotation can only be applied to {@code TYPE} elements (classes or interfaces).
 * </p>
 * 
 * @author Gourav Patra
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RoleCheck {

	/**
     * Specifies the role required to access or use the annotated class.
     * Defaults to {@code "Admin"} if no role is explicitly specified.
     * 
     */

    String role() default "Admin";
}

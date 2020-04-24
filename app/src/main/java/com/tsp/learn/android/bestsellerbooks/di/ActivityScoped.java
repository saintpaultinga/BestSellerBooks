package com.tsp.learn.android.bestsellerbooks.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by itatriev on 7/10/18.
 */

/**
 * As google-sample says:
 * "In Dagger, an unscoped component cannot depend on a scoped component. As
 * {@link AppComponent} is scoped component ({@code Singleton}),
 * we create a custom scope to be used by all subcomponents. Additionally,
 * a component with a specific scope cannot have a sub component with the same scope."
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}

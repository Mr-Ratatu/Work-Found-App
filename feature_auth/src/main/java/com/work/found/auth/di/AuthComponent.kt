package com.work.found.auth.di

import com.work.found.auth.presenter.AuthPresenter
import com.work.found.auth.view.GoogleSignInDelegate
import com.work.found.core.di.dependencies.AuthDependencies
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@AuthScope
@Component(
    modules = [AuthModule::class],
    dependencies = [AuthDependencies::class]
)
interface AuthComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: AuthDependencies): Builder

        fun build(): AuthComponent
    }

    fun inject(target: AuthPresenter)

    fun inject(target: GoogleSignInDelegate)
}
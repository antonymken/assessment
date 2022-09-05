package com.assessment.skedulo.data.di.module

import com.assessment.skedulo.data.github.GithubRepositoryImp
import com.assessment.skedulo.domain.github.repository.GithubRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindGithubRepository(githubRepositoryImp: GithubRepositoryImp): GithubRepository
}
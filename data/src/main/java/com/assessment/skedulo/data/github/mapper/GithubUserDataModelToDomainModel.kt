package com.assessment.skedulo.data.github.mapper

import com.assessment.skedulo.data.github.model.GithubUserDataModel
import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.structuer.mapper.InterfaceItemMapper


object GithubUserDataModelToDomainModel :
    InterfaceItemMapper<GithubUserDataModel.UserItemDataModel, GithubUserDomainModel> {

    override fun transform(model: GithubUserDataModel.UserItemDataModel): GithubUserDomainModel {
        return GithubUserDomainModel(
            model.id,
            model.login ?: "- -",
            model.type ?: "- -",
            model.score ?: 0.0f
        )
    }
}
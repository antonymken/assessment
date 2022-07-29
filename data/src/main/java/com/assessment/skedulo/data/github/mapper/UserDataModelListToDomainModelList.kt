package com.assessment.skedulo.data.github.mapper

import com.assessment.skedulo.data.github.model.GithubUserDataModel
import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.structuer.mapper.BaseListMapper


object UserDataModelListToDomainModelList :
    BaseListMapper<GithubUserDataModel.UserItemDataModel, GithubUserDomainModel>(){

        override fun transform(model: GithubUserDataModel.UserItemDataModel): GithubUserDomainModel {
            return GithubUserDataModelToDomainModel.transform(model)
        }
}
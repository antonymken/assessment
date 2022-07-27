package com.assessment.skedulo.structuer.mapper


import java.util.Collections.emptyList


abstract class BaseListMapper<From, To> : InterfaceListMapper<From, To> {

    override fun transform(models: Collection<From>?): Collection<To> {
        if (models == null || models.isEmpty()) return emptyList()
        val toList = mutableListOf<To>()
        for (from in models) {
            toList.add(transform(from))
        }
        return toList
    }
}

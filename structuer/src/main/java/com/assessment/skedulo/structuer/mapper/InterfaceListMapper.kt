package com.assessment.skedulo.structuer.mapper


interface InterfaceListMapper<in From, out To> : InterfaceItemMapper<From, To> {
    fun transform(models: Collection<From>?): Collection<To>
}
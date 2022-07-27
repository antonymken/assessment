package com.assessment.skedulo.structuer.mapper


interface InterfaceItemMapper<in From, out To> {
    fun transform(model: From): To
}
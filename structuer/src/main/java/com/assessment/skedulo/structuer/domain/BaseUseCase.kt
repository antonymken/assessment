package com.assessment.skedulo.structuer.domain


interface BaseUseCase<InputT, OutputT> {
    fun executeUseCase(requestValues: InputT?): OutputT
}
package com.assessment.skedulo.structuer.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseCoroutineUseCase<Q, P> : BaseUseCase<Q, P> {

    suspend fun execute(requestValues: Q): P {
        return withContext(Dispatchers.IO) {
            executeUseCase(requestValues)
        }
    }

}
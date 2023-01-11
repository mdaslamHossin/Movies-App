package com.aslamhossin.movies.arch.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

inline fun <T> LifecycleOwner.collectFlow(
    targetFlow: Flow<T>,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline collectBlock: (T) -> Unit
) {
    this.lifecycleScope.launchWhenStarted {
        targetFlow.flowWithLifecycle(this@collectFlow.lifecycle, minActiveState)
            .collect {
                collectBlock(it)
            }
    }
}

package ru.aaprokin.store.core.utils.presentation

sealed interface DataState<out T> {

    data class Error<T>(val isNetwork: Boolean = false, val message: String? = null) : DataState<T>

    class Loading<T> : DataState<T>

    data class Ok<T>(val value: T) : DataState<T>
}

fun <T> T.toDataState() =
    DataState.Ok(value = this)

val <T> DataState<T>.value: T?
    get() = if (this is DataState.Ok) {
        value
    } else {
        null
    }

fun <T> DataState<T>.map(transform: (T) -> T) =
    when (this) {
        is DataState.Error -> DataState.Error(isNetwork, message)
        is DataState.Loading -> DataState.Loading()
        is DataState.Ok -> DataState.Ok(transform.invoke(value))
    }

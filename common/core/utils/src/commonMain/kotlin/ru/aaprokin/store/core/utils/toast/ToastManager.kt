package ru.aaprokin.store.core.utils.toast

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.aaprokin.store.core.utils.coroutine.CoroutineScopeOwner

class ToastManager {

    private var _toast: MutableValue<ToastState> = MutableValue(ToastState())
    val toast: Value<ToastState> = _toast

    private val handle: ToastHandle = ToastHandleImpl()

    private var countdownTimerJob: Job? = null

    private var owner: CoroutineScopeOwner? = null

    fun attach(owner: CoroutineScopeOwner) {
        this.owner = owner
    }

    fun show(payload: ToastPayload<StringRes>): ToastHandle {
        _toast.value = ToastState(
            payload = payload,
            show = true
        )
        startCountdownTimer(payload.durationMillis)
        return handle
    }

    private fun startCountdownTimer(durationMillis: Int) {
        if (durationMillis == Int.MAX_VALUE) {
            return
        }
        countdownTimerJob?.cancel()
        countdownTimerJob = owner?.coroutineScope?.launch {
            delay(durationMillis.toLong())
            hideToast()
        }
    }

    private fun hideToast() {
        _toast.value = _toast.value.copy(
            show = false
        )
    }

    inner class ToastHandleImpl : ToastHandle {

        override fun hide() {
            hideToast()
        }
    }
}

data class ToastState(
    val payload: ToastPayload<StringRes> = ToastPayload(),
    val show: Boolean = false
)

sealed interface StringRes {
    data class Res(val value: Int) : StringRes

    data class Raw(val value: String?) : StringRes
}

fun ToastManager.danger(message: String?) =
    show(
        ToastPayload(
            message = StringRes.Raw(message),
            level = ToastLevel.Danger
        )
    )

fun ToastManager.danger(message: Int) =
    show(
        ToastPayload(
            message = StringRes.Res(message),
            level = ToastLevel.Danger
        )
    )

fun ToastManager.success(message: String?) =
    show(
        ToastPayload(
            message = StringRes.Raw(message),
            level = ToastLevel.Success
        )
    )

fun ToastManager.success(message: Int) =
    show(
        ToastPayload(
            message = StringRes.Res(message),
            level = ToastLevel.Success
        )
    )

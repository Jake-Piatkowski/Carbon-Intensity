package com.jbpi.carbonintensity.utilities

sealed class Result<out L, out R> {
    data class Error<L>(val value: L) : Result<L, Nothing>()
    data class Success<R>(val value: R) : Result<Nothing, R>()
}

inline fun <L, R, R1> Result<L, R>.fold(ifError: (L) -> R1, ifSuccess: (R) -> R1): R1 =
    when (this) {
        is Result.Error -> ifError(value)
        is Result.Success -> ifSuccess(value)
    }

fun <R> R.success() = Result.Success(this)
fun <L> L.error() = Result.Error(this)
//
//@Suppress("detekt:TooGenericExceptionCaught")
//inline fun <R> attempt(f: () -> R): Result<Throwable, R> = try {
//    f().success()
//} catch (error: Throwable) {
//    error.error()
//}

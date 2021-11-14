package me.dgahn.trace.callback

fun interface TraceCallBack<T> {
    fun call(): T
}

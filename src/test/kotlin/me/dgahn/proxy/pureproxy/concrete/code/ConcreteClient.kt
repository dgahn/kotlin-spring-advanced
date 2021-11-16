package me.dgahn.proxy.pureproxy.concrete.code

class ConcreteClient(private val concreteLogic: ConcreteLogic) {
    fun execute() {
        concreteLogic.operation()
    }
}

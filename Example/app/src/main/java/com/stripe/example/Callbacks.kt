package com.stripe.example

import com.stripe.stripeterminal.*

/**
 * A [ReaderCallback] that notifies the [TerminalStateManager] that connection has completed
 */
class ConnectionCallback(private val manager: TerminalStateManager) : ReaderCallback {

    override fun onSuccess(reader: Reader?) {
        manager.onConnectReader()
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [PaymentIntentCallback] that notifies the [TerminalStateManager] that [PaymentIntent] creation
 * has completed
 */
class CreatePaymentIntentCallback(private val manager: TerminalStateManager): PaymentIntentCallback {
    override fun onSuccess(paymentIntent: PaymentIntent) {
        manager.onCreatePaymentIntent(paymentIntent)
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [PaymentIntentCallback] that notifies the [TerminalStateManager] that payment method collection
 * has completed
 */
class CollectPaymentMethodCallback(private val manager: TerminalStateManager): PaymentIntentCallback {
    override fun onSuccess(paymentIntent: PaymentIntent) {
        manager.onCollectPaymentMethod(paymentIntent)
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [Callback] that notifies the [TerminalStateManager] that [Terminal.collectPaymentMethod] has
 * been canceled
 */
class CollectPaymentMethodCancellationCallback(private val manager: TerminalStateManager): Callback {
    override fun onSuccess() {
        manager.onCancelCollectPaymentMethod()
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }

}

/**
 * A [PaymentIntentCallback] that notifies the [TerminalStateManager] that [PaymentIntent]
 * confirmation has completed
 */
class ConfirmPaymentIntentCallback(private val manager: TerminalStateManager): PaymentIntentCallback {
    override fun onSuccess(paymentIntent: PaymentIntent) {
        manager.onConfirmPaymentIntent(paymentIntent)
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [Callback] that notifies the [TerminalStateManager] when disconnect has completed
 */
class DisconnectCallback(private val manager: TerminalStateManager) : Callback {
    override fun onSuccess() {
        manager.onDisconnectReader()
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [Callback] that notifes the [TerminalStateManager] when discovery has completed
 */
class DiscoveryCallback(private val manager: TerminalStateManager) : Callback {
    override fun onSuccess() {
        manager.onDiscoverReaders()
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

/**
 * A [Callback] that notifies the [TerminalStateManager] when discovery has been canceled
 */
class DiscoveryCancellationCallback(private val manager: TerminalStateManager): Callback {
    override fun onSuccess() {
        manager.onCancelDiscovery()
    }

    override fun onFailure(e: TerminalException) {
        manager.onFailure(e)
    }
}

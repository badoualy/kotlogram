package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.TLContext

object TLAuthContext : TLContext(15) {

    override fun init() {
        registerClass(ReqPQ.CONSTRUCTOR_ID, ReqPQ::class.java)
        registerClass(ResPQ.CONSTRUCTOR_ID, ResPQ::class.java)
        registerClass(ReqDhParams.CONSTRUCTOR_ID, ReqDhParams::class.java)
        registerClass(ServerDhOk.CONSTRUCTOR_ID, ServerDhOk::class.java)
        registerClass(ServerDhFailure.CONSTRUCTOR_ID, ServerDhFailure::class.java)
        registerClass(ServerDhInner.CONSTRUCTOR_ID, ServerDhInner::class.java)
        registerClass(DhGenOk.CONSTRUCTOR_ID, DhGenOk::class.java)
        registerClass(DhGenFailure.CONSTRUCTOR_ID, DhGenFailure::class.java)
        registerClass(DhGenRetry.CONSTRUCTOR_ID, DhGenRetry::class.java)
        registerClass(ReqSetDhClientParams.CONSTRUCTOR_ID, ReqSetDhClientParams::class.java)
        registerClass(ClientDhInner.CONSTRUCTOR_ID, ClientDhInner::class.java)
    }
}

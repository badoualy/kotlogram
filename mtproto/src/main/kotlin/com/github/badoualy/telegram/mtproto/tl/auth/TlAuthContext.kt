package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.TLContext

object  TlAuthContext : TLContext() {

    override fun init() {
        registerClass(ReqPQ.CLASS_ID, ReqPQ::class.java)
        registerClass(ResPQ.CLASS_ID, ResPQ::class.java)
        registerClass(ReqDhParams.CLASS_ID, ReqDhParams::class.java)
        registerClass(ServerDhOk.CLASS_ID, ServerDhOk::class.java)
        registerClass(ServerDhFailure.CLASS_ID, ServerDhFailure::class.java)
        registerClass(ServerDhInner.CLASS_ID, ServerDhInner::class.java)
        registerClass(DhGenOk.CLASS_ID, DhGenOk::class.java)
        registerClass(DhGenFailure.CLASS_ID, DhGenFailure::class.java)
        registerClass(DhGenRetry.CLASS_ID, DhGenRetry::class.java)
        registerClass(ReqSetDhClientParams.CLASS_ID, ReqSetDhClientParams::class.java)
        registerClass(ClientDhInner.CLASS_ID, ClientDhInner::class.java)
    }
}

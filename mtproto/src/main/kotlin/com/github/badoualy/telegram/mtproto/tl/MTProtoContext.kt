package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.TLContext

object MTProtoContext : TLContext(15) {

    override fun init() {
        registerClass(MTMessagesContainer.CLASS_ID, MTMessagesContainer::class.java)
        registerClass(MTMsgsAck.CLASS_ID, MTMsgsAck::class.java)
        registerClass(MTNewSessionCreated.CLASS_ID, MTNewSessionCreated::class.java)
        registerClass(MTRpcError.CLASS_ID, MTRpcError::class.java)
        registerClass(MTRpcResult.CLASS_ID, MTRpcResult::class.java)

        registerClass(MTBadMessageNotification.CLASS_ID, MTBadMessageNotification::class.java)
        registerClass(MTBadServerSalt.CLASS_ID, MTBadServerSalt::class.java)
        registerClass(MTNeedResendMessage.CLASS_ID, MTNeedResendMessage::class.java)

        registerClass(MTNewMessageDetailedInfo.CLASS_ID, MTNewMessageDetailedInfo::class.java)
        registerClass(MTMessageDetailedInfo.CLASS_ID, MTMessageDetailedInfo::class.java)

        registerClass(MTGetFutureSalts.CLASS_ID, MTGetFutureSalts::class.java)
        registerClass(MTFutureSalts.CLASS_ID, MTFutureSalts::class.java)
        registerClass(MTFutureSalt.CLASS_ID, MTFutureSalt::class.java)

        // For test
        //registerClass(MTPing.CONSTRUCTOR_ID, MTPing.class);
        //registerClass(MTPingDelayDisconnect.CONSTRUCTOR_ID, MTPingDelayDisconnect.class);
        //registerClass(MTPong.CONSTRUCTOR_ID, MTPong.class);
    }
}

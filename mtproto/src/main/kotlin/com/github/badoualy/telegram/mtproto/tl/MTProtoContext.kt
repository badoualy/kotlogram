package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.TLContext

object MTProtoContext : TLContext(15) {

    override fun init() {
        registerClass(MTMessagesContainer.CONSTRUCTOR_ID, MTMessagesContainer::class.java)
        registerClass(MTMsgsAck.CONSTRUCTOR_ID, MTMsgsAck::class.java)
        registerClass(MTNewSessionCreated.CONSTRUCTOR_ID, MTNewSessionCreated::class.java)
        registerClass(MTRpcError.CONSTRUCTOR_ID, MTRpcError::class.java)
        registerClass(MTRpcResult.CONSTRUCTOR_ID, MTRpcResult::class.java)

        registerClass(MTBadMessageNotification.CONSTRUCTOR_ID, MTBadMessageNotification::class.java)
        registerClass(MTBadServerSalt.CONSTRUCTOR_ID, MTBadServerSalt::class.java)
        registerClass(MTNeedResendMessage.CONSTRUCTOR_ID, MTNeedResendMessage::class.java)

        registerClass(MTNewMessageDetailedInfo.CONSTRUCTOR_ID, MTNewMessageDetailedInfo::class.java)
        registerClass(MTMessageDetailedInfo.CONSTRUCTOR_ID, MTMessageDetailedInfo::class.java)

        registerClass(MTGetFutureSalts.CONSTRUCTOR_ID, MTGetFutureSalts::class.java)
        registerClass(MTFutureSalts.CONSTRUCTOR_ID, MTFutureSalts::class.java)
        registerClass(MTFutureSalt.CONSTRUCTOR_ID, MTFutureSalt::class.java)

        // For test
        //registerClass(MTPing.CONSTRUCTOR_ID, MTPing.class);
        //registerClass(MTPingDelayDisconnect.CONSTRUCTOR_ID, MTPingDelayDisconnect.class);
        //registerClass(MTPong.CONSTRUCTOR_ID, MTPong.class);
    }
}

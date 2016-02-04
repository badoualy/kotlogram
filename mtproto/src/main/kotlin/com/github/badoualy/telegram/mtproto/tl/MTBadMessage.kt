package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject

abstract class MTBadMessage @JvmOverloads constructor(var badMsgId: Long = 0, var badMsqSeqno: Int = 0, var errorCode: Int = 0) : TLObject() {
    val errorMessage: String
        get() {
            when (errorCode) {
                16 -> return "msg_id too low (most likely, client time is wrong; it would be worthwhile to synchronize it using msg_id notifications and re-send the original message with the �correct� msg_id or wrap it in a container with a new msg_id if the original message had waited too long on the client to be transmitted)"
                17 -> return "msg_id too high (similar to the previous case, the client time has to be synchronized, and the message re-sent with the correct msg_id)"
                18 -> return "incorrect two lower order msg_id bits (the server expects client message msg_id to be divisible by 4)"
                19 -> return "container msg_id is the same as msg_id of a previously received message (this must never happen)"
                20 -> return "message too old, and it cannot be verified whether the server has received a message with this msg_id or not"
                32 -> return "msg_seqno too low (the server has already received a message with a lower msg_id but with either a higher or an equal and odd seqno)"
                33 -> return "msg_seqno too high (similarly, there is a message with a higher msg_id but with either a lower or an equal and odd seqno)"
                34 -> return "an even msg_seqno expected (irrelevant message), but odd received"
                35 -> return "odd msg_seqno expected (relevant message), but even received"
                48 -> return "incorrect server salt (in this case, the bad_server_salt response is received with the correct salt, and the message is to be re-sent with it)"
                64 -> return "invalid container"
            }

            return ""
        }

    fun toPrettyString(): String {
        return "{id: $badMsgId, seqNo: $badMsqSeqno, errorCode: $errorCode, errorMessage: $errorMessage}"
    }

    companion object {
        @JvmField
        val ERROR_MSG_ID_TOO_LOW = 16
        @JvmField
        val ERROR_MSG_ID_TOO_HIGH = 17
        @JvmField
        val ERROR_MSG_ID_MODULO = 18
        @JvmField
        val ERROR_CONTAINER_MSG_ID_INCORRECT = 19
        @JvmField
        val ERROR_TOO_OLD = 20

        @JvmField
        val ERROR_SEQNO_TOO_LOW = 32
        @JvmField
        val ERROR_SEQNO_TOO_HIGH = 33
        @JvmField
        val ERROR_SEQNO_EXPECTED_EVEN = 34
        @JvmField
        val ERROR_SEQNO_EXPECTED_ODD = 35

        @JvmField
        val ERROR_BAD_SERVER_SALT = 48

        @JvmField
        val ERROR_BAD_CONTAINER = 64
    }
}

package com.github.badoualy.telegram.mtproto.exception

import com.github.badoualy.telegram.mtproto.tl.MTRpcError
import com.github.badoualy.telegram.tl.exception.RpcErrorException

// @formatter:off
object RpcErrors {

    // 303 ERROR_SEE_OTHER
    @JvmField val FILE_MIGRATE_X = RpcError(400, "FILE_MIGRATE_X", "the file to be accessed is currently stored in a different data center.")
    @JvmField val PHONE_MIGRATE_X = RpcError(400, "PHONE_MIGRATE_X", "the phone number a user is trying to use for authorization is associated with a different data center.")
    @JvmField val NETWORK_MIGRATE_X = RpcError(400, "NETWORK_MIGRATE_X", "the source IP address is associated with a different data center (for registration)")
    @JvmField val USER_MIGRATE_X = RpcError(400, "USER_MIGRATE_X", "the user whose identity is being used to execute queries is associated with a different data center (for registration)")

    // 400 BAD_REQUEST
    @JvmField val FIRSTNAME_INVALID = RpcError(400, "FIRSTNAME_INVALID", "The first name is invalid")
    @JvmField val LASTNAME_INVALID = RpcError(400, "LASTNAME_INVALID", "The last name is invalid")
    @JvmField val PHONE_NUMBER_INVALID = RpcError(400, "PHONE_NUMBER_INVALID", "The phone number is invalid")
    @JvmField val PHONE_CODE_HASH_EMPTY = RpcError(400, "PHONE_CODE_HASH_EMPTY", "phone_code_hash is missing")
    @JvmField val PHONE_CODE_EMPTY = RpcError(400, "PHONE_CODE_EMPTY", "phone_code is missing")
    @JvmField val PHONE_CODE_EXPIRED = RpcError(400, "PHONE_CODE_EXPIRED", "The confirmation code has expired")
    @JvmField val API_ID_INVALID = RpcError(400, "API_ID_INVALID", "The api_id/api_hash combination is invalid")
    @JvmField val PHONE_NUMBER_OCCUPIED = RpcError(400, "PHONE_NUMBER_OCCUPIED", "The phone number is already in use")
    @JvmField val PHONE_NUMBER_UNOCCUPIED = RpcError(400, "PHONE_NUMBER_UNOCCUPIED", "The phone number is not yet being used")
    @JvmField val USERS_TOO_FEW = RpcError(400, "USERS_TOO_FEW", "Not enough users (to create a chat, for example)")
    @JvmField val USERS_TOO_MUCH = RpcError(400, "USERS_TOO_MUCH", "The maximum number of users has been exceeded (to create a chat, for example)")
    @JvmField val TYPE_CONSTRUCTOR_INVALID = RpcError(400, "TYPE_CONSTRUCTOR_INVALID", "The type constructor is invalid")
    @JvmField val FILE_PART_INVALID = RpcError(400, "FILE_PART_INVALID", "The file part number is invalid")
    @JvmField val FILE_PARTS_INVALID = RpcError(400, "FILE_PARTS_INVALID", "The number of file parts is invalid")
    @JvmField val FILE_PART_X_MISSING = RpcError(400, "FILE_PART_Х_MISSING", "Part X (where X is a number) of the file is missing from storage")
    @JvmField val MD5_CHECKSUM_INVALID = RpcError(400, "MD5_CHECKSUM_INVALID", "The MD5 checksums do not match")
    @JvmField val PHOTO_INVALID_DIMENSIONS = RpcError(400, "PHOTO_INVALID_DIMENSIONS", "The photo dimensions are invalid")
    @JvmField val FIELD_NAME_INVALID = RpcError(400, "FIELD_NAME_INVALID", "The field with the name FIELD_NAME is invalid")
    @JvmField val FIELD_NAME_EMPTY = RpcError(400, "FIELD_NAME_EMPTY", "The field with the name FIELD_NAME is missing")
    @JvmField val MSG_WAIT_FAILED = RpcError(400, "MSG_WAIT_FAILED", "A waiting call returned an error")

    // 401 UNAUTHORIZED
    /** Not signed in */
    @JvmField val AUTH_KEY_UNREGISTERED = RpcError(401, "AUTH_KEY_UNREGISTERED", "The key is not registered in the system")
    @JvmField val AUTH_KEY_INVALID = RpcError(401, "AUTH_KEY_INVALID", "The key is invalid")
    @JvmField val USER_DEACTIVATED = RpcError(401, "USER_DEACTIVATED", "The user has been deleted/deactivated")
    @JvmField val SESSION_REVOKED = RpcError(401, "SESSION_REVOKED", "The authorization has been invalidated, because of the user terminating all sessions")
    @JvmField val SESSION_EXPIRED = RpcError(401, "SESSION_EXPIRED", "The authorization has expired")
    @JvmField val ACTIVE_USER_REQUIRED = RpcError(401, "ACTIVE_USER_REQUIRED", "The method is only available to already activated users")
    @JvmField val AUTH_KEY_PERM_EMPTY = RpcError(401, "AUTH_KEY_PERM_EMPTY", "The method is unavailble for temporary authorization key, not bound to permanent")
    @JvmField val FLOOD_WAIT_X = RpcError(401, "FLOOD_WAIT_X", "A wait of X seconds is required (where X is a number)")
}

data class RpcError(val code: Int, val type: String, val description: String) {

    override fun toString() = "$code $type: $description"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RpcError

        if (code != other.code) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code
        result = 31 * result + type.hashCode()
        return result
    }

    fun oneOf(vararg errors: RpcError): Boolean = errors.contains(this)
}

// @formatter:on
fun RpcErrorException.getError() = RpcError(code,
                                            type.replace(MTRpcError.NUMBER_REGEX, "X"),
                                            "")

// Generate field list by input from https://core.telegram.org/api/errors
// regex /^([A-Z_0-9]+)(: (.+))?/
//fun main(args: Array<String>) {
//    val input = """
//        """
//
//    input.split('\n').filter { it.isNotBlank() }
//            .map { it.split(": ").map { it.trim() } }
//            .map { """    @JvmField val ${it[0]} = RpcError(400, "${it[0]}", "${it[1]}")""" }
//            .forEach { println(it) }
//}
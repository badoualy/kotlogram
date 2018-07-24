package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException

object Kotlogram {

    private val logger = LoggerFactory.getLogger(Kotlogram::class.java)!!

    @JvmField
    val apiLayer = 82

    @JvmField
    var testMode = false

    @JvmField
    var defaultTestDc = 2

    @JvmField
    var defaultProdDc = 4

    private val prodDcByIdMap = mapOf(
            1 to DataCenter(1, "149.154.175.50", "2001:0b28:f23d:f001:0000:0000:0000:000a", 443),
            2 to DataCenter(2, "149.154.167.51", "2001:067c:04e8:f002:0000:0000:0000:000a", 443),
            3 to DataCenter(3, "149.154.175.100", "2001:0b28:f23d:f003:0000:0000:0000:000a", 443),
            4 to DataCenter(4, "149.154.167.91", "2001:067c:04e8:f004:0000:0000:0000:000a", 443),
            5 to DataCenter(5, "91.108.56.165", "2001:0b28:f23f:f005:0000:0000:0000:000a", 443)
    )

    private val testDcByIdMap = mapOf(
            1 to DataCenter(1, "149.154.175.10", "2001:b28:f23d:f001::e", 443),
            2 to DataCenter(2, "149.154.167.40", "2001:67c:4e8:f002::e", 443),
            3 to DataCenter(3, "149.154.175.117", "2001:b28:f23d:f003::e", 443)
    )

    init {
        logger.info("""
         __  ___   ______   .___________. __        ______     _______ .______          ___      .___  ___.
        |  |/  /  /  __  \  |           ||  |      /  __  \   /  _____||   _  \        /   \     |   \/   |
        |  '  /  |  |  |  | `---|  |----`|  |     |  |  |  | |  |  __  |  |_)  |      /  ^  \    |  \  /  |
        |    <   |  |  |  |     |  |     |  |     |  |  |  | |  | |_ | |      /      /  /_\  \   |  |\/|  |
        |  .  \  |  `--'  |     |  |     |  `----.|  `--'  | |  |__| | |  |\  \----./  _____  \  |  |  |  |
        |__|\__\  \______/      |__|     |_______| \______/   \______| | _| `._____/__/     \__\ |__|  |__|
        Using layer $apiLayer
        """)
    }

    @JvmOverloads
    @JvmStatic
    fun getClient(application: TelegramApp,
                  apiStorage: TelegramApiStorage,
                  preferredDataCenter: DataCenter = getDcById(if (testMode) defaultTestDc else defaultProdDc),
                  tag: String = RandomUtils.randomInt().toString()): TelegramClient =
            TelegramClientImpl(application, apiStorage, preferredDataCenter, tag)

    @JvmStatic
    fun getDcById(id: Int) = (if (testMode) testDcByIdMap[id] else prodDcByIdMap[id])
            ?: throw IllegalArgumentException("Unkwnown DataCenter id: $id")

}


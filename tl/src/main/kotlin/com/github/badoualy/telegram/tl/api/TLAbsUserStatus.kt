package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [userStatusEmpty#9d05049][TLUserStatusEmpty]
 * * [userStatusLastMonth#77ebc742][TLUserStatusLastMonth]
 * * [userStatusLastWeek#7bf09fc][TLUserStatusLastWeek]
 * * [userStatusOffline#8c703f][TLUserStatusOffline]
 * * [userStatusOnline#edb93949][TLUserStatusOnline]
 * * [userStatusRecently#e26f42f1][TLUserStatusRecently]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUserStatus : TLObject()

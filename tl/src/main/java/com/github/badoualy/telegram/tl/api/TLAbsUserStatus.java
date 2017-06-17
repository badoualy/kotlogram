package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUserStatusEmpty}: userStatusEmpty#9d05049</li>
 * <li>{@link TLUserStatusLastMonth}: userStatusLastMonth#77ebc742</li>
 * <li>{@link TLUserStatusLastWeek}: userStatusLastWeek#7bf09fc</li>
 * <li>{@link TLUserStatusOffline}: userStatusOffline#8c703f</li>
 * <li>{@link TLUserStatusOnline}: userStatusOnline#edb93949</li>
 * <li>{@link TLUserStatusRecently}: userStatusRecently#e26f42f1</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUserStatus extends TLObject {

    public TLAbsUserStatus() {
    }
}

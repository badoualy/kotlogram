package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessageMediaContact}: messageMediaContact#5e7d2f39</li>
 * <li>{@link TLMessageMediaDocument}: messageMediaDocument#f3e02ea8</li>
 * <li>{@link TLMessageMediaEmpty}: messageMediaEmpty#3ded6320</li>
 * <li>{@link TLMessageMediaGame}: messageMediaGame#fdb19008</li>
 * <li>{@link TLMessageMediaGeo}: messageMediaGeo#56e0d474</li>
 * <li>{@link TLMessageMediaInvoice}: messageMediaInvoice#84551347</li>
 * <li>{@link TLMessageMediaPhoto}: messageMediaPhoto#3d8ce53d</li>
 * <li>{@link TLMessageMediaUnsupported}: messageMediaUnsupported#9f84f49e</li>
 * <li>{@link TLMessageMediaVenue}: messageMediaVenue#7912b71f</li>
 * <li>{@link TLMessageMediaWebPage}: messageMediaWebPage#a32dd600</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageMedia extends TLObject {

    public TLAbsMessageMedia() {
    }
}

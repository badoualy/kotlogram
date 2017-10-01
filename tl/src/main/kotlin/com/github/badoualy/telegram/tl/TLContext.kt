package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.UnsupportedConstructorException
import java.util.*

/**
 * TypeLanguage context object.
 * All known classes must be registered in context for deserialization.
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
abstract class TLContext(size: Int) {

    private var registeredClasses: HashMap<Int, Class<out TLObject>> = HashMap(size)

    protected abstract fun registerClasses()

    fun <T : TLObject> registerClass(constructorId: Int, clazz: Class<T>) {
        registeredClasses.put(constructorId, clazz)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : TLObject> get(constructorId: Int): Class<T> = (registeredClasses[constructorId] ?:
            throw UnsupportedConstructorException(constructorId)) as Class<T>

    operator fun contains(constructorId: Int) = registeredClasses.containsKey(constructorId)

    operator fun contains(tlObject: TLObject) = contains(tlObject.constructorId)
}

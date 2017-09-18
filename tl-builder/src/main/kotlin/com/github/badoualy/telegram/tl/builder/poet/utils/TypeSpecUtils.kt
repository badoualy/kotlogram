package com.github.badoualy.telegram.tl.builder.poet.utils

import com.github.badoualy.telegram.tl.builder.poet.*
import com.squareup.kotlinpoet.*
import java.io.File
import kotlin.reflect.KClass

fun TypeSpec.Companion.makeInterface(name: String, superInterfaceList: List<TypeName> = emptyList()) =
        TypeSpec.interfaceBuilder(name)
                .applyCommon()
                .apply {
                    superInterfaceList.forEach { addSuperinterface(it) }
                }

fun TypeSpec.Companion.makeTLMethodClass(name: String, responseType: TypeName) =
        TypeSpec.makeTLClass(name, ParameterizedTypeName.get(TYPE_TL_METHOD, responseType))

fun TypeSpec.Companion.makeTLClass(name: String, superclass: TypeName = TYPE_TL_OBJECT) =
        makeClass(name).superclass(superclass)

fun TypeSpec.Companion.makeClass(name: String) = TypeSpec.classBuilder(name).applyCommon()

fun TypeSpec.Builder.applyCommon() =
        addModifiers(KModifier.PUBLIC)
                .addKdoc(JAVADOC_AUTHOR)
                .addKdoc(JAVADOC_SEE)

fun TypeSpec.Builder.emptyConstructor() = apply {
    primaryConstructor(FunSpec.constructorBuilder().build())
}

fun TypeSpec.writeToFile(packageName: String, outputDir: String) {
    FileSpec.builder(packageName, name!!)
            .addStaticImport(TYPE_STREAM_UTILS, "*")
            .addStaticImport(TYPE_TLOBJECT_UTILS, "*")
            .indent("    ")
            .addType(this)
            .build()
            .writeTo(File(outputDir))
}

fun FunSpec.Builder.addAnnotation(type: KClass<*>, value: String) = apply {
    addAnnotation(AnnotationSpec.builder(type)
                          .addMember("value", value)
                          .build())
}

fun FunSpec.Builder.addThrows(vararg clazz: KClass<*>) = apply {
    addAnnotation(AnnotationSpec.builder(Throws::class)
                          .addMember("value",
                                     clazz.joinToString(",") { "%T::class" },
                                     clazz)
                          .build())
}

fun FunSpec.Builder.addThrowsByTypename(vararg clazz: TypeName) = apply {
    addAnnotation(AnnotationSpec.builder(Throws::class)
                          .addMember("value",
                                     clazz.joinToString(",") { "%T::class" },
                                     clazz)
                          .build())
}


fun FunSpec.Companion.makeOverride(name: String, isPublic: Boolean = true) =
        FunSpec.builder(name)
                .addModifiers(if (isPublic) KModifier.PUBLIC else KModifier.PROTECTED,
                              KModifier.OVERRIDE)

fun ClassName.Companion.get(packageName: String, className: String) =
        bestGuess("$packageName.$className")

fun TypeVariableName.Companion.T() = TypeVariableName.invoke("T")
fun TypeVariableName.Companion.ofTLObject() = TypeVariableName.invoke("T", TYPE_TL_OBJECT)
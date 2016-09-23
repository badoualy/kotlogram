package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.OUTPUT
import com.github.badoualy.telegram.tl.builder.uCamelCase
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.File
import javax.lang.model.element.Modifier

fun generateGetter(realName: String, fieldName: String, fieldType: TypeName) =
        MethodSpec.methodBuilder("get${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .returns(fieldType)
                .addStatement("return $fieldName")
                .build()!!

fun generateSetter(realName: String, fieldName: String, fieldType: TypeName) =
        MethodSpec.methodBuilder("set${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(fieldType, fieldName)
                .addStatement("this.$fieldName = $fieldName")
                .build()!!

fun writeClassToFile(packageName: String, clazz: TypeSpec, output: String = OUTPUT) {
    JavaFile.builder(packageName, clazz)
            .addStaticImport(TYPE_STREAM_UTILS, "*")
            .addStaticImport(TYPE_TLOBJECT_UTILS, "*")
            .indent("    ")
            .build().writeTo(File(output))
}

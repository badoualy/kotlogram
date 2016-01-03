package com.github.badoualy.telegram.tl.builder

var JavaImports = """
import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

"""

var JavaClassTemplate =
        """
package {package};
""" + JavaImports + """
public class {name} extends TLObject {

    public static final int CLASS_ID = {class_id};

    public {name}() {

    }

{constructor}

    public int getClassId() {
        return CLASS_ID;
    }

{fields}
{getter-setters}
{serialize}
{deserialize}
{to_string}
}
"""

var JavaReactiveApiWrapperTemplate =
        """
package {package};
""" + JavaImports + """
import {package}.requests.*;

/** Generated class that implements TelegramApi methods with a default behavior, and make the implementation more
convenient by just having to implement a method to execute the RPC (Remote Procedure Call) query */
public abstract class TelegramReactiveApiWrapper implements TelegramReactiveApi {

    public abstract <T extends TLObject> Observable<T> executeRpcQuery(TLMethod<T> method) throws IOException;
{methods}
}
"""

var JavaApiWrapperTemplate =
        """
package {package};
""" + JavaImports + """
import {package}.requests.*;

/** Generated class that implements TelegramApi methods with a default synchronous behavior, and make the implementation more
convenient by just having to implement a method to execute the RPC (Remote Procedure Call) query */
public abstract class TelegramApiWrapper implements TelegramApi {

    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws IOException;
{methods}
}
"""

var JavaReactiveApiTemplate =
        """
package {package};
""" + JavaImports + """
import {package}.requests.*;

public interface TelegramReactiveApi {
{methods}
}
"""

var JavaApiTemplate =
        """
package {package};
""" + JavaImports + """
import {package}.requests.*;

public interface TelegramApi {
{methods}
}
"""

var JavaApiWrapperMethod =
        """
    @Override
    public {return_type} {method_name}({args}) throws IOException {
        return executeRpcQuery(new {method_class}({method_args}));
    }
"""

var JavaApiMethodPrototype =
        """
    {return_type} {method_name}({args}) throws IOException;
"""


var JavaContextTemplate =
        """
package {package};
""" + JavaImports + """
public class TLApiContext extends TLContext {

    private static TLApiContext instance;

    public static TLApiContext getInstance() {
        if (instance == null)
            instance = new TLApiContext();
        return instance;
    }

    protected void init() {
{init}
    }
}
"""

var JavaContextIntRecord = """
        registerClass({id}, {type}.class);"""

var JavaMethodTemplate =
        """
package {package};
""" + JavaImports + """
public class {name} extends TLMethod<{return_type}> {

    public static final int CLASS_ID = {class_id};

    public int getClassId() {
        return CLASS_ID;
    }

{constructor}

{responseParser}

{fields}
{getter-setters}
{serialize}
{deserialize}

{to_string}
}
"""

var JavaMethodParserBodyGeneral = """
        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof {return_type}) {
            return ({return_type})res;
        }
        else {
            throw new IOException("Incorrect response type. Expected {return_type}, got: " + res.getClass().getCanonicalName());
        }
"""

var JavaMethodParserBodyVector = """
        return readTLVector(stream, context);
"""

var JavaMethodParserBodyIntVector = """
        return readTLIntVector(stream, context);
"""

var JavaMethodParserBodyLongVector = """
        return readTLLongVector(stream, context);
"""

var JavaMethodParserBodyReference = """
        return ({return_type}) {int}.deserializeResponse(stream, context);
"""

var JavaMethodParserTemplate =
        """
    public {return_type} deserializeResponse(InputStream stream, TLContext context) throws IOException {
{body}
    }
        """

var JavaAbsClassTemplate =
        """
package {package};

""" + JavaImports + """

public abstract class {name} extends TLObject {
{fields}
{getter-setters}
}
"""

var JavaChildClassTemplate =
        """
package {package};

""" + JavaImports + """

public class {name} extends {base-name} {
    public static final int CLASS_ID = {class_id};

    public {name}() {

    }

{constructor}

    public int getClassId() {
        return CLASS_ID;
    }

{fields}
{getter-setters}
{serialize}
{deserialize}

{to_string}
}
"""

var JavaToStringTemplate = """
    @Override
    public String toString() {
        return "{value}";
    }
"""

var JavaFieldTemplate = """
    protected {type} {int};
"""
var JavaGetterSetterTemplate = """
    public {type} {getter}() {
        return {int};
    }

    public void {setter}({type} value) {
        this.{int} = value;
    }
"""

var JavaDeserializeTemplate = """
    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
{body}
    }
"""

var JavaSerializeTemplate = """
    @Override
    public void serializeBody(OutputStream stream) throws IOException {
{body}
    }
"""

var JavaConstructorTemplate = """
    public {name}({args}) {
{body}
    }
"""

var JavaConstructorArgTemplate = """        {type} _{int}""";
var JavaConstructorBodyTemplate = """        this.{int} = _{int};""";

var JavaSerializeInt = """
        writeInt(this.{int}, stream);"""

var JavaDeserializeInt = """
        this.{int} = readInt(stream);"""

var JavaSerializeLong = """
        writeLong(this.{int}, stream);"""

var JavaDeserializeLong = """
        this.{int} = readLong(stream);"""

var JavaSerializeDouble = """
        writeDouble(this.{int}, stream);"""

var JavaDeserializeDouble = """
        this.{int} = readDouble(stream);"""

var JavaSerializeString = """
        writeTLString(this.{int}, stream);"""

var JavaDeserializeString = """
        this.{int} = readTLString(stream);"""

var JavaSerializeBoolean = """
        writeTLBool(this.{int}, stream);"""

var JavaDeserializeBoolean = """
        this.{int} = readTLBool(stream);"""

var JavaSerializeBytes = """
        writeTLBytes(this.{int}, stream);"""

var JavaDeserializeBytes = """
        this.{int} = readTLBytes(stream, context);"""

var JavaSerializeObject = """
        writeTLObject(this.{int}, stream);"""

var JavaSerializeFunctional = """
        writeTLMethod(this.{int}, stream);"""

var JavaDeserializeObject = """
        this.{int} = ({type})readTLObject(stream, context);"""

var JavaDeserializeFunctional = """
        this.{int} = readTLMethod(stream, context);"""

var JavaSerializeVector = """
        writeTLVector(this.{int}, stream);"""

var JavaDeserializeVector = """
        this.{int} = readTLVector(stream, context);"""

var JavaDeserializeIntVector = """
        this.{int} = readTLIntVector(stream, context);"""

var JavaDeserializeStringVector = """
        this.{int} = readTLStringVector(stream, context);"""

var JavaDeserializeLongVector = """
        this.{int} = readTLLongVector(stream, context);"""
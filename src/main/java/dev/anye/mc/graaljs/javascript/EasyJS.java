package dev.anye.mc.graaljs.javascript;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class EasyJS {
    private final Context context;
    private final Value bindings;


    public static EasyJS creat(){
        return new EasyJS();
    }
    public static EasyJS NotSafe(){
        return new EasyJS( Context.newBuilder("js")
                .allowAllAccess(true)
                .option("engine.WarnInterpreterOnly", "false")
                .build());
    }
    public EasyJS(Context context, Value bindings){
        this.context = context;
        this.bindings = bindings;
    }
    public EasyJS(Context context){
        this.context = context;
        this.bindings = context.getBindings("js");
    }
    public EasyJS(){
        context = Context.create("js");
        bindings = context.getBindings("js");
    }
    public Context getEngine() {
        return context;
    }
    public EasyJS addParameter(String name , Object value){
        this.bindings.putMember(name,value);
        return this;
    }
    public EasyJS setParameter(Map<String,Object> map){
        map.forEach(bindings::putMember);
        return this;
    }
    public Object runCode(String code){
        return context.eval("js",code);
    }
    public Object runFile(String file){
        try {
            return context.eval(Source.newBuilder("js",new FileReader(file),"").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Object runFile(Reader file){
        try {
            return context.eval(Source.newBuilder("js",file,"").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

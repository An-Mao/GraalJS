package dev.anye.mc.graaljs;

import com.mojang.logging.LogUtils;
import dev.anye.mc.graaljs.javascript.EasyJS;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GraalJS.MODID)
public class GraalJS
{
    public static final String MODID = "graaljs";
    private static final Logger LOGGER = LogUtils.getLogger();
    public GraalJS(FMLJavaModLoadingContext context)
    {
        this();
    }
    public GraalJS()
    {

        LOGGER.info("[GraalJS Test] 1 + 1 = {}", EasyJS.NotSafe().runCode("1+1"));
    }

}

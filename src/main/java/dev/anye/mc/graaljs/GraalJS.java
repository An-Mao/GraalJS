package dev.anye.mc.graaljs;

import com.mojang.logging.LogUtils;

import dev.anye.mc.graaljs.javascript.EasyJS;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(GraalJS.MOD_ID)
public class GraalJS
{
    public  static final String MOD_ID = "graaljs";
    private static final Logger LOGGER = LogUtils.getLogger();
    public GraalJS()
    {
        LOGGER.info("[GraalJS Test] 1 + 1 = {}",EasyJS.NotSafe().runCode("1+1"));
    }

}

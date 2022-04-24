package io.github.dotheflopboy.basic.util;

import io.github.dotheflopboy.basic.Basic;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class Messages {


    public static Component message(String path){
        String text = Basic.getPlugin().getConfig().getString(path);
        final Component message = LegacyComponentSerializer.legacyAmpersand().deserialize(text);
        return message;
    }


}

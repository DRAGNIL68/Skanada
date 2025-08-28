package net.outmoded.skanada.syntax.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.VoxelShape;

import javax.annotation.Nullable;

public class TypeBoundingBox {

    static {
        Classes.registerClass(new ClassInfo<>(BoundingBox.class, "boundingbox")
                .user("boundingboxs?")
                .name("boundingbox")
                .description("N/A")
                .examples("N/A")
                .defaultExpression(new EventValueExpression<>(BoundingBox.class))
                .parser(new Parser<BoundingBox>() {

                    @Override
                    @Nullable
                    public BoundingBox parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toVariableNameString(BoundingBox boundingBox) {
                        return boundingBox.toString();
                    }


                    @Override
                    public String toString(BoundingBox boundingBox, int flags) {
                        return toVariableNameString(boundingBox);
                    }




                }));
    }


}

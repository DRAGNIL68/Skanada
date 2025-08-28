package net.outmoded.skanada.syntax.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import io.papermc.paper.block.fluid.FluidData;
import org.bukkit.util.VoxelShape;

import javax.annotation.Nullable;

public class TypeVoxelShape {

    static {
        Classes.registerClass(new ClassInfo<>(VoxelShape.class, "voxelshape")
                .user("voxelshapes?")
                .name("voxelshape")
                .description("N/A")
                .examples("N/A")
                .defaultExpression(new EventValueExpression<>(VoxelShape.class))
                .parser(new Parser<VoxelShape>() {

                    @Override
                    @Nullable
                    public VoxelShape parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toVariableNameString(VoxelShape voxelShape) {
                        return voxelShape.toString();
                    }


                    @Override
                    public String toString(VoxelShape voxelShape, int flags) {
                        return toVariableNameString(voxelShape);
                    }




                }));
    }


}

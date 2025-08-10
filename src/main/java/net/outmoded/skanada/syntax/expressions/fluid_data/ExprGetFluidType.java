package net.outmoded.skanada.syntax.expressions.fluid_data;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import io.papermc.paper.block.fluid.FluidData;
import org.bukkit.event.Event;

import javax.annotation.Nullable;


public class ExprGetFluidType extends SimpleExpression<String> {

    static {
        Skript.registerExpression(ExprGetFluidType.class, String.class, ExpressionType.COMBINED, "[skanada] [get] (fluid-type|fluid type) of %fluiddata%");
    }
    private Expression<FluidData> fluidDataExpression;

    @Override
    public Class<? extends String> getReturnType() {
        //1
        return String.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        fluidDataExpression = (Expression<FluidData>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return "";
    }

    @Override
    @Nullable
    protected String[] get(Event event) {

        FluidData fluidData = fluidDataExpression.getSingle(event);
        if (fluidData != null){
            return new String[]{fluidData.getFluidType().toString()};

        }

        return null;

    }
}


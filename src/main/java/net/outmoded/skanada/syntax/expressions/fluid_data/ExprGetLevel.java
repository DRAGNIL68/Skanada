package net.outmoded.skanada.syntax.expressions.fluid_data;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import io.papermc.paper.block.fluid.FluidData;
import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.lang.Integer;


public class ExprGetLevel extends SimpleExpression<Integer> {
    
    static {
        Skript.registerExpression(ExprGetLevel.class, Integer.class, ExpressionType.COMBINED, "[skanada] [get] (fluid-level|fluid level) of %fluiddata%");
    }
    private Expression<FluidData> fluidDataExpression;

    @Override
    public Class<? extends Integer> getReturnType() {
        //1
        return Integer.class;
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
    protected Integer[] get(Event event) {

        FluidData fluidData = fluidDataExpression.getSingle(event);
        if (fluidData != null){
            return new Integer[]{fluidData.getLevel()};

        }

        return null;

    }
}


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


public class ExprGetHeight extends SimpleExpression<Float> {
    
    static {
        Skript.registerExpression(ExprGetHeight.class, Float.class, ExpressionType.COMBINED, "[skanada] [get] [compute] (fluid-height|fluid height) %location% of %fluiddata%");
    }
    private Expression<FluidData> fluidDataExpression;
    private Expression<Location> locationExpression;

    @Override
    public Class<? extends Float> getReturnType() {
        //1
        return Float.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        fluidDataExpression = (Expression<FluidData>) exprs[1];
        locationExpression = (Expression<Location>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return "";
    }

    @Override
    @Nullable
    protected Float[] get(Event event) {
        Location location = locationExpression.getSingle(event);
        FluidData fluidData = fluidDataExpression.getSingle(event);
        if (fluidData != null && location != null){
            return new Float[]{fluidData.computeHeight(location)};

        }

        return null;

    }
}


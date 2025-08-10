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
import org.bukkit.util.Vector;

import javax.annotation.Nullable;


public class ExprGetFlowDirection extends SimpleExpression<Vector> {
    
    static {
        Skript.registerExpression(ExprGetFlowDirection.class, Vector.class, ExpressionType.COMBINED, "[skanada] [get] [compute] (fluid-direction|fluid direction) %location% of %fluiddata%");
    }
    private Expression<FluidData> fluidDataExpression;
    private Expression<Location> locationExpression;

    @Override
    public Class<? extends Vector> getReturnType() {
        //1
        return Vector.class;
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
    protected Vector[] get(Event event) {
        Location location = locationExpression.getSingle(event);
        FluidData fluidData = fluidDataExpression.getSingle(event);
        if (fluidData != null && location != null){
            return new Vector[]{fluidData.computeFlowDirection(location)};

        }

        return null;

    }
}


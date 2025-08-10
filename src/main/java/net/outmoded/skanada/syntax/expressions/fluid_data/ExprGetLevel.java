package net.outmoded.skanada.syntax.expressions;

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


public class ExprGetFluidData extends SimpleExpression<FluidData> {
    
    static {
        Skript.registerExpression(ExprGetFluidData.class, FluidData.class, ExpressionType.COMBINED, "[skanada] [get] (fluid-data|fluiddata|fluid data) of %location%");
    }
    private Expression<Location> locationExpression;

    @Override
    public Class<? extends FluidData> getReturnType() {
        //1
        return FluidData.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
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
    protected FluidData[] get(Event event) {
    //FluidData fluidData;
    //fluidData.getLevel();
    //fluidData.getFluidType();
    //fluidData.computeFlowDirection();
    //fluidData.computeHeight();


        Location location = locationExpression.getSingle(event);
        if (location != null){
            FluidData fluidData = location.getWorld().getFluidData(location);
            if (fluidData != null)
                return new FluidData[]{fluidData};

        }

        return null;

    }
}


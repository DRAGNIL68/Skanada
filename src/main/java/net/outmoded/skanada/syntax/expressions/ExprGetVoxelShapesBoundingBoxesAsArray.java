package net.outmoded.skanada.syntax.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.VoxelShape;

import javax.annotation.Nullable;


public class ExprGetVoxelShapesBoundingBoxesAsArray extends SimpleExpression<BoundingBox> {
    
    static {
        Skript.registerExpression(ExprGetVoxelShapesBoundingBoxesAsArray.class, BoundingBox.class, ExpressionType.COMBINED, "[skanada] [get] (bounding boxes|bounding-boxes) of %voxelshape%");
    }
    private Expression<VoxelShape> voxelShapeExpression;

    @Override
    public Class<? extends BoundingBox> getReturnType() {
        //1
        return BoundingBox.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return false;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        voxelShapeExpression = (Expression<VoxelShape>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return "";
    }

    @Override
    @Nullable
    protected BoundingBox[] get(Event event) {

        VoxelShape voxelShape = voxelShapeExpression.getSingle(event);
        if (voxelShape != null){

            return voxelShape.getBoundingBoxes().toArray(BoundingBox[]::new);

        }

        return null;

    }
}


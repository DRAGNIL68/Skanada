package net.outmoded.skanada.syntax.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;
import org.joml.Vector3f;

import javax.annotation.Nullable;


public class ExprConvertSkbeeQuatToSkriptQuat extends SimpleExpression<Vector> {
    
    static {
        Skript.registerExpression(ExprConvertSkbeeQuatToSkriptQuat.class, Vector.class, ExpressionType.COMBINED, "[skanada] to %vector3f% as vector"); // set {_vec1} to {_vec} as vector
    }
    private Expression<Vector3f> vector3fExpression;

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
        vector3fExpression = (Expression<Vector3f>) exprs[0];
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
        Vector3f vector3f = vector3fExpression.getSingle(event);
        if (vector3f != null){
            return new Vector[]{new Vector(vector3f.x, vector3f.y, vector3f.z)};

        }

        return null;

    }
}


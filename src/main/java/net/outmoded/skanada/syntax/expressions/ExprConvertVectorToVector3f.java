package net.outmoded.skanada.syntax.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.jme3.bullet.objects.PhysicsRigidBody;
import com.jme3.math.Vector3f;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;


import javax.annotation.Nullable;


public class ExprConvertVectorToVector3f extends SimpleExpression<Vector3f> {
    
    static {
        Skript.registerExpression(ExprConvertVectorToVector3f.class, Vector3f.class, ExpressionType.COMBINED, "[skanada] %vector% as vector3f"); // set {_vec1} to {_vec} as vector
    }
    private Expression<Vector> vectorExpression;

    @Override
    public Class<? extends Vector3f> getReturnType() {
        //1
        return Vector3f.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        vectorExpression = (Expression<Vector>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return "";
    }

    @Override
    @Nullable
    protected Vector3f[] get(Event event) {
        Vector vector = vectorExpression.getSingle(event);
        if (vector != null){
            return new Vector3f[]{new Vector3f((float) vector.getX(), (float) vector.getY(), (float) vector.getZ())};

        }

        return null;

    }
}


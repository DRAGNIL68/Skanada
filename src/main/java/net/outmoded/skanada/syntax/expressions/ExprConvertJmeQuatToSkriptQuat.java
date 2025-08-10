package net.outmoded.skanada.syntax.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.jme3.math.Quaternion;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;


public class ExprConvertJmeQuatToSkriptQuat extends SimpleExpression<Quaternionf> {
    
    static {
        Skript.registerExpression(ExprConvertJmeQuatToSkriptQuat.class, Quaternionf.class, ExpressionType.COMBINED, "[skanada] jmequaternion %jmequaternion% as quaternion");
    }
    private Expression<Quaternion> jmeQuaternionExpression;

    @Override
    public Class<? extends Quaternionf> getReturnType() {
        //1
        return Quaternionf.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        jmeQuaternionExpression = (Expression<Quaternion>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return "";
    }

    @Override
    @Nullable
    protected Quaternionf[] get(Event event) {
        com.jme3.math.Quaternion jmeQuaternion = jmeQuaternionExpression.getSingle(event);
        if (jmeQuaternion != null){
            Quaternionf quaternionf = new Quaternionf(jmeQuaternion.getX(), jmeQuaternion.getY(), jmeQuaternion.getZ(), jmeQuaternion.getW());
            return new Quaternionf[]{quaternionf};

        }

        return null;

    }
}


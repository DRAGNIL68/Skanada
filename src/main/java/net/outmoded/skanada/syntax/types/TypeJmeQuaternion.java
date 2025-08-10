package net.outmoded.skanada.syntax.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.jme3.math.Quaternion;

import javax.annotation.Nullable;

public class TypeJmeQuaternion {

    static {
        Classes.registerClass(new ClassInfo<>(Quaternion.class, "jmequaternion")
                .user("jmequaternions?")
                .name("jmequaternion")
                .description("N/A")
                .examples("N/A")
                .defaultExpression(new EventValueExpression<>(Quaternion.class))
                .parser(new Parser<Quaternion>() {

                    @Override
                    @Nullable
                    public Quaternion parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toVariableNameString(Quaternion Quaternion) {
                        return Quaternion.toString();
                    }


                    @Override
                    public String toString(Quaternion Quaternion, int flags) {
                        return toVariableNameString(Quaternion);
                    }




                }));
    }


}

package net.outmoded.skanada.syntax.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;

import javax.annotation.Nullable;

public class Vector3f {

    static {
        Classes.registerClass(new ClassInfo<>(Vector3f.class, "vector3f")
                .user("vector3fs?")
                .name("vector3f")
                .description("N/A")
                .examples("N/A")
                .defaultExpression(new EventValueExpression<>(Vector3f.class))
                .parser(new Parser<Vector3f>() {

                    @Override
                    @Nullable
                    public Vector3f parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toVariableNameString(Vector3f vector3f) {
                        return "x: ";
                    }


                    @Override
                    public String toString(Vector3f vector3f, int flags) {
                        return toVariableNameString(vector3f);
                    }




                }));
    }


}
